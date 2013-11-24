/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

/**
 *
 * @author Gautham
 */
public class Goal {
    
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
