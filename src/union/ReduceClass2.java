package union;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;

public class ReduceClass2 extends MapReduceBase implements Reducer<Text, String, Text, List<String>> {
	private Text word=new Text("Stub");
	@Override
	public void reduce(Text key, Iterator<String> partitions,
			OutputCollector<Text, List<String>> union, Reporter arg3)
			throws IOException {
		List<String> union1 = new ArrayList<String>();
		while (partitions.hasNext()){
			if(!union1.contains(partitions.next()))
			union1.add(partitions.next());
		}
		union.collect(word,union1);
	}

}
