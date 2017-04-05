package edu.ncsu.csc316.transportation_manager.manager;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests the construction and functionality of the TransportationManager.
 * @author Nicholas Board (ndboard)
 */
public class TransportationManagerTest {

	
	/**
	 * Tests the construction and functionality of the TransportationManager.
	 */
	@Test
	public void transportationManagerTest() {
		
		TransportationManager tm = new TransportationManager("input/input2.txt");
	
		String expectedAdjList = tm.getAdjacencyList();
		String expectedMinHighwaysC = tm.getMinimumHighways("COST");
		String expectedMinHighwaysA = tm.getMinimumHighways("ASPHALT");
		
		assertEquals(expectedAdjList, tm.getAdjacencyList());
		assertEquals(expectedMinHighwaysC, tm.getMinimumHighways("COST"));
		assertEquals(expectedMinHighwaysA, tm.getMinimumHighways("ASPHALT"));
	}
}
