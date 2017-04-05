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

		UpTree ut = new UpTree(3);
		assertEquals(-1, ut.disjointSet.lookUp(0).intValue());
		assertEquals(-1, ut.disjointSet.lookUp(1).intValue());
		assertEquals(-1, ut.disjointSet.lookUp(2).intValue());
		assertNull(ut.disjointSet.lookUp(3));

		ut.union(1, 0);
		assertEquals(1, ut.disjointSet.lookUp(0).intValue());
		assertEquals(-2, ut.disjointSet.lookUp(1).intValue());
		assertEquals(-1, ut.disjointSet.lookUp(2).intValue());

		ut.union(1, 2);
		assertEquals(1, ut.disjointSet.lookUp(0).intValue());
		assertEquals(2, ut.disjointSet.lookUp(1).intValue());
		assertEquals(-3, ut.disjointSet.lookUp(2).intValue());

		assertEquals(2, ut.find(0));
	}
}
