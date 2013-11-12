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
		Goal goalFinal=new Goal();
		
		//Do the reduction here.
		for (AttackGraph graph : graphsToReduce){
			reduceNr(NrFinal, graph.getNr(), LFinal, graph.getLf());
			reduceNp(NpFinal, graph.getNp(), LFinal, graph.getLf());
			reduceNd(NdFinal, graph.getNd(), LFinal, graph.getLf());
			reduceEdges(EFinal, graph.getE(), LFinal, graph.getLf());
			reduceLFunction(LFinal, graph.getLf());
			reduceGoal(goalFinal, graph.getG());
		}
		
		return new AttackGraph(NrFinal, NpFinal, NdFinal, EFinal, LFinal, goalFinal);
	}
	
	private void reduceNr(HashSet<DerivationNode> nodes1, HashSet<DerivationNode> nodes2, LFunction L1, LFunction L2){
		
	}
	
	private void reduceNp(HashSet<PrimitiveNode> nodes1, HashSet<PrimitiveNode> nodes2, LFunction L1, LFunction L2){
		
	}
	
	private void reduceNd(HashSet<DerivedNode> nodes1, HashSet<DerivedNode> nodes2, LFunction L1, LFunction L2){
		
	}
	
	private void reduceEdges(HashSet<Edge> edge1, HashSet<Edge> edge2, LFunction L1, LFunction L2){
		
	}
	
	private void reduceLFunction(LFunction L1, LFunction L2){
		
	}
	
	private void reduceGoal(Goal g1, Goal g2){
		
	}
	
}

