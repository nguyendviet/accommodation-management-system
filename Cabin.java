
import java.util.*;

/**
 * 
 */
public class Cabin extends Account {

	/**
	 * Default constructor
	 */
	public Cabin() {
	}

	/**
	 * 
	 */
	private boolean hasFullKitchen;

	/**
	 * 
	 */
	private boolean hasLoft;

	/**
	 * Call parent's constructor
	 * Validate parameters 
	 * Assign parameters's values to attributes
	 * @param accountNumber 
	 * @param address 
	 * @param phoneNumber 
	 * @param email
	 */
	public void Cabin(String accountNumber, Address address, String phoneNumber, String email) {
		// TODO implement here
	}

	/**
	 * Overloading constructor if has full kitchen and or loft
	 * Call parent's constructor
	 * Validate parameters 
	 * Assign parameters's values to attributes
	 * @param accountNumber 
	 * @param address 
	 * @param phoneNumber 
	 * @param email 
	 * @param hasFullKitchen 
	 * @param hasLoft
	 */
	public void Cabin(String accountNumber, Address address, String phoneNumber, String email, boolean hasFullKitchen, boolean hasLoft) {
		// TODO implement here
	}

	/**
	 * Overriding parent's method
	 * return "<cabin>" + super.toString() + "<hasFullKitchen>" + hasFullKitchen + ... "</cabin>";
	 * @return
	 */
	public String toString() {
		// TODO implement here
		return "";
	}

	/**
	 * @param hasFullKitchen
	 */
	public void setHasFullKitchen(boolean hasFullKitchen) {
		// TODO implement here
	}

	/**
	 * @param hasLoft
	 */
	public void setHasLoft(boolean hasLoft) {
		// TODO implement here
	}

}