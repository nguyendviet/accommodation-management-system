
import java.util.*;

/**
 * 
 */
public class Hotel extends Account {

	/**
	 * Default constructor
	 */
	public Hotel() {
	}

	/**
	 * 
	 */
	private boolean hasKitchenette;

	/**
	 * Call parent's constructor
	 * Validate parameters 
	 * Assign parameters's values to attributes
	 * @param accountNumber 
	 * @param address 
	 * @param phoneNumber 
	 * @param email
	 */
	public void Hotel(String accountNumber, Address address, String phoneNumber, String email) {
		// TODO implement here
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
	public void Hotel(String accountNumber, Address address, String phoneNumber, String email, boolean hasKitchenette) {
		// TODO implement here
	}

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