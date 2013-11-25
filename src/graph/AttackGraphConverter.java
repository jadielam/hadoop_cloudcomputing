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
import org.apache.hadoop.io.Writable;


public class AttackGraphConverter {
    
    public String ConvertToGraph(Graph graph){
        
        StringBuilder attack_graph=new StringBuilder();
        
         HashMap<DerivedNode, Integer> drnodes=new HashMap<DerivedNode, Integer>();
         HashMap<DerivationNode, Integer> dvrnodes=new HashMap<DerivationNode, Integer>();
         HashMap<PrimitiveNode, Integer> prnodes=new HashMap<PrimitiveNode, Integer>();
         HashMap<Node,Integer> nodes=new HashMap<Node, Integer>();
        int counter=1;
        
        MapWritable Nd=graph.getNd();
        Set<Entry<Writable, Writable>> entries=Nd.entrySet();
                
        for(Entry e: entries){
        	drnodes.put((DerivedNode)e.getKey(),counter);
        	nodes.put((DerivedNode)e.getKey(), counter);
        counter++;
        }
        
        MapWritable Nr=graph.getNr();
        Set<Entry<Writable, Writable>> entries1=Nr.entrySet();
        
        for(Entry e : entries1){
        dvrnodes.put((DerivationNode)e.getKey(),counter);
        nodes.put((DerivationNode)e.getKey(), counter);
        counter++;
        }
        
        MapWritable Np=graph.getNp();
        Set<Entry<Writable, Writable>> entries2=Nr.entrySet();
        
        for(Entry  e : entries2){
        prnodes.put((PrimitiveNode)e.getKey(),counter);
        nodes.put((PrimitiveNode)e.getKey(), counter);
        counter++;
        }
        
        
        
        attack_graph.append("digraph G { ");
        attack_graph.append(System.getProperty("line.separator"));
        
        for(Entry<DerivedNode,Integer> graph_node:drnodes.entrySet()){
           //labels and shapes data incomplete
    attack_graph.append(graph_node.getValue()+" [label="+"\""+graph_node.toString()+"\""+",shape=box]");
    attack_graph.append(System.getProperty("line.separator"));
    
    }
        
        for(Entry<DerivationNode,Integer> graph_node:dvrnodes.entrySet()){
           //labels and shapes data incomplete
    attack_graph.append(graph_node.getValue()+" [label="+"\""+graph_node.toString()+"\""+",shape=diamond]");
    attack_graph.append(System.getProperty("line.separator"));
    
    }
       
         
        for(Entry<PrimitiveNode,Integer> graph_node:prnodes.entrySet()){
           //labels and shapes data incomplete
    attack_graph.append(graph_node.getValue()+" [label="+"\""+graph_node.toString()+"\""+",shape=ellipse]");
    attack_graph.append(System.getProperty("line.separator"));
    
    }
        
        
        MapWritable E=graph.getE();
        Set<Entry<Writable, Writable>> entries3=E.entrySet();
        for(Entry e : entries3){
        	attack_graph.append(nodes.get((Edge)e.getKey())+" -> "+nodes.get((Edge)e.getKey()));
        	attack_graph.append(System.getProperty("line.separator"));
        }
        
        attack_graph.append(" }");
        
        
        
        return attack_graph.toString();
    
    
    }
}