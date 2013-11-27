package objects;

import graph.AttackGraph;
import graph.DerivationNode;
import graph.DerivedNode;
import graph.Edge;
import graph.Goal;
import graph.PrimitiveNode;
import graphline.Graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.apache.hadoop.io.Text;

import algorithm.MapAlgorithm;

public class ParserTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Parser parser=new Parser();
		List<String> inputs=new ArrayList<String>();
		inputs.add("because(rule_desc('direct network access', 1.0), hacl(internet,'172.19.8.7',tcp ,'3389'), [attackerLocated(internet)])");
		
		List<TraceStep> ts=parser.inputparser(inputs);
		for (TraceStep t : ts){
			//System.out.println(t.toString());
		}
		
		MapAlgorithm alg=new MapAlgorithm();
		Goal g=new Goal();
		AttackGraph graph=alg.getGraph(ts, g);
		System.out.println("Printing AttackGraph\n");
		System.out.println(graph.toString());
		
		Graph graph1=convertGraph(graph);
		System.out.println("Printing Graph\n");
		System.out.println(graph1.toString());
		
		System.out.println("Printing Graph\n");
		System.out.println(graph1.toString1());
		

	}
	
	private static Graph convertGraph(AttackGraph temp){
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
