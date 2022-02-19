package ams;

public class Address {

	private String street;
	private String city;
	private String state;
	private String zipcode;

	/**
	 * @param street 
	 * @param city 
	 * @param state 
	 * @param zipcode
	 */
	public Address(String street, String city, String state, String zipcode) {
		// Validate parameters
		Helpers.validateParameters(street, city, state, zipcode);
		// Save values to attributes
		this.street = street;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
	}

	/**
	 * @return String in XML format
	 */
	public String toString() {
		return 
			"<address>" + 
				"<street>" + street + "</street>" +
				"<city>" + city + "</city>" +
				"<state>" + state + "</state>" +
				"<zipcode" + zipcode + "</zipcode>" +
			"</address>";
	}

	public String getStreet() {
		return street;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public String getZipCode() {
		return zipcode;
	}

	/**
	 * @param street
	 */
	public void setStreet(String street) {
		Helpers.validateParameters(street);
		this.street = street;
	}

	/**
	 * @param city
	 */
	public void setCity(String city) {
		Helpers.validateParameters(city);
		this.city = city;
	}

	/**
	 * @param state
	 */
	public void setState(String state) {
		Helpers.validateParameters(state);
		this.state = state;
	}

	/**
	 * @param zipcode
	 */
	public void setZipCode(String zipcode) {
		Helpers.validateParameters(zipcode);
		this.zipcode = zipcode;
	}

}