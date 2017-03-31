package edu.ncsu.csc316.transportation_manager.io;

import java.util.Scanner;

import edu.ncsu.csc316.transportation_manager.highway.Highway;
import edu.ncsu.csc316.transportation_manager.list.ArrayBasedList;

/**
 * Handles the input and interpretation
 * of a formated highway file.
 * 
 * @author Nicholas Board (ndboard)
 */
public class HighwayReader {

	/** The list of highways read in from the input file. */
	private ArrayBasedList<Highway> highways = new ArrayBasedList<Highway>();
	/** The scanner user to read the input file. */
	private Scanner scan;
	/** Contains the current highway being read. */
	private Highway highway;
	/** Contains the current first city being read. */
	private int city1;
	/** Contains the current second city being read. */
	private int city2;
	/** Contains the current cost being read. */
	private double cost;
	/** Contains the current asphalt being read. */
	private double asphalt;
	
	/**
	 * Constructs a highway reader, and reads from the
	 * input file, filling in the list of highways.
	 * @param The filepath to read from.
	 */
	public HighwayReader(String filepath) {
		
		scan = new Scanner(filepath);
		city1 = scan.nextInt();
		city2 = scan.nextInt();
		cost = scan.nextDouble();
		asphalt = scan.nextDouble();
		
		highway = new Highway(city1, city2, cost, asphalt);
		highways.insert(highway);
		
		scan.close();
	}
	
	/**
	 * Gets the list of highways.
	 * @return The list of highways.
	 */
	public ArrayBasedList<Highway> getHighways() {
		
		return highways;
	}
}
