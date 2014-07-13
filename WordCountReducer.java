package com.wordCount;

import java.io.IOException;




import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.*;




import org.apache.hadoop.io.IntWritable;


public class WordCountReducer extends Reducer <Text,IntWritable,Text,IntWritable> {

	public void reduce(Text key,Iterable<IntWritable>values,Context output) throws IOException,InterruptedException
	{
		int sum=0;
		for(IntWritable val:values)
		{
			sum+=val.get();
		}
		output.write(key,new IntWritable(sum));
	}
}
