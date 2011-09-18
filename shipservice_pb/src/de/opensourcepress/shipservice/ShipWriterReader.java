package de.opensourcepress.shipservice;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

import de.opensourcepress.shipservice.Shipservice.Ship;
import de.opensourcepress.shipservice.Shipservice.ShipType;

public class ShipWriterReader {

	public static void main(String[] args) {
		if (args.length != 1) {
			System.err.println("Usage: ShipWriter SHIP_FILE");
			System.exit(-1);
		}

		BufferedReader stdin = new BufferedReader(new InputStreamReader(
				System.in));
		PrintStream stdout = System.out;

		Ship.Builder shipBuilder = Ship.newBuilder();

		try {
			stdout.print("Enter ship ID: ");
			shipBuilder.setId(Integer.valueOf(stdin.readLine()));

			stdout.print("Enter ship name: ");
			shipBuilder.setName(stdin.readLine());

			stdout.print("Enter ship type (1=KREUZFAHRTSCHIFF,2=CONTAINERSCHIFF,3=TANKSCHIFF,4=OTHER)");
			String type = stdin.readLine();
			if (type.equals("1")) {
				shipBuilder.setType(ShipType.KREUZFAHRTSCHIFF);
			} else if (type.equals("2")) {
				shipBuilder.setType(ShipType.CONTAINERSCHIFF);
			} else if (type.equals("3")) {
				shipBuilder.setType(ShipType.TANKSCHIFF);
			} else {
				shipBuilder.setType(ShipType.OTHER);
			}

			FileOutputStream output = new FileOutputStream(args[0]);
			shipBuilder.build().writeTo(output);
			
			stdout.println("The following ship has be entered:");
			Ship ship = Ship.parseFrom(new FileInputStream(args[0]));
			int shipId = ship.getId();
			stdout.println("You entered ship ID : "+shipId);
			String shipName = ship.getName();
			stdout.println("You entered ship name : "+shipName);
			ShipType shipType = ship.getType();
			stdout.print("You entered ship type : "+shipType.name());
			
		} catch (IOException e) {
			System.err.println("Can't read from STDIN or write to "+args[0]);
		}
	}
}
