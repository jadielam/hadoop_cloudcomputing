/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

import java.util.Objects;

import objects.FunctionElement;

/**
 *
 * @author Gautham
 */
public abstract class Node {
	
	private FunctionElement element;
	
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
        
    
}

