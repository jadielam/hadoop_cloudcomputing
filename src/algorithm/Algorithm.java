package algorithm;

import java.util.HashSet;

import graph.PrimitiveNode;
import graph.DerivedNode;
import graph.Edge;
import graph.LFunction;
import graph.DerivationNode;

import objects.TraceStep;
import graph.AttackGraph;

public class Algorithm {

	
	public Algorithm(){
		
	}
	
	public static AttackGraph getGraph(HashSet<TraceStep> traceSteps){
		AttackGraph toReturn=null;
		
		//1. Creating the structures that will make the graph
		HashSet<DerivationNode> Nr=new HashSet<DerivationNode>();
		HashSet<PrimitiveNode> Np=new HashSet<PrimitiveNode>();
		HashSet<DerivedNode> Nd=new HashSet<DerivedNode>();
		HashSet<Edge> E=new HashSet<Edge>();
		LFunction L=new LFunction();
		
		for (TraceStep t : traceSteps){
			
		}
		
		return toReturn;
	}

}
