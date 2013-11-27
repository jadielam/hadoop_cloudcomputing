package mapreduce;

import java.io.IOException;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import graph.AttackGraph;
import graph.AttackGraphConverter;
import algorithm.ReduceAlgorithm;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;
import org.apache.hadoop.io.LongWritable;
import graphline.Graph;

public class ReduceClass extends MapReduceBase implements Reducer<LongWritable, Graph, LongWritable, Graph>{

	@Override
	public void reduce(LongWritable key, Iterator<Graph> values,
			OutputCollector<LongWritable, Graph> output, Reporter reporter)
			throws IOException {
		
		List<Graph> graphs=new LinkedList<Graph>();
		int counter=0;
		while (values.hasNext()){
			graphs.add(values.next());
			if (counter==0) break;
			counter++;
		}
		
		
		ReduceAlgorithm reducer=new ReduceAlgorithm(graphs);
		Graph reducedGraph=reducer.reduce();
				
		output.collect(key,  reducedGraph);
		
	}

}