package com.wordCount;


         
         
import java.io.IOException;

import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.*;


public class WordCountMapper extends Mapper<LongWritable,Text,Text,IntWritable> {

	@Override
	public void map(LongWritable inputKey,Text inputVal,Context context) throws IOException, InterruptedException
	{
		String line=inputVal.toString();
		String[] splits=line.split("\\W+");
		for(String outputKey:splits)
		{
			context.write(new Text(outputKey),new IntWritable(1));
		}
	}
}
