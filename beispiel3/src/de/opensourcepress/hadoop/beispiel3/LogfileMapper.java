package de.opensourcepress.hadoop.beispiel3;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

/**
 * 
 * Mapper Klasse zur Extraktion von URLs aus einer Apache Log-Datei
 * 
 * @author rwartala
 * 
 */
public class LogfileMapper extends Mapper<Object, Text, Text, IntWritable> {

	private final static IntWritable one = new IntWritable(1);
	private Text url = new Text();

	// Erzeuge regul<8a>ren Ausdruck um eine URL aus der Eingabezeile zu
	// extrahieren
	private Pattern p = Pattern.compile("(?:GET|POST)\\s([^\\s]+)");

	public void map(Object key, Text value, Context context)
			throws IOException, InterruptedException {
		String[] logfileEntries = value.toString().split("\r?\n");
		for (int i = 0, len = logfileEntries.length; i < len; i += 1) {
			Matcher matcher = p.matcher(logfileEntries[i]);
			if (matcher.find()) {
				url.set(matcher.group(1));
				context.write(url, one);
			}
		}
	}
}