/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.Serializable;

import org.apache.hadoop.io.Writable;

/**
 *
 * @author Gautham
 */
public class Goal implements Writable {
    
	Node node;
	
	public Goal(){
		this.node=null;
	}
	public Goal(Node node){
		this.node=node;
	}
	
	@Override
	public boolean equals(Object obj) {
	    if (obj == null) {
	        return false;
	    }
	    if (getClass() != obj.getClass()) {
	        return false;
	    }
	    final Goal other = (Goal) obj;
	      
	    if (this.node.equals(other.node)){
	    	
	    	return true;
	    }
	    return false;
	}
	
	public String toString(){
		return this.node.toString();
	}
	@Override
	public void readFields(DataInput in) throws IOException {
		// TODO Auto-generated method stub
		node.readFields(in);
		
	}
	@Override
	public void write(DataOutput out) throws IOException {
		// TODO Auto-generated method stub
		node.write(out);
	}
}
