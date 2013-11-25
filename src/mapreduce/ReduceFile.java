package mapreduce;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;

public class ReduceFile extends MapReduceBase implements Reducer<LongWritable, Text, LongWritable, List<Text>>{

	

	@Override
	public void reduce(LongWritable key, Iterator<Text> values,
			OutputCollector<LongWritable, List<Text>> output, Reporter arg3)
			throws IOException {
		
		List<Text> lines=new ArrayList<Text>();
		
		while (values.hasNext()){
			lines.add(values.next());
		}
		
		output.collect(key, lines);
	}
}
