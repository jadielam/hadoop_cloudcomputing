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
import graphline.Graph;

import org.apache.hadoop.io.MapWritable;
import org.apache.hadoop.io.Text;

public class ReduceAlgorithm {

	List<Graph> graphsToReduce;
	
	public ReduceAlgorithm(List<Graph> graphs){
		this.graphsToReduce=graphs;
		
	}
	
	public Graph reduce(){
		
		MapWritable NrFinal=new MapWritable();
		MapWritable NpFinal=new MapWritable();
		MapWritable NdFinal=new MapWritable();
		MapWritable EFinal=new MapWritable();
		
		
		Text goalFinal=new Text("");
		
		//Do the reduction here.
		for (Graph graph : graphsToReduce){
			
			
			NrFinal.putAll(graph.getNr());
			NpFinal.putAll(graph.getNp());
			NdFinal.putAll(graph.getNd());
			EFinal.putAll(graph.getE());
		
			reduceGoal(goalFinal, graph.getGoal());
		}
		
		return new Graph(NrFinal, NpFinal, NdFinal, EFinal, goalFinal);
	}
	
	private void reduceGoal(Text g1, Text g2){
		g1=g2;
	}
	
}

