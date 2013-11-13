package mapreduce;

import graph.AttackGraph;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;


public class MapClass extends MapReduceBase implements Mapper<LongWritable, Text, Text, AttackGraph>{

	private Text word=new Text("Stub");
	
	@Override
	public void map(LongWritable key, Text value,
			OutputCollector<Text, AttackGraph> output, Reporter arg3)
			throws IOException {
		
		String line=value.toString();
		
		//1. Parse lines
		
		//2. Create AttackGraph from the parsed elements
		AttackGraph graph=null;
		
		//3. Collect the attack graph
		output.collect(word, graph);
		
	}
	
}
