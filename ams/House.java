package ams;

public class House extends Account {

	private int floorCount;

	/**
	 * @param accountNumber 
	 * @param address 
	 * @param phoneNumber 
	 * @param email 
	 * @param floorCount
	 */
	public House(String accountNumber, Address address, String phoneNumber, String email, int floorCount) {
		// Call parent's constructor
		super(accountNumber, address, phoneNumber, email);
		// Assign parameters's values to attributes
		this.floorCount = floorCount;
	}

	/**
	 * Overriding parent's method
	 * @returns String in XML format
	 */
	public String toString() {
		return 
			"<house>" + 
				super.toString() + 
				"<floorCount>" + floorCount + "</floorCount>" +
			"</house>";
	}

	public int getFloorCount() {
		return floorCount;
	}

	/**
	 * @param floorCount
	 */
	public void setFloorCount(int floorCount) {
		this.floorCount = floorCount;
	}

}