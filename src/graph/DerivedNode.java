/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

import objects.FunctionElement;

/**
 *
 * @author Gautham
 */
public class DerivedNode extends Node implements Serializable {
    
	private static final long serialVersionUID= 7526472295622776142L;	
  public DerivedNode(FunctionElement element){
	  super(element);
  }
}
