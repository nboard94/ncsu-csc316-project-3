package edu.ncsu.csc316.transportation_manager.manager;

import org.junit.Test;

/**
 * Tests the functionality of the TransportationManager.
 * @author Nick Board
 */
public class TransportationManagerTest {

	@Test
	public void transportationManagerTest() {
		
		TransportationManager tm = new TransportationManager("input/input.txt");
		
		String adjList = tm.getAdjacencyList();
		String minSpan = tm.getMinimumHighways("COST");
	}
}
