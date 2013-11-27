package mapreduce;

import graph.AttackGraph;
import graph.DerivationNode;
import graph.DerivedNode;
import graph.Edge;
import graph.Goal;
import graph.PrimitiveNode;
import graphline.Graph;

import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import objects.Parser;
import objects.TraceStep;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;

import algorithm.MapAlgorithm;

public class MapClass extends MapReduceBase implements Mapper<LongWritable, Text, LongWritable, Graph>{

	
	
	@Override
	public void map(LongWritable key, Text value,
			OutputCollector<LongWritable, Graph> output, Reporter arg3)
			throws IOException {
		
		String lineTemp=value.toString();
		List<String> linesList=new LinkedList<String>();
		linesList.add(lineTemp);
		
		//1. Parse lines
		List<TraceStep> traceSteps=Parser.inputparser(linesList);
		
		//2. Create AttackGraph from the parsed elements
		AttackGraph temp=MapAlgorithm.getGraph(traceSteps, null);
		Graph graph=convertGraph(temp);
		//3. Collect the attack graph
		output.collect(new LongWritable(1), graph);
		
	}
	
	private Graph convertGraph(AttackGraph temp){
		HashSet<Edge> E=temp.getE();
		HashSet<PrimitiveNode> Np=temp.getNp();
		HashSet<DerivedNode> Nd=temp.getNd();
		HashSet<DerivationNode> Nr=temp.getNr();
		Goal g=temp.getG();
		
		Graph graph=new Graph();
		
		//1. Add edges
		for (Edge e : E){
			graph.addEdge(new Text(e.toString()));
		}
		
		//2. Add primitive nodes
		for (PrimitiveNode n : Np ){
			graph.addPrimitiveNode(new Text(n.toString()));
		}
		
		//3. Add derived nodes
		for (DerivedNode n : Nd){
			graph.addDerivedNode(new Text(n.toString()));
		}
			
		//4. Add derivation nodes
		for (DerivationNode n : Nr){
			graph.addDerivationNode(new Text(n.toString()));
		}
			
		//5. Set goal
		graph.setGoal(new Text(g.toString()));
		
		return graph;
	}
}