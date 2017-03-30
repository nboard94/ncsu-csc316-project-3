package edu.ncsu.csc316.transportation_manager.highway;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Tests the functionality of highway objects.
 * 
 * @author Nicholas Board (ndboard)
 */
public class HighwayTest {

	/**
	 * Test method that constructs a highway,
	 * and makes sure the getters and toString
	 * return the expected results.
	 */
	@Test
	public void highwayTest() {
		
		Highway testWay = new Highway(1, 2, 3.4, 5.6);
		
		assertEquals(1, testWay.getCity1());
		assertEquals(2, testWay.getCity2());
		assertEquals(3.4, testWay.getCost(), 0);
		assertEquals(5.6, testWay.getAsphalt(), 0);
		
		//Highway[city1=X, city2=X, cost=X.X, asphalt=X.X]
		String expectedString = "Highway[city1=1, city2=2, cost=3.4, asphalt=5.6]";
		assertEquals( expectedString, testWay.toString());
	}
}
