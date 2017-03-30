package edu.ncsu.csc316.transportation_manager.ui;

import java.io.File;
import java.util.Scanner;

import edu.ncsu.csc316.transportation_manager.manager.TransportationManager;

/**
 * Handles interaction with the user.
 * 
 * @author Nicholas Board (ndboard)
 */
public class TransportationManagerUI {

	/**
	 * The beginning of execution.  Prompts the user
	 * for an input filepath and then for the feature they
	 * want to minimize.
	 * @param args Potential command-line arguments.
	 */
	public static void main(String[] args){
		
		/** The path of the input file. */
		String filepath;
		/** The feature to minimize. */
		String minType;
		/** The validity of the given filepath. */
		boolean invalidFile = true;
		/** The manager. */
		TransportationManager manager = null;
		/** The input filestream scanner. */
		Scanner inScan = new Scanner(System.in);
		
		while(invalidFile) {
			
			System.out.println("Please specify an input file, or enter \"quit\" to exit the program. ");
			filepath = inScan.nextLine();
			
			if(filepath.toUpperCase().equals("QUIT") ) {
				
				System.exit(0);
				inScan.close();
			}
			else {
				
				File inputfile = new File(filepath);
				
				if( inputfile.isFile() && inputfile.canRead() ) {
					
					invalidFile = false;
					manager = new TransportationManager(filepath);
				}
			}
		}
		
		while(true) {
			
			System.out.println("\nPlease enter \"cost\" to build a list of highways with minimal cost.");
			System.out.println("Please enter \"ashpalt\" to build a list of highways with minimal asphalt.");
			System.out.println("If you would like to exit the program, enter \"quit\".");
			minType = inScan.nextLine();
			
			if(minType.toUpperCase().equals("QUIT")) {
				
				System.exit(0);
				inScan.close();
			}
			else if(minType.toUpperCase().equals("COST")) {
				
				manager.getMinimumHighways("COST");
			}
			else if(minType.toUpperCase().equals("ASPHALT")) {
				
				manager.getMinimumHighways("ASPHALT");
			}
			else {
				
				System.out.println("\nYour command was invalid.");
			}
		}
	}
}
