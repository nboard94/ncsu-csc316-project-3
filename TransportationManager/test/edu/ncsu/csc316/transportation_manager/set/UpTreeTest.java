package edu.ncsu.csc316.transportation_manager.set;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests the methods and construction of an UpTree.
 * 
 * @author Nick Board
 */
public class UpTreeTest {

	/**
	 * Tests the functionality of the upTree.
	 */
	@Test
	public void upTreeTest() {

		//-1, -1, -1
		UpTree ut = new UpTree(3);
		assertEquals(-1, ut.disjointSet.lookUp(0).intValue());
		assertEquals(-1, ut.disjointSet.lookUp(1).intValue());
		assertEquals(-1, ut.disjointSet.lookUp(2).intValue());
		assertNull(ut.disjointSet.lookUp(3));
		
		assertEquals(0, ut.find(0));
		assertEquals(1, ut.find(1));
		assertEquals(2, ut.find(2));

		//1, -2, -1
		ut.union(1, 0);
		assertEquals(1, ut.disjointSet.lookUp(0).intValue());
		assertEquals(-2, ut.disjointSet.lookUp(1).intValue());
		assertEquals(-1, ut.disjointSet.lookUp(2).intValue());
		
		assertEquals(1, ut.find(0));
		assertEquals(1, ut.find(1));
		assertEquals(2, ut.find(2));

		//1, 2, -3
		ut.union(1, 2);
		assertEquals(1, ut.disjointSet.lookUp(0).intValue());
		assertEquals(2, ut.disjointSet.lookUp(1).intValue());
		assertEquals(-3, ut.disjointSet.lookUp(2).intValue());
		
		assertEquals(2, ut.find(0));
		assertEquals(2, ut.find(1));
		assertEquals(2, ut.find(2));

	}
}
