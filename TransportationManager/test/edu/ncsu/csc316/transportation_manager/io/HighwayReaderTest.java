package edu.ncsu.csc316.transportation_manager.io;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Test;

import edu.ncsu.csc316.transportation_manager.highway.Highway;
import edu.ncsu.csc316.transportation_manager.list.ArrayBasedList;

/**
 * Tests the HighwayReader class.
 * 
 * @author Nicholas Board (ndboard)
 */
public class HighwayReaderTest {

	/** HighwayReader object used for testing. */
	HighwayReader hr;
	/** The filepath to use for testing. */
	String inputFile = "input/input.txt";
	
	/**
	 * Tests the methods and construction of
	 * the HighwayReader.
	 * 
	 * @throws FileNotFoundException If the given file does not exist.
	 */
	@Test
	public void highwayReaderTest() throws FileNotFoundException {
		
		//Test opening non-existent file.
		try {
			
			hr = new HighwayReader("bananarama");
			fail();
		} catch (FileNotFoundException e) {
			
			assertNull(hr);
		}
		
		//Test construction of highway reader and the list.
		hr = new HighwayReader(inputFile);
		ArrayBasedList<Highway> list = hr.getHighways();
		assertEquals(6, list.size());
		
		//Test contents of the first highway.
		assertEquals(2, list.lookUp(0).getCity1());
		assertEquals(0, list.lookUp(0).getCity2());
		assertEquals(7.0, list.lookUp(0).getCost(), 0);
		assertEquals(77.0, list.lookUp(0).getAsphalt(), 0);
		
		//Test contents of the last highway.
		assertEquals(1, list.lookUp(5).getCity1());
		assertEquals(2, list.lookUp(5).getCity2());
		assertEquals(6.0, list.lookUp(5).getCost(), 0);
		assertEquals(55.0, list.lookUp(5).getAsphalt(), 0);
	}
}
