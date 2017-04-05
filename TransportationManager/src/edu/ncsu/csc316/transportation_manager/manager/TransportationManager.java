package edu.ncsu.csc316.transportation_manager.manager;

import java.io.FileNotFoundException;

import edu.ncsu.csc316.transportation_manager.highway.Highway;
import edu.ncsu.csc316.transportation_manager.io.HighwayReader;
import edu.ncsu.csc316.transportation_manager.list.AdjacencyList;
import edu.ncsu.csc316.transportation_manager.list.AdjacencyList.Edge;
import edu.ncsu.csc316.transportation_manager.list.AdjacencyList.Vertex;
import edu.ncsu.csc316.transportation_manager.list.ArrayBasedList;
import edu.ncsu.csc316.transportation_manager.util.MinimumHighwayFinder;

/**
 * The manager class that drives most of the program.
 * 
 * @author Nick Board
 */
public class TransportationManager {

	HighwayReader hr;
	ArrayBasedList<Highway> highways = new ArrayBasedList<Highway>();
	AdjacencyList adjList = new AdjacencyList();

	/**
	 * Constructs a new TransportationManager
	 * 
	 * @param pathToFile
	 *            the path to the file that contains the set of highways in the
	 *            graph
	 * @throws FileNotFoundException
	 */
	public TransportationManager(String pathToFile) {

		try {
			hr = new HighwayReader(pathToFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		highways = hr.getHighways();

		Highway current;
		int city1;
		int city2;
		double cost;
		double asphalt;
		for (int i = 0; i < highways.size(); i++) {

			current = highways.lookUp(i);
			city1 = current.getCity1();
			city2 = current.getCity2();
			cost = current.getCost();
			asphalt = current.getAsphalt();

			if (adjList.findVertexPosition(city1) == -1) {

				adjList.insertVertex(city1);
			}

			if (adjList.findVertexPosition(city2) == -1) {

				adjList.insertVertex(city2);
			}

			adjList.insertEdge(city1, city1, city2, cost, asphalt);
			adjList.insertEdge(city2, city1, city2, cost, asphalt);

		}

	}

	/**
	 * Returns a string representation of the AdjacencyList in the following
	 * format, where (for each city) the Highways are in sorted order by city1,
	 * then city2, then cost, then asphalt:
	 * 
	 * AdjacencyList[ City 0: -> Highway[city1=X, city2=X, cost=X.X,
	 * asphalt=X.X] -> Highway[city1=X, city2=X, cost=X.X, asphalt=X.X] ->
	 * Highway[city1=X, city2=X, cost=X.X, asphalt=X.X] City 1: ->
	 * Highway[city1=X, city2=X, cost=X.X, asphalt=X.X] -> Highway[city1=X,
	 * city2=X, cost=X.X, asphalt=X.X] City 2: -> Highway[city1=X, city2=X,
	 * cost=X.X, asphalt=X.X] -> Highway[city1=X, city2=X, cost=X.X,
	 * asphalt=X.X] -> Highway[city1=X, city2=X, cost=X.X, asphalt=X.X] City 3:
	 * -> Highway[city1=X, city2=X, cost=X.X, asphalt=X.X] ]
	 * 
	 * @return the string representation of the AdjacencyLists
	 */
	public String getAdjacencyList() {
		StringBuilder sb = new StringBuilder();
		Vertex currentV;
		Edge currentE;

		sb.append("AdjacencyList[");

		for (int i = 0; i < adjList.getVertexCount(); i++) {

			currentV = adjList.getVertexList().lookUp(i);
			sb.append("\n\tCity " + currentV.vertex + ":");

			for (int j = 0; j < currentV.eCount; j++) {

				currentE = currentV.edges.lookUp(j);
				sb.append(" -> Highway[city1=" + currentE.endpoint1 + ", city2=" + currentE.endpoint2 + ", cost="
						+ currentE.costOne + ", asphalt=" + currentE.costTwo + "]");
			}
		}

		sb.append("\n]");

		return sb.toString();
	}

	/**
	 * Returns a string representation of the list of Highways contained in the
	 * minimum spanning set of Highways. The returned string is in the following
	 * format, where the Highways are in sorted order by city1, city2, then
	 * cost, then asphalt:
	 * 
	 * List[ Highway[city1=X, city2=X, cost=X.X, asphalt=X.X], Highway[city1=X,
	 * city2=X, cost=X.X, asphalt=X.X], Highway[city1=X, city2=X, cost=X.X,
	 * asphalt=X.X] ]
	 * 
	 * @param type
	 *            the type ("COST" or "ASPHALT") of field to minimize
	 * @return a string representation of the minimum spanning set of Highways
	 */
	public String getMinimumHighways(String type) {
		MinimumHighwayFinder minimumHighwayFinder = new MinimumHighwayFinder(highways, adjList, type);
		ArrayBasedList<Highway> minHigh = minimumHighwayFinder.getMST();
		StringBuilder sb = new StringBuilder();


		sb.append("List[");

//		List[
//		     Highway[city1=1, city2=0, cost=5.0, asphalt=99.0],
//		     Highway[city1=1, city2=2, cost=6.0, asphalt=72.0],
//		     Highway[city1=3, city2=1, cost=10.0, asphalt=112.0]
//		  ]
		
		Highway c;
		for(int i = 0; i < minHigh.size(); i++) {
			
			c = minHigh.lookUp(i);
			
			if( i == minHigh.size() - 1)
				sb.append("\n\tHighway[city1=" + c.getCity1() + ", city2=" + c.getCity2() + ", cost=" + c.getCost() + ", asphalt=" + c.getAsphalt() + "]");
			else
				sb.append("\n\tHighway[city1=" + c.getCity1() + ", city2=" + c.getCity2() + ", cost=" + c.getCost() + ", asphalt=" + c.getAsphalt() + "],");
		
		}

		sb.append("\n]");

		return sb.toString();
	}
}
