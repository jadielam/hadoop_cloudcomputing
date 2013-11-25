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

public class ReduceClass extends MapReduceBase implements Reducer<LongWritable, AttackGraph, LongWritable, AttackGraph>{

	@Override
	public void reduce(LongWritable key, Iterator<AttackGraph> values,
			OutputCollector<LongWritable, AttackGraph> output, Reporter reporter)
			throws IOException {
		
		List<AttackGraph> graphs=new LinkedList<AttackGraph>();
		while (values.hasNext()){
			graphs.add(values.next());
		}
		
		System.out.println("REDUCER::::::::  Got here0");
		ReduceAlgorithm reducer=new ReduceAlgorithm(graphs);
		AttackGraph reducedGraph=reducer.reduce();
		System.out.println("REDUCER::::::::  Got here1");
		AttackGraphConverter converter=new AttackGraphConverter();
		converter.ConvertToGraph(reducedGraph);
		System.out.println("REDUCER::::::::  Got here2");
		output.collect(key,  reducedGraph);
		
	}

}