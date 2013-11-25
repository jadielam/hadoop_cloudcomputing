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
        
         HashMap<DerivedNode, Integer> drnodes=new HashMap<DerivedNode, Integer>();
         HashMap<DerivationNode, Integer> dvrnodes=new HashMap<DerivationNode, Integer>();
         HashMap<PrimitiveNode, Integer> prnodes=new HashMap<PrimitiveNode, Integer>();
         HashMap<Node,Integer> nodes=new HashMap<Node, Integer>();
        int counter=1;
        
        for(DerivedNode Nd : graph.getNd()){
        drnodes.put(Nd,counter);
        nodes.put(Nd, counter);
        counter++;
        }
        
        for(DerivationNode Nr : graph.getNr()){
        dvrnodes.put(Nr,counter);
        nodes.put(Nr, counter);
        counter++;
        }
        
        for(PrimitiveNode Np : graph.getNp()){
        prnodes.put(Np,counter);
        nodes.put(Np, counter);
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
        
        for(Edge e : graph.getE()){
        attack_graph.append(nodes.get(e.getSource())+" -> "+nodes.get(e.getDestination()));
        attack_graph.append(System.getProperty("line.separator"));
        }
        
        attack_graph.append(" }");
        
        
        
        return attack_graph;
    
    
    }
    
}