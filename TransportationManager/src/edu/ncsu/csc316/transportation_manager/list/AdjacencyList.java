package edu.ncsu.csc316.transportation_manager.list;

/**
 * This class represents an AdjacencyList for
 * Highway information.
 * 
 * @author Nicholas Board (ndboard)
 */
public class AdjacencyList {
	
	
	/**
	 * This inner class represents vertices
	 * in the adjacency list.
	 * @author Nicholas Board (ndboard)
	 */
	private class Vertex {
		
		/** The vertex identifier. */
		int vertex;
		/** The list of edges to this vertex. */
		ArrayBasedList<Edge> edges;
		/** The amount of edges incident to this vertex. */
		int eCount;
		
		/**
		 * Constructs a vertex object.
		 * @param The vertex identifier.
		 */
		Vertex( int vertex ) {
			
			this.vertex = vertex;
			edges = new ArrayBasedList<Edge>();
			eCount = 0;
		}
	}
	
	/**
	 * This inner class represents edges
	 * in the adjacency list.
	 * @author Nicholas Board (ndboard)
	 */
	private class Edge {
		
		/** The adjVertex identifier. */
		int adjVertex;
		/** The edge identifier. */
		double edge;
		
		/**
		 * Constructs an edge object.
		 * @param The adjVertex identifier.
		 * @param The edge identifer.
		 */
		Edge( int adjVertex, double edge ) {
			
			this.adjVertex = adjVertex;
			this.edge = edge;
		}
	}
	
	/** Stores the vertices in the adjacency list. */
	ArrayBasedList<Vertex> adjList;
	/** The amount of vertices in the adjacency list. */
	int vCount;
	
	/**
	 * Constructor for the adjacency list.
	 */
	public AdjacencyList() {
		
		adjList = new ArrayBasedList<Vertex>();
		vCount = 0;
	}
	
	/**
	 * Inserts a vertex into the adjacency list.
	 * @param The vertex identifier.
	 */
	public void insertVertex(int vertex) {
		
		adjList.insert( new Vertex( vertex ) );
		vCount++;
	}
	
	/**
	 * Inserts an adjacent vertex into the adjacency list.
	 * @param The adjVertex identifier.
	 * @param The edge identifier.
	 */
	public void insertEdge(int adjVertex, double edge) {
		
		Vertex current;
		for( int i = 0; i < vCount; i++ ) {
			
			current = adjList.lookUp(i);
			if ( current.vertex == adjVertex ) {
				
				current.edges.insert( new Edge(adjVertex, edge) );
				current.eCount++;
			}
		}
	}
	
	/**
	 * Removes a vertex from the adjacency list.
	 * @param The vertex to remove.
	 */
	public void removeVertex(int vertex) {
		
		for( int i = 0; i < vCount; i++ ) {
			
			if( adjList.lookUp(i).vertex == vertex ) {
				
				adjList.remove(i);
			}
		}
	}
	
	/**
	 * Removes an edge from the adjacency list.
	 * @param The vertex that matches the edge-to-remove's adjVertex.
	 * @param The edge to remove.
	 */
	public void removeEdge(int vertex, double edge) {
		
		Vertex current;
		for( int i = 0; i < vCount; i++ ) {
			
			current = adjList.lookUp(i);
			for( int j = 0; j < current.eCount; j++ ) {
				
				if( current.edges.lookUp(j).adjVertex == vertex && current.edges.lookUp(j).edge == edge ) {
					
					current.edges.remove(j);
				}
			}
		}
	}
}
