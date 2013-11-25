package mapreduce;

import graph.AttackGraph;

import java.io.IOException;
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

public class MapClass extends MapReduceBase implements Mapper<LongWritable, Text, Text, AttackGraph>{

	private Text word=new Text("Stub");
	
	@Override
	public void map(LongWritable key, Text value,
			OutputCollector<Text, AttackGraph> output, Reporter arg3)
			throws IOException {
		
		String lineTemp=value.toString();
		List<String> linesList=new LinkedList<String>();
		linesList.add(lineTemp);
		
		//1. Parse lines
		List<TraceStep> traceSteps=Parser.inputparser(linesList);
		
		//2. Create AttackGraph from the parsed elements
		AttackGraph graph=MapAlgorithm.getGraph(traceSteps, null);
		
				
		//3. Collect the attack graph
		output.collect(word, graph);
		
	}
	
}
