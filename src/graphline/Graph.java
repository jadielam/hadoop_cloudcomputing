package graphline;

import graph.AttackGraphConverter;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.MapWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;
public class Graph implements Writable{

	private MapWritable E;
	private MapWritable Nr;
	private MapWritable Np;
	private MapWritable Nd;
	private Text goal;
	private LongWritable noGraphs;
	private List<Graph> graphList=new ArrayList<Graph>();
	
	public Graph(){
		this.E=new MapWritable();
		this.Nr=new MapWritable();
		this.Np=new MapWritable();
		this.Nd=new MapWritable();
		this.goal=new Text("");
	}
	
	public Graph(MapWritable Nr, MapWritable Np, MapWritable Nd, MapWritable E, Text goal){
		this.Nr=Nr;
		this.Np=Np;
		this.Nd=Nd;
		this.E=E;
		this.goal=goal;
	}
	
	public void addEdge(Text edge){
		if (!E.containsKey(edge)){
			E.put(edge, new LongWritable(1));
		}
	}
	
	public void addGraph(Graph graph){
		this.graphList.add(graph);
	}
	public void addPrimitiveNode(Text node){
		if (!Np.containsKey(node)){
			Np.put(node, new LongWritable(1));
		}
	}
	
	public void addDerivedNode(Text node){
		if (!Nd.containsKey(node)){
			Nd.put(node, new LongWritable(1));
		}
		
	}
	
	public void addDerivationNode(Text node){
		if (!Nr.containsKey(node)){
			Nr.put(node, new LongWritable(1));
		}
	}
	
	public void setGoal(Text goal){
		this.goal=goal;
	}

	@Override
	public void readFields(DataInput in) throws IOException {
		E.readFields(in);
		Nr.readFields(in);
		Np.readFields(in);
		Nd.readFields(in);
		goal.readFields(in);
		
	}

	@Override
	public void write(DataOutput out) throws IOException {
		E.write(out);
		Nr.write(out);
		Np.write(out);
		Nd.write(out);
		goal.write(out);
		
	}

	public MapWritable getNr() {
		
		return Nr;
	}
	
	public MapWritable getNd(){
		return Nd;
	}
	
	public MapWritable getNp(){
		return Np;
	}
	
	public MapWritable getE(){
		return E;
	}
	
	public Text getGoal(){
		return goal;
	}
	
	public void setNoGraphs(int a){
		noGraphs=new LongWritable(a);
	}
	
	public String toString(){
		AttackGraphConverter converter=new AttackGraphConverter();
		String temp=converter.ConvertToGraph(this);
		temp=temp+"\n";
		temp=temp+graphList.get(0).toString();
		return temp;
		
	}
}
