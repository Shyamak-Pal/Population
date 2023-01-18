/**
 *	City data - the city name, state name, location designation,
 *				and population est. 2017
 *
 *	@author	Shyamak Pal
 *	@since	January 12 2023
 */
public class City implements Comparable<City> {
	
	// fields
	private String name, state, designation;
	private int population;
	// constructor
	public City( String stateName,String city, String type, int pop){
		name = city;
		state = stateName;
		designation = type;
		population = pop;
	}
	/**	Compare two cities populations
	 *	@param other		the other City to compare
	 *	@return				the following value:
	 *		If populations are different, then returns (this.population - other.population)
	 *		else if states are different, then returns (this.state - other.state)
	 *		else returns (this.name - other.name)
	 */
	public int compareTo(City other){
		if(population != other.population) return population - other.population;
		else if(!state.equals(other.state)) return state.compareTo(other.state);
		else return name.compareTo(other.name);
	}
	
	/**	Equal city name and state name
	 *	@param other		the other City to compare
	 *	@return				true if city name and state name equal; false otherwise
	 */
	public boolean equals(City other){
		return (name.equals(other.name) && state.equals(other.state));
	}
	
	/**	Accessor methods */
	public String getName() {	return name;	}
	public String getState() {	return state;	}
	public String getDesignation() {	return designation;	}
	public int getPopulation() {	return population;	}
	
	/**	toString */
	@Override
	public String toString() {
		return String.format("%-22s %-22s %-12s %,12d", state, name, designation,
						population);
	}
}
