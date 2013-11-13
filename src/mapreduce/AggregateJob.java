package mapreduce;

import graph.AttackGraph;

import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.FileInputFormat;
import org.apache.hadoop.mapred.JobClient;
import org.apache.hadoop.mapred.JobConf;

import org.apache.hadoop.mapred.FileOutputFormat;
import org.apache.hadoop.util.Tool;

public class AggregateJob extends Configured implements Tool{

	@Override
	public int run(String[] argvs) throws Exception {
		
		JobConf conf=new JobConf(AggregateJob.class);
		conf.setJobName("attackgraph");
		
		conf.setOutputKeyClass(Text.class);
		conf.setOutputValueClass(AttackGraph.class);
		
		conf.setMapperClass(MapClass.class);
		conf.setReducerClass(ReduceClass.class);
		
		FileInputFormat.addInputPath(conf, new Path(argvs[0]));
		FileOutputFormat.setOutputPath(conf, new Path(argvs[1]));
		
		JobClient.runJob(conf);
		return 0;
	}

	

	

}
