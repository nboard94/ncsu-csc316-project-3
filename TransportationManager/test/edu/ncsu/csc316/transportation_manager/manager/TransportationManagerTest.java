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
	
		String expectedAdjList = "AdjacencyList[\n   City 0: -> Highway[city1=0, city2=3, cost=14.0, asphalt=415.0] -> Highway[city1=1, city2=0, cost=5.0, asphalt=99.0] -> Highway[city1=2, city2=0, cost=7.0, asphalt=159.0]\n   City 1: -> Highway[city1=1, city2=0, cost=5.0, asphalt=99.0] -> Highway[city1=1, city2=2, cost=6.0, asphalt=72.0] -> Highway[city1=3, city2=1, cost=10.0, asphalt=112.0]\n   City 2: -> Highway[city1=1, city2=2, cost=6.0, asphalt=72.0] -> Highway[city1=2, city2=0, cost=7.0, asphalt=159.0] -> Highway[city1=3, city2=2, cost=12.0, asphalt=212.0]\n   City 3: -> Highway[city1=0, city2=3, cost=14.0, asphalt=415.0] -> Highway[city1=3, city2=1, cost=10.0, asphalt=112.0] -> Highway[city1=3, city2=2, cost=12.0, asphalt=212.0]\n]";
		String expectedMinHighwaysC = "List[\n   Highway[city1=1, city2=0, cost=5.0, asphalt=99.0],\n   Highway[city1=1, city2=2, cost=6.0, asphalt=72.0],\n   Highway[city1=3, city2=1, cost=10.0, asphalt=112.0]\n]";
		
		assertEquals(expectedAdjList, tm.getAdjacencyList());
		assertEquals(expectedMinHighwaysC, tm.getMinimumHighways("COST"));
	}
}
