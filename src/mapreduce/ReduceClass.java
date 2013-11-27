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
		while (values.hasNext()){
			graphs.add(values.next());
		}
		
		
		ReduceAlgorithm reducer=new ReduceAlgorithm(graphs);
		Graph reducedGraph=reducer.reduce();
		reducedGraph.setNoGraphs(graphs.size());
		
		output.collect(key,  reducedGraph);
		
	}

}