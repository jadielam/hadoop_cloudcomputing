package algorithm;

import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

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
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Writable;

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
			
			reduceMap(NrFinal, graph.getNr());
			reduceMap(NpFinal, graph.getNp());
			reduceMap(NdFinal, graph.getNd());
			reduceMap(EFinal, graph.getE());
			
			reduceGoal(goalFinal, graph.getGoal());
		}
		
		return new Graph(NrFinal, NpFinal, NdFinal, EFinal, goalFinal);
	}
	
	private void reduceGoal(Text g1, Text g2){
		g1=g2;
	}
	
	private void reduceMap(MapWritable m1, MapWritable m2){
		
		Set<Entry<Writable, Writable>> entrySet=m2.entrySet();
		for (Entry<Writable, Writable> e : entrySet){
			m1.put((Text)e.getKey(), (LongWritable)e.getValue());
		}
		
	}
	
}

