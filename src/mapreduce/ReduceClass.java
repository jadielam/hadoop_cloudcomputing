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

public class ReduceClass extends MapReduceBase implements Reducer<Text, AttackGraph, Text, AttackGraph>{

	@Override
	public void reduce(Text key, Iterator<AttackGraph> values,
			OutputCollector<Text, AttackGraph> output, Reporter reporter)
			throws IOException {
		
		List<AttackGraph> graphs=new LinkedList<AttackGraph>();
		while (values.hasNext()){
			graphs.add(values.next());
		}
		
		ReduceAlgorithm reducer=new ReduceAlgorithm(graphs);
		AttackGraph reducedGraph=reducer.reduce();
		AttackGraphConverter converter=new AttackGraphConverter();
		converter.ConvertToGraph(reducedGraph);
		output.collect(key,  reducedGraph);
		
	}

}

