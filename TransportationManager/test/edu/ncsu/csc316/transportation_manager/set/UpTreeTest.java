package edu.ncsu.csc316.transportation_manager.set;

import static org.junit.Assert.*;

import org.junit.Test;

public class UpTreeTest {

	@Test
	public void upTreeTest() {
		
		UpTree ut = new UpTree();
		assertEquals(0, ut.getRoots().size());
		
		ut.makeSet(ut.getRoots().size(), 0);
		ut.makeSet(ut.getRoots().size(), 1);
		ut.makeSet(ut.getRoots().size(), 2);
		assertEquals(3, ut.getRoots().size());
		
		ut.union(ut.getRoots().lookUp(0), ut.getRoots().lookUp(1));
		assertEquals(2, ut.getRoots().size());
		
		//ut.union(S, T)
	}
}
