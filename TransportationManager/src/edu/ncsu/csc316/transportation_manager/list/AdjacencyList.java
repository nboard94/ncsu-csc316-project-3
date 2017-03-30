package edu.ncsu.csc316.transportation_manager.list;

import edu.ncsu.csc316.transportation_manager.highway.Highway;

public class AdjacencyList {
	
	private class Node {
		
		int vertex;
		double edge;
		Node next;
		
		Node(int vertex, double edge) {
			
			this.vertex = vertex;
			this.edge = edge;
			next = null;
		}
	}
	
	ArrayBasedList<Highway> highwayData = new ArrayBasedList<Highway>();
	ArrayBasedList<Node> vertices = new ArrayBasedList<Node>();
	
	public AdjacencyList() {
		
	}
	
	public void newVertex(int vertex) {
		
		vertices.insert( new Node(vertex, 0.0) );
	}
}
