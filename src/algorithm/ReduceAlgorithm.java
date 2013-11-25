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
import org.apache.hadoop.io.MapWritable;

public class ReduceAlgorithm {

	List<AttackGraph> graphsToReduce;
	
	public ReduceAlgorithm(List<AttackGraph> graphs){
		this.graphsToReduce=graphs;
		
	}
	
	public AttackGraph reduce(){
		
		MapWritable NrFinal=new MapWritable();
		MapWritable NpFinal=new MapWritable();
		MapWritable NdFinal=new MapWritable();
		MapWritable EFinal=new MapWritable();
		
		LFunction LFinal=new LFunction();
		Goal goalFinal=null;
		
		//Do the reduction here.
		for (AttackGraph graph : graphsToReduce){
			
			
			NrFinal.putAll(graph.getNr());
			NpFinal.putAll(graph.getNp());
			NdFinal.putAll(graph.getNd());
			EFinal.putAll(graph.getE());
			LFinal.addAll(graph.getLf());
			reduceGoal(goalFinal, graph.getG());
		}
		
		return new AttackGraph(NrFinal, NpFinal, NdFinal, EFinal, LFinal, goalFinal);
	}
	
	private void reduceGoal(Goal g1, Goal g2){
		
	}
	
}

