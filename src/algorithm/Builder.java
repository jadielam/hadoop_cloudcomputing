package algorithm;

import objects.Fact;
import objects.FunctionElement;
import graph.DerivationNode;
import graph.DerivedNode;
import graph.PrimitiveNode;

public class Builder {

	
	
	public Builder(){
		
	}
	
	public DerivationNode getDerivationNode(FunctionElement element){
		DerivationNode toReturn=new DerivationNode(element);
		return toReturn;
	}
	
	public DerivedNode getDerivedNode(FunctionElement element){
		DerivedNode toReturn=new DerivedNode(element);
		return toReturn;
	}
	
	public PrimitiveNode getPrimitiveNode(FunctionElement element){
		PrimitiveNode toReturn=new PrimitiveNode(element);
			
		return toReturn;
	}
	
	//TODO: This is a stub
	public boolean isPrimitive(Fact f){
		return true;
	}
}