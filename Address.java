import java.util.*;

/**
 * 
 */
public class Address {

	/**
	 * Validate parameters
	 * Save values to attributes
	 * @param street 
	 * @param city 
	 * @param state 
	 * @param zipcode
	 */
	public Address(String street, String city, String state, String zipcode) {
		Helpers.validateParameters(street, city, state, zipcode);
		this.street = street;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
	}

	/**
	 * 
	 */
	private String street;

	/**
	 * 
	 */
	private String city;

	/**
	 * 
	 */
	private String state;

	/**
	 * 
	 */
	private String zipcode;

	/**
	 * Format and return object's data in XML format
	 * return "<address>" + "<street>" + street + "</street>" + ... + "</address>";
	 * @return
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

	/**
	 * @return
	 */
	public String getStreet() {
		// TODO implement here
		return "";
	}

	/**
	 * @return
	 */
	public String getCity() {
		// TODO implement here
		return "";
	}

	/**
	 * @return
	 */
	public String getState() {
		// TODO implement here
		return "";
	}

	/**
	 * @return
	 */
	public String getZipCode() {
		// TODO implement here
		return "";
	}

	/**
	 * @param street
	 */
	public void setStreet(String street) {
		// TODO implement here
	}

	/**
	 * @param city
	 */
	public void setCity(String city) {
		// TODO implement here
	}

	/**
	 * @param state
	 */
	public void setState(String state) {
		// TODO implement here
	}

	/**
	 * @param zipcode
	 */
	public void setZipCode(String zipcode) {
		// TODO implement here
	}

}