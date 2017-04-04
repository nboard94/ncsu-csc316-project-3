package edu.ncsu.csc316.transportation_manager.list;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

/**
 * Test class for the adjacency list.
 * @author Nicholas Board (ndboard)
 */
public class AdjacencyListTest {

	/**
	 * Tests the construction and functionality of the adjacency list.
	 */
	@Test
	public void adjacencyListTest() {
		
		//Construct empty AdjacencyList
		AdjacencyList al = new AdjacencyList();
		assertEquals(0, al.getVertexCount());
		
		//Add vertices
		al.insertVertex(1);
		al.insertVertex(3);
		al.insertVertex(0);
		al.insertVertex(2);
		al.insertVertex(10);
		
		assertEquals(5, al.getVertexCount());
		assertEquals(0, al.getVertexList().lookUp(0).vertex);
		assertEquals(1, al.getVertexList().lookUp(1).vertex);
		assertEquals(2, al.getVertexList().lookUp(2).vertex);
		assertEquals(3, al.getVertexList().lookUp(3).vertex);
		assertEquals(10, al.getVertexList().lookUp(4).vertex);
		
		//Remove first vertex
		al.removeVertex(0);
		assertEquals(4, al.getVertexCount());
		assertEquals(1, al.getVertexList().lookUp(0).vertex);
		assertEquals(2, al.getVertexList().lookUp(1).vertex);
		assertEquals(3, al.getVertexList().lookUp(2).vertex);
		assertEquals(10, al.getVertexList().lookUp(3).vertex);
		
		//Remove middle vertex
		al.removeVertex(2);
		assertEquals(3, al.getVertexCount());
		assertEquals(1, al.getVertexList().lookUp(0).vertex);
		assertEquals(3, al.getVertexList().lookUp(1).vertex);
		assertEquals(10, al.getVertexList().lookUp(2).vertex);
		
		//Remove last vertex
		al.removeVertex(10);
		assertEquals(2, al.getVertexCount());
		assertEquals(1, al.getVertexList().lookUp(0).vertex);
		assertEquals(3, al.getVertexList().lookUp(1).vertex);
		
		//Add some edges
		al.insertEdge(1, 2, 3, 4.5, 6.7);
		al.insertEdge(1, 0, 0, 4.5, 6.7);
		al.insertEdge(1, 4, 4, 4.5, 6.7);
		assertEquals(3, al.findVertex(1).edges.size());
		
		assertEquals(0, al.findVertex(1).edges.lookUp(0).endpoint1);
		assertEquals(0, al.findVertex(1).edges.lookUp(0).endpoint2);
		assertEquals(4.5, al.findVertex(1).edges.lookUp(0).costOne, 0);
		assertEquals(6.7, al.findVertex(1).edges.lookUp(0).costTwo, 0);
		
		assertEquals(2, al.findVertex(1).edges.lookUp(1).endpoint1);
		assertEquals(3, al.findVertex(1).edges.lookUp(1).endpoint2);
		assertEquals(4.5, al.findVertex(1).edges.lookUp(1).costOne, 0);
		assertEquals(6.7, al.findVertex(1).edges.lookUp(1).costTwo, 0);

		assertEquals(4, al.findVertex(1).edges.lookUp(2).endpoint1);
		assertEquals(4, al.findVertex(1).edges.lookUp(2).endpoint2);
		assertEquals(4.5, al.findVertex(1).edges.lookUp(2).costOne, 0);
		assertEquals(6.7, al.findVertex(1).edges.lookUp(2).costTwo, 0);
		
		//Remove edges
		al.removeEdge(1, 2, 3);
		
		//Find vertex position
		assertEquals(0, al.findVertexPosition(1));
		assertEquals(-1, al.findVertexPosition(666));
		
		//Find vertex
		assertNull( al.findVertex(666));
	}
}
