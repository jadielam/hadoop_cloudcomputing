package algorithm;

import java.util.HashSet;
import java.util.List;

import graph.AttackGraph;
import graph.DerivationNode;
import graph.DerivedNode;
import graph.Edge;
import graph.Goal;
import graph.LFunction;
import graph.Node;
import graph.PrimitiveNode;

public class ReduceAlgorithm {

	List<AttackGraph> graphsToReduce;
	
	public ReduceAlgorithm(List<AttackGraph> graphs){
		this.graphsToReduce=graphs;
		
	}
	
	public AttackGraph reduce(){
		
		HashSet<DerivationNode> NrFinal=new HashSet<DerivationNode>();
		HashSet<PrimitiveNode> NpFinal=new HashSet<PrimitiveNode>();
		HashSet<DerivedNode> NdFinal=new HashSet<DerivedNode>();
		HashSet<Edge> EFinal=new HashSet<Edge>();
		LFunction LFinal=new LFunction();
		Goal goalFinal=null;
		
		//Do the reduction here.
		for (AttackGraph graph : graphsToReduce){
			
			NrFinal.addAll(graph.getNr());
			NpFinal.addAll(graph.getNp());
			NdFinal.addAll(graph.getNd());
			EFinal.addAll(graph.getE());
			LFinal.addAll(graph.getLf());
			reduceGoal(goalFinal, graph.getG());
		}
		
		return new AttackGraph(NrFinal, NpFinal, NdFinal, EFinal, LFinal, goalFinal);
	}
	
	private void reduceGoal(Goal g1, Goal g2){
		
	}
	
}

