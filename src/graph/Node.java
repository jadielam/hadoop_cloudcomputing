/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.Writable;

import objects.FunctionElement;
import objects.InteractionRule;

/**
 *
 * @author Gautham
 */
public class Node implements Writable {
	
	private FunctionElement element;

	public Node(){
		this.element=new InteractionRule();
	}

	public Node(FunctionElement element) {
        this.element=element;
    }
    
    
    

    @Override
    public int hashCode() {
        return element.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Node other = (Node) obj;
        
        if (this.element.equals(other.element)){
        	
        	return true;
        }
        return false;
    }
 
    public FunctionElement getElement(){
    	return element;
    }
    
    public String toString(){
    	return element.toString();
    }
    
    public void write(DataOutput out) throws IOException{
        
        element.write(out);
}

public void readFields(DataInput in) throws IOException {
       
        element.readFields(in);
}
    
}

