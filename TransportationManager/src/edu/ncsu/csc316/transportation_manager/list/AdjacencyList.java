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
	public class Vertex {
		
		/** The vertex identifier. */
		public int vertex;
		/** The list of edges to this vertex. */
		public ArrayBasedList<Edge> edges;
		/** The amount of edges incident to this vertex. */
		public int eCount;
		
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
	public class Edge {
		
		/** The adjVertex identifier. */
		public int vertex;
		/** The first endpoint in the edge. */
		public int endpoint1;
		/** The second endpoint in the edge. */
		public int endpoint2;
		/** The first edge identifier. */
		public double costOne;
		/** The second edge identifier. */
		public double costTwo;
		
		/**
		 * Constructs an edge object.
		 * @param The adjVertex identifier.
		 * @param The edge identifier.
		 */
		public Edge( int vertex, int endpoint1, int endpoint2, double costOne, double costTwo ) {
			
			this.vertex = vertex;
			this.endpoint1 = endpoint1;
			this.endpoint2 = endpoint2;
			this.costOne = costOne;
			this.costTwo = costTwo;
		}
	}
	
	/** Stores the vertices in the adjacency list. */
	private ArrayBasedList<Vertex> adjList;
	/** The amount of vertices in the adjacency list. */
	private int vCount;
	
	/**
	 * Constructor for the adjacency list.
	 */
	public AdjacencyList() {
		
		adjList = new ArrayBasedList<Vertex>();
		vCount = 0;
	}
	
	/**
	 * Inserts a vertex into the adjacency list.
	 * Keeps the vertices in sorted order.
	 * @param The vertex identifier.
	 */
	public void insertVertex(int vertex) {
		
		adjList.insert( new Vertex( vertex ) );
		vCount++;
		
		for( int i = 0; i < vCount; i++ ) {
			
			for( int j = 1; j < (vCount - i); j++ ) {
				
				if( adjList.lookUp(j - 1).vertex > adjList.lookUp(j).vertex )
					adjList.swap(j - 1, j);
			}
		}
	}
	
	/**
	 * Inserts an adjacent vertex into the adjacency list.
	 * Keeps the edges in sorted order by city 1 and then city 2.
	 * @param The adjVertex identifier.
	 * @param The edge identifier.
	 */
	public void insertEdge(int vertex, int endpoint1, int endpoint2, double costOne, double costTwo ) {
		
		Vertex current;
		for( int i = 0; i < vCount; i++ ) {
			
			current = adjList.lookUp(i);
			if ( current.vertex == vertex ) {
				
				current.edges.insert( new Edge(vertex, endpoint1, endpoint2, costOne, costTwo) );
				current.eCount++;
				
				for( int j = 0; j < current.eCount; j++ ) {
					
					for( int k = 1; k < (current.eCount - j); k++ ) {
						
						if ( current.edges.lookUp( k - 1).endpoint1 > current.edges.lookUp( k ).endpoint1 ) {
							
							current.edges.swap(k - 1, k);
						}
						else if ( current.edges.lookUp( k - 1).endpoint1 == current.edges.lookUp(k).endpoint1 ) {
							
							if ( current.edges.lookUp( k - 1).endpoint2 > current.edges.lookUp(k).endpoint2 )
								current.edges.swap(k-1, k);
						}
					}
				}
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
				vCount--;
			}
		}
	}
	
	/**
	 * Removes an edge from the adjacency list.
	 * @param The vertex that matches the edge-to-remove's adjVertex.
	 * @param The edge to remove.
	 */
	public void removeEdge(int vertex, double endpointOne, double endpointTwo ) {
		
		Vertex current;
		for( int i = 0; i < vCount; i++ ) {
			
			current = adjList.lookUp(i);
			for( int j = 0; j < current.eCount; j++ ) {
				
				if( current.edges.lookUp(j).vertex == vertex 
						&& current.edges.lookUp(j).endpoint1 == endpointOne
						&& current.edges.lookUp(j).endpoint2 == endpointTwo ) {
					
					current.edges.remove(j);
					current.eCount--;
				}
			}
		}
	}
	
	/**
	 * Gets the adjacency list.
	 * @return The adjacency list.
	 */
	public ArrayBasedList<Vertex> getVertexList() {
		
		return this.adjList;
	}
	
	/**
	 * Gets the vertex count.
	 * @return The vertex count.
	 */
	public int getVertexCount() {
		
		return this.vCount;
	}
	
	/**
	 * Given the parameter, finds and returns the
	 * position of the given vertex.
	 * @param The vertex to find.
	 * @return The position of the vertex to find, otherwise -1.
	 */
	public int findVertexPosition(int vertex) {
		
		for( int i = 0; i < this.adjList.size(); i++ ) {
			
			if ( this.adjList.lookUp(i).vertex == vertex ) {
				
				return i;
			}
		}
		
		return -1;
	}
	
	/**
	 * Given the parameter, finds and returns the vertex.
	 * @param The vertex to find.
	 * @return The vertex, or null.
	 */
	public Vertex findVertex(int vertex) {
		
		for( int i = 0; i < this.adjList.size(); i++ ) {
			
			if ( this.adjList.lookUp(i).vertex == vertex ) {
				
				return this.adjList.lookUp(i);
			}
		}
		
		return null;
	}
}
