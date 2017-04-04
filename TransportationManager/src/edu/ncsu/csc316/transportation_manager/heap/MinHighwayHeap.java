package edu.ncsu.csc316.transportation_manager.heap;

import edu.ncsu.csc316.transportation_manager.highway.Highway;
import edu.ncsu.csc316.transportation_manager.list.ArrayBasedList;
import edu.ncsu.csc316.transportation_manager.util.Type;

/**
 * The minimum heap data structure for
 * handing Highways.
 * 
 * @author Nicholas Board (ndboard)
 */
public class MinHighwayHeap {
	
	private class Node {
		
		Highway highway;
		
		int position;
		
		Node() {
			
		}
	}

	ArrayBasedList<Highway> heap = new ArrayBasedList<Highway>();
	int pos;
	int size;
	Type type;
	
	/**
	* Constructs a new Highway heap
	* 
	* @param type the type of weight to consider ("COST" or "ASPHALT") when
	*         operating on the heap
	*/
	public MinHighwayHeap(String type) {
	    
		if( type.equals("COST")) {
			
			this.type = Type.COST;
		}
		else if( type.equals("ASPHALT")) {
			
			this.type = Type.ASPHALT;
		}
		
		this.size = 0;
	}
	
	/**
	 * Inserts the given Highway into the minheap
	 * @param hwy the Highway to insert into the minheap
	 */
	public void insert(Highway hwy) {
		
	}
	
	/**
	 * Returns the Highway with minimum weight in the minheap
	 * @return the Highway with minimum weight in the minheap
	 */
	public Highway deleteMin() {
	    return null;
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
	} 

}
