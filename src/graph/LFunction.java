/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package graph;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
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
public class LFunction implements Writable {

	
	private MapWritable LFunction_Map;
	private MapWritable InvertedMap;
    
    public LFunction(){
    	LFunction_Map=new MapWritable();
    	InvertedMap=new MapWritable();
    }
        
    public MapWritable getLFunction_Map() {
        return LFunction_Map;
    }
    
    public void addEntry(Node key, FunctionElement value){
    	if (!LFunction_Map.containsKey(key)){
    		LFunction_Map.put(key, value);
    	}
    	
    	if (!InvertedMap.containsKey(value)){
    		InvertedMap.put(value, key);
    		
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
    		return (Node)InvertedMap.get(f);
    	}
    	return null;
    }
    
    public void addAll(LFunction lf){
    	if (lf!=null){
    		
    		Set<Entry<Writable, Writable>> entries=lf.LFunction_Map.entrySet();
        	for (Entry<Writable, Writable> e : entries){
        		Node n=(Node)e.getKey();
        		FunctionElement fe=(FunctionElement)e.getValue();
        		if (!this.LFunction_Map.containsKey(n)){
        			this.LFunction_Map.put(n, fe);
        		}
        		
        	}
    	}
    }

	@Override
	public void readFields(DataInput in) throws IOException {
		LFunction_Map.readFields(in);
		InvertedMap.readFields(in);
		
	}

	@Override
	public void write(DataOutput out) throws IOException {
		LFunction_Map.write(out);
		InvertedMap.write(out);
		
	}
   
    
}