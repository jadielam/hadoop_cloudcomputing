/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

import java.io.Serializable;

import org.apache.hadoop.io.Writable;

import objects.FunctionElement;

/**
 *
 * @author Gautham
 */
public class PrimitiveNode extends Node implements Writable {
  
	public PrimitiveNode(){
		super();
	}
	
  public PrimitiveNode(FunctionElement element){
	  super(element);
  }
  
}
