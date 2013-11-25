package union;

import graph.AttackGraph;



import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.FileInputFormat;
import org.apache.hadoop.mapred.JobClient;
import org.apache.hadoop.mapred.JobConf;

import org.apache.hadoop.mapred.FileOutputFormat;
import org.apache.hadoop.util.Tool;

public class AggregateJob2 extends Configured implements Tool{

	
	public static void main(String[] argvs){
		
		AggregateJob2 job=new AggregateJob2();
		try {
			job.run(argvs);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int run(String[] argvs) throws Exception {
		
		JobConf conf=new JobConf(AggregateJob.class);
		conf.setJobName("union");
		
		conf.setOutputKeyClass(Text.class);
		conf.setOutputValueClass(AttackGraph.class);
		
		conf.setMapperClass(MapClass2.class);
		conf.setReducerClass(ReduceClass2.class);
		
		FileInputFormat.addInputPath(conf, new Path(argvs[0]));
		FileOutputFormat.setOutputPath(conf, new Path(argvs[1]));
		
		JobClient.runJob(conf);
		return 0;
	}

	

	

}
