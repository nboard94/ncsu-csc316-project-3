package edu.ncsu.csc316.transportation_manager.manager;

public class TransportationManager {

	/**
	 * Constructs a new TransportationManager
	 * 
	 * @param pathToFile the path to the file that contains the set of highways in the graph
	 */
	public TransportationManager(String pathToFile)
	{
	    // Your code
	}
	
	/**
	 * Returns a string representation of the AdjacencyList
	 * in the following format, where (for each city) the Highways are
	 * in sorted order by city1, then city2, then cost, then asphalt:
	 * 
	 * AdjacencyList[
	 *    City 0: -> Highway[city1=X, city2=X, cost=X.X, asphalt=X.X] -> Highway[city1=X, city2=X, cost=X.X, asphalt=X.X] -> Highway[city1=X, city2=X, cost=X.X, asphalt=X.X]
	 *    City 1: -> Highway[city1=X, city2=X, cost=X.X, asphalt=X.X] -> Highway[city1=X, city2=X, cost=X.X, asphalt=X.X]
	 *    City 2: -> Highway[city1=X, city2=X, cost=X.X, asphalt=X.X] -> Highway[city1=X, city2=X, cost=X.X, asphalt=X.X] -> Highway[city1=X, city2=X, cost=X.X, asphalt=X.X]
	 *    City 3: -> Highway[city1=X, city2=X, cost=X.X, asphalt=X.X]
	 * ]
	 * 
	 * @return the string representation of the AdjacencyLists
	 */
	public String getAdjacencyList()
	{
		return null;
	    // Your code
	}
	
	/**
	 * Returns a string representation of the list of Highways contained in the 
	 * minimum spanning set of Highways. The returned string is in the following format,
	 * where the Highways are in sorted order by city1, city2, then cost, then asphalt:
	 * 
	 * List[
	 *    Highway[city1=X, city2=X, cost=X.X, asphalt=X.X],
	 *    Highway[city1=X, city2=X, cost=X.X, asphalt=X.X],
	 *    Highway[city1=X, city2=X, cost=X.X, asphalt=X.X]
	 * ]
	 * 
	 * @param type the type ("COST" or "ASPHALT") of field to minimize
	 * @return a string representation of the minimum spanning set of Highways
	 */
	public String getMinimumHighways(String type)
	{
		return type;
	    // Your code
	}
}
