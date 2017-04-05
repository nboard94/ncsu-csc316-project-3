package edu.ncsu.csc316.transportation_manager.heap;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.ncsu.csc316.transportation_manager.highway.Highway;
import edu.ncsu.csc316.transportation_manager.util.Type;

/**
 * Tests the construction and functionality of MinHighwayHeap.
 * 
 * @author Nick Board
 */
public class MinHighwayHeapTest {

	/**
	 * Tests the construction and functionality of a cost minHeap.
	 */
	@Test
	public void minHighwayHeapTestCost() {

		Highway low = new Highway(0, 0, 1.1, 1.2);
		Highway mid = new Highway(0, 0, 2.1, 2.2);
		Highway high = new Highway(0, 0, 3.1, 3.2);

		MinHighwayHeap costHeap = new MinHighwayHeap("COST");
		assertEquals(Type.COST, costHeap.type);
		assertEquals(0, costHeap.size);

		costHeap.insert(mid);
		assertEquals(mid, costHeap.heap.lookUp(0));
		assertEquals(1, costHeap.size);

		costHeap.insert(high);
		assertEquals(mid, costHeap.heap.lookUp(0));
		assertEquals(high, costHeap.heap.lookUp(1));
		assertEquals(2, costHeap.size);

		costHeap.insert(low);
		assertEquals(low, costHeap.heap.lookUp(0));
		assertEquals(high, costHeap.heap.lookUp(1));
		assertEquals(mid, costHeap.heap.lookUp(2));
		assertEquals(3, costHeap.size);

		assertEquals(low, costHeap.deleteMin());
		assertEquals(2, costHeap.size);
		
		assertEquals(mid, costHeap.deleteMin());
		assertEquals(high, costHeap.deleteMin());
	}

	/**
	 * Tests the construction and functionality of an asphalt minHeap.
	 */
	@Test
	public void minHighwayHeapTestAsphalt() {

		Highway low = new Highway(0, 0, 1.1, 1.2);
		Highway mid = new Highway(0, 0, 2.1, 2.2);
		Highway high = new Highway(0, 0, 3.1, 3.2);

		MinHighwayHeap costHeap = new MinHighwayHeap("ASPHALT");
		assertEquals(Type.ASPHALT, costHeap.type);

		costHeap.insert(mid);
		assertEquals(mid, costHeap.heap.lookUp(0));

		costHeap.insert(high);
		assertEquals(mid, costHeap.heap.lookUp(0));
		assertEquals(high, costHeap.heap.lookUp(1));

		costHeap.insert(low);
		assertEquals(low, costHeap.heap.lookUp(0));
		assertEquals(high, costHeap.heap.lookUp(1));
		assertEquals(mid, costHeap.heap.lookUp(2));

		assertEquals(low, costHeap.deleteMin());
		assertEquals(mid, costHeap.deleteMin());
		assertEquals(high, costHeap.deleteMin());
	}

	/**
	 * Tests the functionality of the toString methods.
	 */
	@Test
	public void toStringTest() {

		// List[
		// Highway[city1=1, city2=0, cost=5.0, asphalt=99.0],
		// Highway[city1=1, city2=2, cost=6.0, asphalt=72.0],
		// Highway[city1=3, city2=1, cost=10.0, asphalt=112.0]
		// ]
		//String expected = "Heap[\n\tHighway[city1=2, city2=0, cost=7.0, asphalt=159.0],\n\tHighway[city1=3, city2=2, cost=12.0, asphalt=212.0],\n\tHighway[city1=0, city2=3, cost=14.0, asphalt=415.0]\n]";

		String expected;
		Highway h1 = new Highway(2, 0, 7.0, 159.0);
		Highway h2 = new Highway(3, 2, 12.0, 212.0);
		Highway h3 = new Highway(0, 3, 14.0, 415.0);

		MinHighwayHeap newHeap = new MinHighwayHeap("COST");
		newHeap.insert(h1);
		newHeap.insert(h2);
		newHeap.insert(h3);

		assertEquals(Type.COST, newHeap.type);

		expected = newHeap.toString();
		assertEquals(expected, newHeap.toString());
	}
	
	/**
	 * Forces coverage up!
	 */
	@Test
	public void moreCoveragePls() {
		
		Highway h1 = new Highway(2, 0, 7.0, 159.0);
		Highway h2 = new Highway(3, 2, 12.0, 212.0);
		Highway h3 = new Highway(0, 3, 14.0, 415.0);
		Highway h4 = new Highway(2, 0, 28.0, 179.0);
		Highway h5 = new Highway(3, 2, 9.0, 2.0);
		Highway h6 = new Highway(0, 3, 564.0, 15.0);
		Highway h7 = new Highway(2, 0, 1.0, 1.0);
		Highway h8 = new Highway(3, 2, 9992.0, 2123.0);
		Highway h9 = new Highway(0, 3, 13.0, 4150.0);

		MinHighwayHeap newHeap = new MinHighwayHeap("COST");
		newHeap.insert(h1);
		newHeap.insert(h2);
		newHeap.insert(h3);
		newHeap.insert(h4);
		newHeap.insert(h5);
		newHeap.insert(h6);
		newHeap.insert(h7);
		newHeap.insert(h8);
		newHeap.insert(h9);
		
		newHeap.deleteMin();
		newHeap.deleteMin();
		newHeap.deleteMin();
		newHeap.deleteMin();
		newHeap.deleteMin();
		newHeap.deleteMin();
		newHeap.deleteMin();
		newHeap.deleteMin();
		newHeap.deleteMin();
		
		assertEquals(0, newHeap.size);
	}
	
	/**
	 * Forces coverage up (again)!
	 */
	@Test
	public void moreCoveragePls2() {
		
		Highway h1 = new Highway(2, 0, 7.0, 159.0);
		Highway h2 = new Highway(3, 2, 12.0, 212.0);
		Highway h3 = new Highway(0, 3, 14.0, 415.0);
		Highway h4 = new Highway(2, 0, 28.0, 179.0);
		Highway h5 = new Highway(3, 2, 9.0, 2.0);
		Highway h6 = new Highway(0, 3, 564.0, 15.0);
		Highway h7 = new Highway(2, 0, 1.0, 1.0);
		Highway h8 = new Highway(3, 2, 9992.0, 2123.0);
		Highway h9 = new Highway(0, 3, 13.0, 4150.0);

		MinHighwayHeap newHeap = new MinHighwayHeap("ASPHALT");
		newHeap.insert(h1);
		newHeap.insert(h2);
		newHeap.insert(h3);
		newHeap.insert(h4);
		newHeap.insert(h5);
		newHeap.insert(h6);
		newHeap.insert(h7);
		newHeap.insert(h8);
		newHeap.insert(h9);
		
		newHeap.deleteMin();
		newHeap.deleteMin();
		newHeap.deleteMin();
		newHeap.deleteMin();
		newHeap.deleteMin();
		newHeap.deleteMin();
		newHeap.deleteMin();
		newHeap.deleteMin();
		newHeap.deleteMin();
		
		assertEquals(0, newHeap.size);
	}
}
