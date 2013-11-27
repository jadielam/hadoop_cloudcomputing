/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package graph;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.hadoop.io.Writable;
import org.apache.hadoop.io.MapWritable;
import org.apache.hadoop.io.IntWritable;

import objects.*;


/**
 *
 * @author Gautham
 */
public class LFunction {

	
	private HashMap<Node, FunctionElement> LFunction_Map;
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
    	
    	
    	if (!InvertedMap.containsKey(value)){
    		List<Node> list=new ArrayList<Node>();
    		list.add(key);
    		InvertedMap.put(value, list);
    		
    	}
    }
    
    public DerivedNode getDerivedNode(Fact f){
    	if (InvertedMap.containsKey(f)){
    		List<Node> l=InvertedMap.get(f);
    		for (Node n : l){
    			if (n instanceof DerivedNode){
    				return (DerivedNode)n;
    			}
    		}
    		
    		
    		
    	}
    	return null;
    }
    
    public Node getNode(Fact f){
    	if (InvertedMap.containsKey(f)){
    		List<Node> l=InvertedMap.get(f);
    		for (Node n : l){
    			return n;
    		}
    	}
    	return null;
    }
    
    public void addAll(LFunction lf){
    	if (lf!=null){
    		
    		Set<Entry<Node, FunctionElement>> entries=lf.LFunction_Map.entrySet();
        	for (Entry<Node, FunctionElement> e : entries){
        		Node n=(Node)e.getKey();
        		FunctionElement fe=(FunctionElement)e.getValue();
        		if (!this.LFunction_Map.containsKey(n)){
        			this.LFunction_Map.put(n, fe);
        		}
        		
        	}
    	}
    }

	  
    
}