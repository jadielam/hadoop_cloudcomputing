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


public String ConvertToGraph1(Graph graph){
	
	StringBuilder sb=new StringBuilder();
	sb.append("digraph G {");
	sb.append("\n");
	sb.append("1 [label=\"1:execCode('10.0.30.154',someUser):0\",shape=diamond];");
	sb.append("\n");
	sb.append("2 [label=\"2:RULE 2 (remote exploit of a server program):0\",shape=ellipse];");
	sb.append("\n");
	sb.append("3 [label=\"3:netAccess('10.0.30.154',tcp,'22'):0\",shape=diamond];");
	sb.append("\n");
	sb.append("4 [label=\"4:RULE 5 (multi-hop access):0\",shape=ellipse];");
	sb.append("\n");
	sb.append("5 [label=\"5:hacl('10.0.30.154','10.0.30.154',tcp,'22'):1\",shape=box];");
	sb.append("\n");
	sb.append("6 [label=\"6:RULE 5 (multi-hop access):0\",shape=ellipse];");
	sb.append("\n");
	sb.append("7 [label=\"7:hacl('10.0.30.255','10.0.30.154',tcp,'22'):1\",shape=box];");
	sb.append("\n");
	sb.append("8 [label=\"8:execCode('10.0.30.255',someUser):0\",shape=diamond];");
	sb.append("\n");
	sb.append("9 [label=\"9:RULE 2 (remote exploit of a server program):0\",shape=ellipse];");
	sb.append("\n");
	sb.append("10 [label=\"10:netAccess('10.0.30.255',tcp,'22'):0\",shape=diamond];");
	sb.append("11 [label=\"11:RULE 5 (multi-hop access):0\",shape=ellipse];");
	sb.append("\n");
	sb.append("12 [label=\"12:hacl('10.0.30.154','10.0.30.255',tcp,'22'):1\",shape=box];");
	sb.append("\n");
	sb.append("	13 [label=\"13:RULE 5 (multi-hop access):0\",shape=ellipse];");
	sb.append("\n");
	sb.append("5 -> 	4;");
	sb.append("\n");
	sb.append("1 -> 	4;");
	sb.append("\n");
	sb.append("4 -> 	3;");
	sb.append("\n");
	sb.append("7 -> 	6;");
	sb.append("\n");
	sb.append("12 -> 	11;");
	sb.append("\n");
	sb.append("1 -> 	11;");
	sb.append("\n");
	sb.append("11 -> 	10;");
	sb.append("\n");
	sb.append("14 -> 	13;");
	sb.append("\n");
	sb.append("8 -> 	13;");
	sb.append("\n");
	sb.append("13 -> 	10;");
	sb.append("\n");
	sb.append("}");

	return sb.toString();

}
}