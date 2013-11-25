package mapreduce;

import graph.AttackGraph;
import graphline.Graph;

import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.FileInputFormat;
import org.apache.hadoop.mapred.JobClient;
import org.apache.hadoop.mapred.JobConf;

import org.apache.hadoop.mapred.FileOutputFormat;
import org.apache.hadoop.util.Tool;

public class AggregateJob extends Configured implements Tool{

	
	public static void main(String[] argvs){
		
		AggregateJob job=new AggregateJob();
		try {
			job.run(argvs);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int run(String[] argvs) throws Exception {
		
		JobConf conf1=new JobConf(AggregateJob.class);
		conf1.setJobName("attackgraph");
		
		conf1.setOutputKeyClass(LongWritable.class);
		conf1.setOutputValueClass(Graph.class);
		
		conf1.setMapperClass(MapClass.class);
		conf1.setReducerClass(ReduceClass.class);
		
		//TODO: Stub to delete later.
		conf1.setNumMapTasks(1);
		conf1.setNumReduceTasks(1);
		
		FileInputFormat.addInputPath(conf1, new Path(argvs[0]));
		FileOutputFormat.setOutputPath(conf1, new Path(argvs[1]));
		
		JobClient.runJob(conf1);
		return 0;
	}
}
