package com.wordCount;

         
import java.io.IOException;
import java.util.*;
        
import org.apache.hadoop.examples.WordCount;
import org.apache.hadoop.examples.terasort.TeraInputFormat;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.conf.*;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.*;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

public class WordCountDriver {
 
	 public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException
	 {
		 if(args.length!=2)
		 {
			 System.out.println("usage:[input][output]");
			 System.exit(-1);
		 }
		 
     Configuration conf=new Configuration();
     
     // How to run : Use the command below
     //ubuntu@ubuntu-HP-G60-Notebook-PC:/home/MyHadoop/hadoop-1.0.3$ bin/hadoop jar '/home/ubuntu/Desktop/H_H1.jar' com.wordCount.WordCountDriver /Romeo_and_Juliet.txt /out

     
     Job job=new Job(conf,"WordCount");
     job.setOutputKeyClass(Text.class);
     job.setMapOutputValueClass(IntWritable.class);
     
     job.setMapperClass(WordCountMapper.class);
     job.setReducerClass(WordCountReducer.class);
     
     job.setInputFormatClass(TextInputFormat.class);
     job.setOutputFormatClass(TextOutputFormat.class);
     
     FileInputFormat.addInputPath(job,new Path(args[0]));
     FileOutputFormat.setOutputPath(job,new Path(args[1]));
     
     job.setJarByClass(WordCountDriver.class);
     
     job.submit();
     
     job.waitForCompletion(true);
	 }

}
