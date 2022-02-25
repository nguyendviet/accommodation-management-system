package ams;

/**
 * 
 */
public class Hotel extends Account {

	private boolean hasKitchenette;

	/**
	 * @param accountNumber 
	 * @param address 
	 * @param phoneNumber 
	 * @param email 
	 */
	public Hotel(String accountNumber, Address address, String phoneNumber, String email) {
		// Call parent's constructor
		super(accountNumber, address, phoneNumber, email);
		// Validate parameters 
		Helper.validateParameters(accountNumber, address.toString(), phoneNumber);
	}

	/**
	 * Overload constructor if has kitchenette
	 * @param accountNumber 
	 * @param address 
	 * @param phoneNumber 
	 * @param email 
	 * @param hasKitchenette
	 */
	public Hotel(String accountNumber, Address address, String phoneNumber, String email, boolean hasKitchenette) {
		// Call parent's constructor
		super(accountNumber, address, phoneNumber, email);
		// Validate parameters 
		Helper.validateParameters(accountNumber, address.toString(), phoneNumber);
		// Assign parameters's values to attributes
		this.hasKitchenette = hasKitchenette;
	}

	/**
	 * Overriding parent's method
	 * @return String in XML format
	 */
	public String toString() {
		return 
			"<hotel>" + 
				super.toString() + 
				"<hasKitchenette>" + hasKitchenette + "</hasKitchenette>" +
			"</hotel>";
	}

	public boolean getHasKitchenette() {
		return hasKitchenette;
	}

	/**
	 * @param hasKitchenette
	 */
	public void setHasKitchenette(boolean hasKitchenette) {
		this.hasKitchenette = hasKitchenette;
	}

}