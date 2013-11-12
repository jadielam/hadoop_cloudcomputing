package algorithm;

import objects.Fact;
import graph.DerivationNode;
import graph.DerivedNode;
import graph.PrimitiveNode;

public class Builder {

	private int counter;
	
	public Builder(){
		counter=0;
	}
	
	public DerivationNode getDerivationNode(){
		DerivationNode toReturn=new DerivationNode(counter);
		counter=counter+1;
		
		return toReturn;
	}
	
	public DerivedNode getDerivedNode(){
		DerivedNode toReturn=new DerivedNode(counter);
		counter=counter+1;
		
		return toReturn;
	}
	
	public PrimitiveNode getPrimitiveNode(){
		PrimitiveNode toReturn=new PrimitiveNode(counter);
		counter=counter+1;
		
		return toReturn;
	}
	
	//TODO: This is a stub
	public boolean isPrimitive(Fact f){
		return true;
	}
}
