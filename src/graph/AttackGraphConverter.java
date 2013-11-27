/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gautham
 */

package graph;
import graphline.Graph;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.hadoop.io.MapWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;


public class AttackGraphConverter {
    
    public String ConvertToGraph(Graph graph){
        
        StringBuilder attack_graph=new StringBuilder();
        
         HashMap<Text, Integer> derivedNodes=new HashMap<Text, Integer>();
         HashMap<Text, Integer> derivationNodes=new HashMap<Text, Integer>();
         HashMap<Text, Integer> primitiveNodes=new HashMap<Text, Integer>();
         HashMap<Text ,Integer> nodes=new HashMap<Text, Integer>();
         int counter=1;
        
         MapWritable Nd=graph.getNd();
         Set<Entry<Writable, Writable>> entries=Nd.entrySet();
                
         for(Entry e: entries){
        	 derivedNodes.put((Text)e.getKey(),counter);
        	 nodes.put((Text)e.getKey(), counter);
        	 counter++;
         }
        
         MapWritable Nr=graph.getNr();
         Set<Entry<Writable, Writable>> entries1=Nr.entrySet();
        
         for(Entry e : entries1){
        	 derivationNodes.put((Text)e.getKey(),counter);
        	 nodes.put((Text)e.getKey(), counter);
        	 counter++;
         }
        
         MapWritable Np=graph.getNp();
         Set<Entry<Writable, Writable>> entries2=Nr.entrySet();
        
         for(Entry  e : entries2){
        	 primitiveNodes.put((Text)e.getKey(),counter);
        	 nodes.put((Text)e.getKey(), counter);
        	 counter++;
         }
        
        
        
         attack_graph.append("digraph G { ");
         attack_graph.append(System.getProperty("line.separator"));
        
         for(Entry<Text,Integer> graph_node:derivedNodes.entrySet()){
           //labels and shapes data incomplete
        	 
        	 attack_graph.append(graph_node.getValue()+" [label="+"\""+graph_node.getKey()+"\""+",shape=box]");
        	 attack_graph.append(System.getProperty("line.separator"));
    
         }
        
         for(Entry<Text,Integer> graph_node:derivationNodes.entrySet()){
           //labels and shapes data incomplete
        	 attack_graph.append(graph_node.getValue()+" [label="+"\""+graph_node.getKey()+"\""+",shape=diamond]");
        	 attack_graph.append(System.getProperty("line.separator"));
    
         }
       
         
         for(Entry<Text,Integer> graph_node:primitiveNodes.entrySet()){
        	 //labels and shapes data incomplete
        	 attack_graph.append(graph_node.getValue()+" [label="+"\""+graph_node.getKey()+"\""+",shape=ellipse]");
        	 attack_graph.append(System.getProperty("line.separator"));
    
         }
        
        
         MapWritable E=graph.getE();
         Set<Entry<Writable, Writable>> entries3=E.entrySet();
         for(Entry e : entries3){
        	 attack_graph.append((Text)e.getKey());
        	 attack_graph.append(System.getProperty("line.separator"));
         }
        
         attack_graph.append(" }");
        
        
        
         return attack_graph.toString();
    
    
    }

}