/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gautham
 */

package graph;
import java.util.HashMap;
import java.util.Map.Entry;


public class AttackGraphConverter {
    
    public StringBuilder ConvertToGraph(AttackGraph graph){
        
        StringBuilder attack_graph=new StringBuilder();
        
         HashMap<Node,Integer> nodes=new HashMap<>();
       
        int counter=1;
        
        for(DerivedNode Nd : graph.getNd()){
        nodes.put(Nd,counter);
        counter++;
        }
        
        for(PrimitiveNode Np : graph.getNp()){
        nodes.put(Np,counter);
        counter++;
        }
        
        for(DerivationNode Nr : graph.getNr()){
        nodes.put(Nr,counter);
        counter++;
        }
        
        attack_graph.append("digraph G { ");
        attack_graph.append(System.getProperty("line.separator"));
        
        for(Entry<Node,Integer> graph_node:nodes.entrySet()){
           //labels and shapes data incomplete
    attack_graph.append(graph_node.getValue()+" [label="+"\""+"......"+"\""+",shape="+"...."+"]");
    attack_graph.append(System.getProperty("line.separator"));
    
    }
       
        
        for(Edge e : graph.getE()){
        attack_graph.append(nodes.get(e.getSource())+" -> "+nodes.get(e.getDestination()));
        attack_graph.append(System.getProperty("line.separator"));
        }
        
        attack_graph.append(" }");
        
        
        
        return attack_graph;
    
    
    }
    
}
