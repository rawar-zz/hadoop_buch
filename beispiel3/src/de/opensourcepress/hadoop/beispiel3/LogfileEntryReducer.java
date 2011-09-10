package de.opensourcepress.hadoop.beispiel3;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

/**
 * Einfacher Reducer welcher die Eingabewerte z<8a>hlt und
 * 
 * @author rwartala
 * 
 */
public class LogfileEntryReducer extends
		Reducer<Text, IntWritable, Text, IntWritable> {

	private IntWritable total = new IntWritable();

	public void reduce(Text key, Iterable<IntWritable> values, Context context)
			throws IOException, InterruptedException {
		int sum = 0;
		for (IntWritable value : values) {
			sum += value.get();
		}
		total.set(sum);
		context.write(key, total);
	}
}