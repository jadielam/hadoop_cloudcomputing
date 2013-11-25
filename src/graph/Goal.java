/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

import java.io.Serializable;

/**
 *
 * @author Gautham
 */
public class Goal implements Serializable {
    
	private static final long serialVersionUID= 7526472295622776144L;
	Node node;
	
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
}
