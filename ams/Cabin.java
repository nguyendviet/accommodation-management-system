package ams;

/**
 * 
 */
public class Cabin extends Account {

	private boolean hasFullKitchen;
	private boolean hasLoft;

	/**
	 * @param accountNumber 
	 * @param address 
	 * @param phoneNumber 
	 * @param email 
	 */
	public Cabin(String accountNumber, Address address, String phoneNumber, String email) {
		// Call parent's constructor
		super(accountNumber, address, phoneNumber, email);
		// Validate parameters 
		Helper.validateParameters(accountNumber, address.toString(), phoneNumber);
	}

	/**
	 * Overloading constructor if has full kitchen and or loft
	 * @param accountNumber 
	 * @param address 
	 * @param phoneNumber 
	 * @param email 
	 * @param hasFullKitchen 
	 * @param hasLoft
	 */
	public Cabin(String accountNumber, Address address, String phoneNumber, String email, boolean hasFullKitchen, boolean hasLoft) {
		// Call parent's constructor
		super(accountNumber, address, phoneNumber, email);
		// Validate parameters 
		Helper.validateParameters(accountNumber, address.toString(), phoneNumber);
		// Assign parameters's values to attributes
		this.hasFullKitchen = hasFullKitchen;
		this.hasLoft = hasLoft;
	}

	/**
	 * Overriding parent's method
	 * @return String in XML format
	 */
	public String toString() {
		return 
			"<cabin>" + 
				super.toString() + 
				"<hasFullKitchen>" + hasFullKitchen + "</hasFullKitchen>" +
				"<hasLoft>" + hasLoft + "</hasLoft>" + 
			"</cabin>";
	}

	public boolean getHasFullKitchen() {
		return hasFullKitchen;
	}

	public boolean getHasLoft() {
		return hasLoft;
	}

	/**
	 * @param hasFullKitchen
	 */
	public void setHasFullKitchen(boolean hasFullKitchen) {
		this.hasFullKitchen = hasFullKitchen;
	}

	/**
	 * @param hasLoft
	 */
	public void setHasLoft(boolean hasLoft) {
		this.hasLoft = hasLoft;
	}

}
