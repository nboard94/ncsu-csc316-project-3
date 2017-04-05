package edu.ncsu.csc316.transportation_manager.set;

import edu.ncsu.csc316.transportation_manager.list.ArrayBasedList;

/**
 * Represents an UpTree disjoint set.
 * 
 * @author Nicholas Board (ndboard)
 */
public class UpTree {

	/** Contains all the values of the uptree. */
	ArrayBasedList<Integer> disjointSet = new ArrayBasedList<Integer>();
	/** Size of the uptree. */
	public int size = 0;

	/**
	 * Constructs a new UpTree. Sets all member values to -1.
	 * 
	 * @param s
	 *            The number of members in the UpTree.
	 */
	public UpTree(int s) {

		this.size = s;

		for (int i = 0; i < this.size; i++) {

			disjointSet.insert(-1);
		}
	}

	/**
	 * Finds the root of a member.
	 * 
	 * @param p
	 *            The member to find the root of.
	 * @return The root of p.
	 */
	public int find(int p) {

		while (p > -1) {

			p = disjointSet.lookUp(p);
		}

		int i = 0;
		
		while(true) {
			
			if(disjointSet.lookUp(i) == p)
				return i;
			else
				i++;
		}
	}

	/**
	 * Unions two sets together.
	 * 
	 * @param s
	 *            The first set.
	 * @param t
	 *            The second set.
	 * @return The root of the new set.
	 */
	public int union(int s, int t) {

		if (this.disjointSet.lookUp(s) >= this.disjointSet.lookUp(t)) {

			this.disjointSet.replace(s, disjointSet.lookUp(s) + disjointSet.lookUp(t));
			this.disjointSet.replace(t, s);
			this.size--;
			return this.disjointSet.lookUp(s);
		} else {

			this.disjointSet.replace(t, disjointSet.lookUp(s) + disjointSet.lookUp(t));
			this.disjointSet.replace(s, t);
			this.size--;
			return this.disjointSet.lookUp(t);
		}
	}
}
