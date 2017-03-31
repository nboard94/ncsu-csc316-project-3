package edu.ncsu.csc316.transportation_manager.list;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.ncsu.csc316.transportation_manager.list.AdjacencyList.Vertex;

/**
 * Tests the adjacency list data structure
 * and its functionality.
 * 
 * @author Nicholas Board (ndboard)
 */
public class AdjacencyListTest {

	/**
	 * Tests the contruction and functionality
	 * of the adjacency list.
	 */
	@Test
	public void adjacencyListTest() {
		
		//Test constructing an adjacency list.
		AdjacencyList list = new AdjacencyList();
		assertEquals(0, list.getVertexCount());
		
		//Test adding to empty list.
		list.insertVertex( 11 );
		assertEquals(11, list.lookupVertex(0).vertex);
		assertEquals(1, list.getVertexCount());
		
		//Test adding vertex to the list.
		list.insertVertex( 29 );
		assertEquals(29, list.lookupVertex(1).vertex);
		assertEquals(2, list.getVertexCount());
		
		list.insertVertex( 1994 );
		assertEquals(1994, list.lookupVertex(2).vertex);
		assertEquals(3, list.getVertexCount());
		
		//Test remove first vertex.
		list.removeVertex(11);
		assertEquals(29, list.lookupVertex(0).vertex);
		assertEquals(1994, list.lookupVertex(1).vertex);
		assertEquals(2, list.getVertexCount());
		
		//Test removing at the end.
		list.removeVertex(1994);
		assertEquals(29, list.lookupVertex(0).vertex);
		assertEquals(1, list.getVertexCount());
		
		//Test adding an edge to an empty list.
		list.insertEdge(29, 11);
		assertEquals(29, list.lookupVertex(0).edges.lookUp(0).adjVertex);
		assertEquals(11, list.lookupVertex(0).edges.lookUp(0).edge, 0);
		assertEquals(1, list.lookupVertex(0).eCount);
		
		//Test adding edge to nonempty edge list.
		list.insertEdge(29, 1994);
		assertEquals(29, list.lookupVertex(0).edges.lookUp(1).adjVertex);
		assertEquals(1994, list.lookupVertex(0).edges.lookUp(1).edge, 0);
		assertEquals(2, list.lookupVertex(0).eCount);
		
		//Test removing an edge.
		list.removeEdge(29, 11);
		assertEquals(29, list.lookupVertex(0).edges.lookUp(0).adjVertex);
		assertEquals(1994, list.lookupVertex(0).edges.lookUp(0).edge, 0);
		assertEquals(1, list.lookupVertex(0).eCount);
		
		//Test getting the vertex list.
		ArrayBasedList<Vertex> vertices = list.getVertexList();
		assertEquals(1, vertices.size());
	}
}
