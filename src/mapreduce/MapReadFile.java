package mapreduce;

import java.io.IOException;
import java.util.List;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;

public class MapReadFile extends MapReduceBase implements Mapper<LongWritable, Text, LongWritable, Text> {

	@Override
	public void map(LongWritable key, Text value,
			OutputCollector<LongWritable, Text> output, Reporter arg3)
			throws IOException {
		
		//TODO: Note that this is a stub.  I need to come up with a clever way of assigning keys here.
		output.collect(new LongWritable(1), value);
	}

}
