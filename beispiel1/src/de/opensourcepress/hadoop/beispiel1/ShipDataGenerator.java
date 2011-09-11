package de.opensourcepress.hadoop.beispiel1;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Random;

public class ShipDataGenerator {

	static String[] shipNames = {
		"Abendstern","Blaue Weite","Casanova","Delphin","Die Fänger","Entdecker","Fegefeuer","Furchtlos",
		"Leise Jägerin","Mond","Morgenwind","Narrenwind","Navigator","Nordstern","Rote Theresa",
		"Schneller Aal","Rasender Falke","Renegat","Rochenfänger","Schatzsucher","Schwertfisch",
		"Seefalke","Seekatze","Seelöwe","Silberpfeil","Tiefsee","Unbekannte Ferne","Walfänger",
		"Windjagd","Wirbelwind","Elise","Alte Lotte","Anne-Marie","Aurora","Ausdauer","Avanturine",
		"Blauer Stern","Brise","Brummbär","Butterblume","Cochrane","Daedalus","Farragut","Goddard",
		"Gondola","Horanaski","Immerwind","Irmgard","Jonathan","Katharina","Kuriana","Lustige Lise",
		"Maxe","Mirhana","Möwe","Nautilus","Nixe","Pegasus","Psesare","Ramona","Ronja","Schmetterling",
		"Schwarze Betty","Sonnenwind","Sternenstaub","Tapfere Barke","Torjukala","Vogelschweif",
		"Weiße Julia","Weißer Schwan","Wellenjäger","Windbote"
	};
	
	public static void main(String[] args) throws Exception {
		
		FileWriter outFile = new FileWriter(args[0]);
		PrintWriter out = new PrintWriter(outFile);
		
		Random randomGenerator = new Random();
		for(int i = 0; i <= 100000; i++) {
			int randomShip = randomGenerator.nextInt(shipNames.length);
			String shipName = shipNames[randomShip];
			out.println(shipName);
		}
		out.close();
		outFile.close();
	}
}
