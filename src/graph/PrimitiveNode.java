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
public class PrimitiveNode extends Node implements Serializable {
  
	private static final long serialVersionUID= 7526472295622776147L;
	
  public PrimitiveNode(FunctionElement element){
	  super(element);
  }
  
  
  
}
