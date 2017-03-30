package edu.ncsu.csc316.transportation_manager.list;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests the ArrayBasedList data structure.
 * @author Nicholas Board (ndboard)
 */
public class ArrayBasedListTest {

	@Test
	public void arrayBasedListTest() {
		
		//Create the list and ensure that it is empty.
		ArrayBasedList<Object> testList = new ArrayBasedList<Object>();
		assertTrue(testList.isEmpty());
		assertEquals(0, testList.size());
		
		//Create objects to insert into the list.
		Object o1 = new Object();
		Object o2 = new Object();
		Object o3 = new Object();
		Object o4 = new Object();
		
		//Get the object's hashCodes for identification.
		int o1Hash = o1.hashCode();
		int o2Hash = o2.hashCode();
		int o3Hash = o3.hashCode();
		int o4Hash = o4.hashCode();
		
		//Test insertion in an empty list.
		testList.insert(o1);
		assertEquals(o1Hash, testList.lookUp(0).hashCode());
		assertEquals(1, testList.size());
		assertFalse(testList.isEmpty());
		
		//Test insertion in a nonempty list.
		testList.insert(o2);
		assertEquals(o2Hash, testList.lookUp(1).hashCode());
		assertEquals(2, testList.size());
		
		//Test insertion in the middle of the list.
		testList.insertAt(o3, 1);
		assertEquals(o1Hash, testList.lookUp(0).hashCode());
		assertEquals(o3Hash, testList.lookUp(1).hashCode());
		assertEquals(o2Hash, testList.lookUp(2).hashCode());
		assertEquals(3, testList.size());
		
		//Test inserting at the end of the list.
		testList.insertAt(o4, 3);
		assertEquals(o1Hash, testList.lookUp(0).hashCode());
		assertEquals(o3Hash, testList.lookUp(1).hashCode());
		assertEquals(o2Hash, testList.lookUp(2).hashCode());
		assertEquals(o4Hash, testList.lookUp(3).hashCode());
		assertEquals(4, testList.size());
		
		//Test the swap operation.
		testList.swap(1, 2);
		assertEquals(o2Hash, testList.lookUp(1).hashCode());
		assertEquals(o3Hash, testList.lookUp(2).hashCode());
		
		//Test removing at the beginning of the list.
		testList.remove(0);
		assertEquals(o2Hash, testList.lookUp(0).hashCode());
		assertEquals(o3Hash, testList.lookUp(1).hashCode());
		assertEquals(o4Hash, testList.lookUp(2).hashCode());
		assertEquals(3, testList.size());
		
		//Test removing in the middle of the list.
		testList.remove(1);
		assertEquals(o2Hash, testList.lookUp(0).hashCode());
		assertEquals(o4Hash, testList.lookUp(1).hashCode());
		assertEquals(2, testList.size());
		
		//Test removing at the end of the list.
		testList.remove(2);
		assertEquals( o2Hash, testList.lookUp(0).hashCode());
		assertEquals(1, testList.size());
	}
}
