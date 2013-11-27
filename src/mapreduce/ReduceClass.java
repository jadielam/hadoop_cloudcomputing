package mapreduce;

import java.io.IOException;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Map.Entry;

import graph.AttackGraph;
import graph.AttackGraphConverter;
import algorithm.ReduceAlgorithm;

import org.apache.hadoop.io.MapWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;
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
		
		
				
		MapWritable NrFinal=new MapWritable();
		MapWritable NpFinal=new MapWritable();
		MapWritable NdFinal=new MapWritable();
		MapWritable EFinal=new MapWritable();
		Text goalFinal=new Text("");

		while (values.hasNext()){
			Graph a=values.next();
			reduceMap(NrFinal, a.getNr());
			reduceMap(NpFinal, a.getNp());
			reduceMap(NdFinal, a.getNd());
			reduceMap(EFinal, a.getE());
			
			
		}
		
		
		Graph reducedGraph=new Graph(NrFinal, NpFinal, NdFinal, EFinal, goalFinal);
				
		output.collect(key,  reducedGraph);
		
	}
	
	private void reduceMap(MapWritable m1, MapWritable m2){
		
		Set<Entry<Writable, Writable>> entrySet=m2.entrySet();
		for (Entry<Writable, Writable> e : entrySet){
			m1.put((Text)e.getKey(), (LongWritable)e.getValue());
		}
		
	}

}