Here comes some map reduce examples from my book [Hadoop: Zuverlässige, verteilte und skalierbare Big-Data-Anwendungen](http://www.amazon.de/Hadoop-Zuverl%C3%A4ssige-verteilte-skalierbare-Big-Data-Anwendungen/dp/3941841610/)

beispiel1
=========

Simple class like the common 'WordCount' example produce a random list of 100.000 ship names and count the names with map reduce.

<code>de.opensourcepress.hadoop.beispiel1.ShipDataGenerator.java</code>  contains the generator who greates a list of random ship names
<code>de.opensourcepress.hadoop.beispiel1.ShipCounter</code>             contains the map and reducer classes to count the ship names

beispiel3
=========

This simple map reduce example will get an apache logfile as input and produce a counted list of recieved URLs.

<code>de.opensourcepress.hadoop.beispiel3.LogfileAnalyser.java</code>     contains the main class
<code>de.opensourcepress.hadoop.beispiel3.LogfileMapper.java</code>       contains the mapper class
<code>de.opensourcepress.hadoop.beispiel3.LogfileEntryReducer.java</code> contains the reducer class  
