package edu.ncsu.csc316.transportation_manager.highway;

/**
 * Class that handles the creation and functionality of highway objects. Stores
 * the highway information.
 * 
 * @author Nicholas Board (ndboard)
 */
public class Highway {

	/** The highway's city. */
	int city1;
	/** The highway's city. */
	int city2;
	/** The highway's cost. */
	double cost;
	/** The highway's asphalt amount. */
	double asphalt;

	/**
	 * Constructs a Highway with the given information
	 * 
	 * @param city1
	 *            city1 of the highway
	 * @param city2
	 *            city2 of the highway
	 * @param cost
	 *            cost of building the highway
	 * @param asphalt
	 *            amount (in miles) of asphalt needed to build the highway
	 */
	public Highway(int city1, int city2, double cost, double asphalt) {

		this.setCity1(city1);
		this.setCity2(city2);
		this.setCost(cost);
		this.setAsphalt(asphalt);
	}

	/**
	 * Returns a string representation of the Highway in the format:
	 * 
	 * Highway[city1=X, city2=X, cost=X.X, asphalt=X.X]
	 * 
	 * @return the string representation of the highway
	 */
	@Override
	public String toString() {

		return "Highway[city1=" + city1 + ", city2=" + city2 + ", cost=" + cost + ", asphalt=" + asphalt + "]";
	}

	/**
	 * Gets the highway's first city.
	 * 
	 * @return the city1
	 */
	public int getCity1() {
		return city1;
	}

	/**
	 * Sets the highway's first city.
	 * 
	 * @param city1
	 *            the city1 to set
	 */
	public void setCity1(int city1) {
		this.city1 = city1;
	}

	/**
	 * Gets the highway's second city.
	 * 
	 * @return the city2
	 */
	public int getCity2() {
		return city2;
	}

	/**
	 * Sets the highway's second city.
	 * 
	 * @param city2
	 *            the city2 to set
	 */
	public void setCity2(int city2) {
		this.city2 = city2;
	}

	/**
	 * Gets the highway's cost.
	 * 
	 * @return the cost
	 */
	public double getCost() {
		return cost;
	}

	/**
	 * Set's the highway's cost.
	 * 
	 * @param cost
	 *            the cost to set
	 */
	public void setCost(double cost) {
		this.cost = cost;
	}

	/**
	 * Gets the highway's asphalt amount.
	 * 
	 * @return the asphalt
	 */
	public double getAsphalt() {
		return asphalt;
	}

	/**
	 * Sets the highway's aspahlt amount.
	 * 
	 * @param asphalt
	 *            the asphalt to set
	 */
	public void setAsphalt(double asphalt) {
		this.asphalt = asphalt;
	}
}
