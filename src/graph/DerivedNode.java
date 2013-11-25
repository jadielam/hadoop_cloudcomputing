/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

import org.apache.hadoop.io.Writable;

import objects.FunctionElement;

/**
 *
 * @author Gautham
 */
public class DerivedNode extends Node implements Writable {
    
		
  public DerivedNode(FunctionElement element){
	  super(element);
  }
}