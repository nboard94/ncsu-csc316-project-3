package edu.ncsu.csc316.transportation_manager.set;

import edu.ncsu.csc316.transportation_manager.list.ArrayBasedList;

/**
 * Represents an UpTree disjoint set.
 * @author Nicholas Board (ndboard)
 */
public class UpTree {

	
	/**
	 * Inner Node class of the disjoint set.
	 * @author Nicholas Board (ndboard)
	 */
	public class Node {
		
		/** The key of the node. */
		private int key;
		/** The value of the node. */
		private int value;
		/** Pointer to parent node, or null. */
		private Node parent;
		/** If root, number of tree nodes.  Null otherwise. */
		private int count;
		
		Node(int key, int value, Node parent, int count) {
			
			this.key = key;
			this.value = value;
			this.parent = parent;
			this.count = count;
		}
	}
	
	private ArrayBasedList<Node> rootNodes = new ArrayBasedList<Node>();
	
	/**
	 * Constructor for an UpTree.
	 */
	public UpTree() {
		
	}
	
	/**
	 * Creates a new node, sets parent's field to
	 * null, sets count to one.
	 * @param key The key of the new node.
	 * @param value The value of the new node.
	 * @return The new root node.
	 */
	public Node makeSet(int key, int value) {
		
		Node newNode = new Node(key, value, null, 1);
		rootNodes.insertAt(newNode, key);
		
		return rootNodes.lookUp(key);
	}
	
	/**
	 * Finds the root of the given node.
	 * @param p The node to find the root of.
	 * @return The root of the given node.
	 */
	public Node find(Node p) {
		
		while(p.parent != null) {
			
			p = p.parent;
		}
		
		return p;
	}
	
	/**
	 * Unions two disjoint sets together.
	 * @param S One node to union.
	 * @param T Another node to union.
	 * @return The root of the new Node.
	 */
	public Node union(Node S, Node T) {
		
		if( S.count >= T.count ) {
			
			S.count = S.count + T.count;
			T.parent = S;
			rootNodes.remove( T.key );
			
			return S;
		}
		else {
			
			T.count = T.count + S.count;
			S.parent = T;
			rootNodes.remove( S.key );
			
			return T;
		}
	}
	
	public ArrayBasedList<Node> getRoots() {
		
		return this.rootNodes;
	}
}
