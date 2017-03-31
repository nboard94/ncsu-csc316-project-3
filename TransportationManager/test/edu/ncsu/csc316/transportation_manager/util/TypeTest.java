package edu.ncsu.csc316.transportation_manager.util;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * This "tests" the Type enum.
 * It doesn't need testing, but I want the coverage.
 * 
 * @author Nicholas Board (ndboard)
 */
public class TypeTest {

	/**
	 * Tests the type enum.
	 */
	@Test
	public void testTypeEnum() {
		
		assertEquals(Type.valueOf("COST"), Type.COST);
		assertEquals(Type.valueOf("ASPHALT"), Type.ASPHALT);
		
	}
}
