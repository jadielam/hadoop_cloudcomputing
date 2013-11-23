package union;
import java.io.IOException;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;

public class MapClass2 extends MapReduceBase implements Mapper<LongWritable, String[], Text, Text>{
	private Text word=new Text("Stub");
	//Considered a Set of Strings to find the union
@Override
public void map(LongWritable key, String[] set,
		OutputCollector<Text, Text> partition, Reporter arg3)
		throws IOException {
		for(String part:set)
		{
			Text unit=new Text(part);
			partition.collect(word, unit);
		}
	}
}
