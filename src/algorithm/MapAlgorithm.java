package algorithm;

import java.util.HashSet;
import java.util.List;

import org.apache.hadoop.io.ArrayWritable;

import graph.Goal;
import graph.Node;
import graph.PrimitiveNode;
import graph.DerivedNode;
import graph.Edge;
import graph.LFunction;
import graph.DerivationNode;

import objects.Conjunct;
import objects.Fact;
import objects.TraceStep;
import graph.AttackGraph;
import objects.Parser;

public class MapAlgorithm {

	
	public MapAlgorithm(){
		
	}
	
	public static AttackGraph getGraph(List<TraceStep> traceSteps, Goal g){
		AttackGraph toReturn=null;
		
		//0. Creating the Builder to be used in the algorithm
		Builder builder=new Builder();
		
		
		//1. Creating the structures that will make the graph
		HashSet<DerivationNode> Nr=new HashSet<DerivationNode>();
		HashSet<PrimitiveNode> Np=new HashSet<PrimitiveNode>();
		HashSet<DerivedNode> Nd=new HashSet<DerivedNode>();
		HashSet<Edge> E=new HashSet<Edge>();
		LFunction L=new LFunction();
		
		
		//2. For each t in T
		for (TraceStep t : traceSteps){
			
			//3. Create derivation node
			DerivationNode r=builder.getDerivationNode(t);
			Nr.add(r);
			L.addEntry(r, t.getInteractionrule());
			
			//4. Look up n in Nd such that L(n)=Fact
			Fact fact=t.getFact();
			DerivedNode n=L.getDerivedNode(fact);
			
			//5. If such n does not exist, create a new one.
			if (n==null){
				n=builder.getDerivedNode(fact);
				L.addEntry(n, fact);
			}
			
			//6. E<- E U {(n, r)}
			Edge edge=new Edge(n, r);
			E.add(edge);
			
			//7. For each fact f in Conjunct
			Conjunct conjunct=t.getConjunct();
			//List<Fact> facts=conjunct.getFacts();
			ArrayWritable facts=conjunct.getFacts();
			
			Fact[] tempFacts=(Fact[])facts.get();
			
			for (int i=0; i<tempFacts.length; i++)
			{
				Fact f=tempFacts[i];
				Node c=L.getNode(f);
				if (c==null){
					
					if (builder.isPrimitive(f)){
						c=builder.getPrimitiveNode(f);
						Np.add((PrimitiveNode)c);
					}
					else{
						c=builder.getDerivedNode(f);
						Nd.add((DerivedNode)c);
					}
					
				}
				Edge e=new Edge(r, c);
				E.add(e);
				
			}
			
		}
		
		toReturn=new AttackGraph(Nr, Np, Nd, E, L, g);
		return toReturn;
	}

}