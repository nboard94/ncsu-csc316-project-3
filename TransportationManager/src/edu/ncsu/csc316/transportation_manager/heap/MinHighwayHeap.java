package edu.ncsu.csc316.transportation_manager.heap;

import edu.ncsu.csc316.transportation_manager.highway.Highway;
import edu.ncsu.csc316.transportation_manager.list.ArrayBasedList;
import edu.ncsu.csc316.transportation_manager.util.Type;

/**
 * The minimum heap data structure for handing Highways.
 * 
 * @author Nicholas Board (ndboard)
 */
public class MinHighwayHeap {

	ArrayBasedList<Highway> heap = new ArrayBasedList<Highway>();
	int size;
	Type type;

	/**
	 * Constructs a new Highway heap
	 * 
	 * @param type
	 *            the type of weight to consider ("COST" or "ASPHALT") when
	 *            operating on the heap
	 */
	public MinHighwayHeap(String type) {

		if (type.equals("COST")) {

			this.type = Type.COST;
		} else if (type.equals("ASPHALT")) {

			this.type = Type.ASPHALT;
		}

		this.size = 0;
	}

	/**
	 * Inserts the given Highway into the minheap
	 * 
	 * @param hwy
	 *            the Highway to insert into the minheap
	 */
	public void insert(Highway hwy) {

		heap.insertAt(hwy, this.size);
		this.size++;
		this.upHeap(this.size - 1);

	}

	/**
	 * Heapify the up down.
	 * @param i The i to upheap on.
	 */
	public void upHeap(int i) {

		if (this.type == Type.COST) {

			if (i > 0 && this.heap.lookUp((i - 1) / 2).getCost() > this.heap.lookUp(i).getCost()) {

				this.heap.swap((i - 1) / 2, i);
				upHeap((i - 1) / 2);
			}

		} else if (this.type == Type.ASPHALT) {

			if (i > 0 && this.heap.lookUp((i - 1) / 2).getAsphalt() > this.heap.lookUp(i).getAsphalt()) {

				this.heap.swap((i - 1) / 2, i);
				upHeap((i - 1) / 2);
			}

		}
	}

	/**
	 * Returns the Highway with minimum weight in the minheap
	 * 
	 * @return the Highway with minimum weight in the minheap
	 */
	public Highway deleteMin() {

		Highway min = this.heap.lookUp(0);
		this.size--;
		this.heap.swap(0, this.size);
		downHeap(0);
		return min;
	}

	/**
	 * Heapify the heap down.
	 * @param m The m to downheap on.
	 */
	public void downHeap(int m) {

		int i = 0;

		if (this.type == Type.COST) {

			if (2 * m + 2 < this.size) {

				if (this.heap.lookUp(2 * m + 2).getCost() <= this.heap.lookUp(2 * m + 1).getCost())
					i = 2 * m + 2;
				else
					i = 2 * m + 1;
			} else if ((2 * m + 1) < this.size)
				i = 2 * m + 1;

			if (i > 0 && this.heap.lookUp(m).getCost() > this.heap.lookUp(i).getCost()) {

				this.heap.swap(m, i);
				this.downHeap(i);
			}
		} else if (this.type == Type.ASPHALT) {

			if (2 * m + 2 < this.size) {

				if (this.heap.lookUp(2 * m + 2).getAsphalt() <= this.heap.lookUp(2 * m + 1).getAsphalt())
					i = 2 * m + 2;
				else
					i = 2 * m + 1;
			} else if ((2 * m + 1) < this.size)
				i = 2 * m + 1;

			if (i > 0 && this.heap.lookUp(m).getAsphalt() > this.heap.lookUp(i).getAsphalt()) {

				this.heap.swap(m, i);
				this.downHeap(i);
			}
		}
	}

	/**
	 * Returns a string representation of the level-order traversal of the heap
	 * in the following format:
	 * 
	 * Heap[ Highway[city1=X, city2=X, cost=X.X, asphalt=X.X], Highway[city1=X,
	 * city2=X, cost=X.X, asphalt=X.X], Highway[city1=X, city2=X, cost=X.X,
	 * asphalt=X.X] ]
	 *
	 * @return the string representation of the minheap
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Heap[");
		Highway current;

		for (int i = 0; i < this.heap.size(); i++) {

			current = this.heap.lookUp(i);

			if (i == this.heap.size() - 1) {
				sb.append("\n\tHighway[city1=" + current.getCity1() + ", city2=" + current.getCity2() + ", cost="
						+ current.getCost() + ", asphalt=" + current.getAsphalt() + "]");
			} else {
				sb.append("\n\tHighway[city1=" + current.getCity1() + ", city2=" + current.getCity2() + ", cost="
						+ current.getCost() + ", asphalt=" + current.getAsphalt() + "],");
			}
		}

		sb.append("\n]");
		return sb.toString();
	}

}
