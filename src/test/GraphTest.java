package test;

import graph.AttackGraph;
import graph.DerivationNode;
import graph.DerivedNode;
import graph.Edge;
import graph.Goal;
import graph.LFunction;
import graph.PrimitiveNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import objects.Constant;
import objects.Fact;
import objects.InteractionRule;

public class GraphTest {

	public static void main (String []argvs){
		
		Constant c1=new Constant(1, "c1");
		Constant c2=new Constant(2, "c2");
		Constant c3=new Constant(3, "c3");
		Constant c4=new Constant(4, "c4");
		Constant c5=new Constant(5, "c5");
		
		System.out.println(c5.toString());
		
		InteractionRule ir1=new InteractionRule("ir1");
		InteractionRule ir2=new InteractionRule("ir2");
		InteractionRule ir3=new InteractionRule("ir3");
		InteractionRule ir4=new InteractionRule("ir4");
		InteractionRule ir5=new InteractionRule("ir5");
		
		System.out.println(ir5.toString());
		
		List<Constant> l1=new ArrayList<Constant>();
		l1.add(c1);
		List<Constant> l2=new ArrayList<Constant>();
		l2.add(c1);
		l2.add(c2);
		List<Constant> l3=new ArrayList<Constant>();
		l3.add(c1);
		l3.add(c2);
		l3.add(c3);
		List<Constant> l4=new ArrayList<Constant>();
		l4.add(c1);
		l4.add(c2);
		l4.add(c3);
		l4.add(c4);
		List<Constant> l5=new ArrayList<Constant>();
		l5.add(c1);
		l5.add(c2);
		l5.add(c3);
		l5.add(c4);
		l5.add(c5);
		
		Fact f1=new Fact("f1", l1);
		Fact f2=new Fact("f2", l2);
		Fact f3=new Fact("f3", l3);
		Fact f4=new Fact("f4", l4);
		Fact f5=new Fact("f5", l5);
		
		System.out.println(f5.toString());
		
		DerivedNode r1=new DerivedNode(ir1);
		DerivedNode r2=new DerivedNode(ir2);
		DerivedNode r3=new DerivedNode(ir3);
		DerivedNode r4=new DerivedNode(ir4);
		DerivedNode r5=new DerivedNode(ir5);
		
		System.out.println(r5.toString());
		
		DerivationNode n1=new DerivationNode(f1);
		DerivationNode n2=new DerivationNode(f2);
		DerivationNode n3=new DerivationNode(f3);
		PrimitiveNode p1=new PrimitiveNode(f4);
		PrimitiveNode p2=new PrimitiveNode(f5);
		
		System.out.println(n1.toString());
		System.out.println(p1.toString());
		
		Edge e1=new Edge(n1, r1);
		Edge e2=new Edge(n2, r2);
		Edge e3=new Edge(p1, r3);
		Edge e4=new Edge(p2, r4);
		
		HashSet<Edge> edges=new HashSet<Edge>();
		edges.add(e1);
		edges.add(e2);
		edges.add(e3);
		edges.add(e4);
		
		HashSet<DerivationNode> Nr=new HashSet<DerivationNode>();
		Nr.add(n1);
		Nr.add(n2);
		Nr.add(n3);
		
		HashSet<PrimitiveNode> Np=new HashSet<PrimitiveNode>();
		Np.add(p1);
		Np.add(p2);
		
		HashSet<DerivedNode> Nd=new HashSet<DerivedNode>();
		Nd.add(r1);
		Nd.add(r2);
		Nd.add(r3);
		Nd.add(r4);
		Nd.add(r5);
		
		LFunction Lf=new LFunction();
		Goal goal=new Goal(p1);
		
		AttackGraph g=new AttackGraph(Nr, Np, Nd, edges, Lf, goal);
	}
}
