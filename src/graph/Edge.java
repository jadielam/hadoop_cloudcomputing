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
public class Edge  {
	
	
    
   private Node source;
   private Node destination;
   
   @Override
   public int hashCode() {
        int hash = 3;
        hash = 27 * hash + this.source.hashCode();
        hash = 43 * hash + this.destination.hashCode();
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this==obj){
        	return true;
        }
    	if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Edge other = (Edge) obj;
        if (this.source.equals(other.source) && this.destination.equals(other.destination)){
        	return true;
        }
        return false;
        
    }

    public Node getSource() {
        return source;
    }

 
    public Node getDestination() {
        return destination;
    }

    
    public Edge(){
    	source=new DerivationNode();
    	destination=new DerivationNode();
    }
    public Edge(Node src, Node dest){
    
    	source=src;
    	destination=dest;
    
    }

    public String toString(){
    	return source+" -> "+destination;
    }
    
}