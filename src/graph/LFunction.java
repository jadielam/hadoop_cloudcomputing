/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package graph;
import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import objects.*;


/**
 *
 * @author Gautham
 */
public class LFunction implements Serializable {

	private static final long serialVersionUID= 7526472295622776145L;
	
    private HashMap<Node,FunctionElement> LFunction_Map;
    private HashMap<FunctionElement, List<Node>> InvertedMap;
    
    public LFunction(){
    	LFunction_Map=new HashMap<Node, FunctionElement>();
    	InvertedMap=new HashMap<FunctionElement, List<Node>>();
    }
        
    public HashMap<Node, FunctionElement> getLFunction_Map() {
        return LFunction_Map;
    }
    
    public void addEntry(Node key, FunctionElement value){
    	if (!LFunction_Map.containsKey(key)){
    		LFunction_Map.put(key, value);
    	}
    	if (InvertedMap.containsKey(value)){
    		InvertedMap.get(value).add(key);
    		
    	}
    	else {
    		LinkedList<Node> list=new LinkedList<Node>();
    		list.add(key);
    		InvertedMap.put(value, list);
    	}
    }
    
    public DerivedNode getDerivedNode(Fact f){
    	if (InvertedMap.containsKey(f)){
    		List<Node> nodes=InvertedMap.get(f);
    		
    		for (Node node : nodes){
    			if (node instanceof DerivedNode){
    				return (DerivedNode) node;
    			}
    		}
    	}
    	return null;
    }
    
    public Node getNode(Fact f){
    	if (InvertedMap.containsKey(f)){
    		List<Node> nodes=InvertedMap.get(f);
    		
    		if (!nodes.isEmpty()){
    			return nodes.get(0);
    		}
    	}
    	return null;
    }
    
    public void addAll(LFunction lf){
    	if (lf!=null){
    		Set<Entry<Node, FunctionElement>> entries=lf.LFunction_Map.entrySet();
        	for (Entry<Node, FunctionElement> e : entries){
        		Node n=e.getKey();
        		FunctionElement fe=e.getValue();
        		if (!this.LFunction_Map.containsKey(n)){
        			this.LFunction_Map.put(n, fe);
        		}
        		
        	}
    	}
    }   
}