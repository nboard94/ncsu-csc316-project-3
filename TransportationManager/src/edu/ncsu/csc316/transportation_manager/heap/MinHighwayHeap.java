package edu.ncsu.csc316.transportation_manager.heap;

import edu.ncsu.csc316.transportation_manager.highway.Highway;

public class MinHighwayHeap {

	/**
	* Constructs a new Highway heap
	* 
	* @param type the type of weight to consider ("COST" or "ASPHALT") when
	*         operating on the heap
	*/
	public MinHighwayHeap(String type) {
	    // Your code
	}
	
	/**
	 * Inserts the given Highway into the minheap
	 * @param hwy the Highway to insert into the minheap
	 */
	public void insert(Highway hwy) {
	    // Your code
	}
	
	/**
	 * Returns the Highway with minimum weight in the minheap
	 * @return the Highway with minimum weight in the minheap
	 */
	public Highway deleteMin() {
		return null;
	    // Your code
	}
	
	/**
	 * Returns a string representation of the level-order traversal 
	 * of the heap in the following format:
	 * 
	 * Heap[
	 *    Highway[city1=X, city2=X, cost=X.X, asphalt=X.X],
	 *    Highway[city1=X, city2=X, cost=X.X, asphalt=X.X],
	 *    Highway[city1=X, city2=X, cost=X.X, asphalt=X.X]
	 * ]
	 *
	 * @return the string representation of the minheap
	 */
	@Override
	public String toString()
	{
		return null;
	    // Your code
	}   
}
