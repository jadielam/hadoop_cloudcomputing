/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

import java.io.Serializable;

import objects.FunctionElement;

/**
 *
 * @author Gautham
 */
public class DerivationNode extends Node implements Writable  {
 
	
	
	public DerivationNode(){
		super();
	}
	
    public DerivationNode(FunctionElement element){
    	super(element);
    }
    
}
