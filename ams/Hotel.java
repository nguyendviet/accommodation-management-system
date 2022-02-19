package ams;
import java.util.*;

/**
 * 
 */
public class Hotel extends Account {

	/**
	 * Call parent's constructor
	 * Validate parameters 
	 * Assign parameters's values to attributes
	 * @param accountNumber 
	 * @param address 
	 * @param phoneNumber 
	 * @param email 
	 */
	public Hotel(String accountNumber, Address address, String phoneNumber, String email) {
		super(accountNumber, address, phoneNumber, email);
	}

	/**
	 * Overload constructor if has kitchenette
	 * Call parent's constructor
	 * Validate parameters 
	 * Assign parameters's values to attributes
	 * @param accountNumber 
	 * @param address 
	 * @param phoneNumber 
	 * @param email 
	 * @param hasKitchenette
	 */
	public Hotel(String accountNumber, Address address, String phoneNumber, String email, boolean hasKitchenette) {
		super(accountNumber, address, phoneNumber, email);
	}

	/**
	 * 
	 */
	private boolean hasKitchenette;

	/**
	 * Overriding parent's method
	 * return "<hotel>" + super.toString() + "<hasKitchenette>" + hasKitchenette + "</hotel>";
	 * @return
	 */
	public String toString() {
		// TODO implement here
		return "";
	}

	/**
	 * @return
	 */
	public boolean getHasKitchenette() {
		// TODO implement here
		return false;
	}

	/**
	 * @param hasKitchenette
	 */
	public void setHasKitchenette(boolean hasKitchenette) {
		// TODO implement here
	}

}