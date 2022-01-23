
import java.util.*;

/**
 * 
 */
public class Account {

	/**
	 * Validate parameters
	 * Check for existing account number to avoid duplicate
	 * @param accountNumber 
	 * @param address 
	 * @param phoneNumber 
	 * @param email
	 */
	public Account(String accountNumber, Address address, String phoneNumber, String email) {
		// TODO implement here
	}

	/**
	 * 
	 */
	private String accountNumber;

	/**
	 * 
	 */
	private Address address;

	/**
	 * 
	 */
	private String phoneNumber;

	/**
	 * 
	 */
	private String email = null;

	/**
	 * 
	 */
	private List<Reservation> reservations;

	/**
	 * @return
	 */
	public String toString() {
		// TODO implement here
		return "";
	}

	/**
	 * @return
	 */
	public Address getAddress() {
		// TODO implement here
		return null;
	}

	/**
	 * @param address 
	 * @return
	 */
	public void setAddress(Address address) {
		// TODO implement here
	}

	/**
	 * @return
	 */
	public String getPhoneNumber() {
		// TODO implement here
		return "";
	}

	/**
	 * @param phoneNumber 
	 * @return
	 */
	public void setPhoneNumber(String phoneNumber) {
		// TODO implement here
	}

	/**
	 * @return
	 */
	public String getEmail() {
		// TODO implement here
		return "";
	}

	/**
	 * @param email 
	 * @return
	 */
	public void setEmail(String email) {
		// TODO implement here
	}

	/**
	 * @return
	 */
	public String getAccountNumber() {
		// TODO implement here
		return "";
	}

	/**
	 * @param fileName 
	 * @return
	 */
	public void saveToFile(String fileName) {
		// TODO implement here
	}

	/**
	 * Add reservation object to the Vector of Reservation objects (check for duplicates)
	 * and return the reservation number
	 * @param reservation Add reservation to the currently loaded Account
	 * @return
	 */
	public String addReservation(Reservation reservation) {
		// TODO implement here
		return "";
	}

	/**
	 * Cancel reservation matching reservation number from currently loaded Account.  
	 * Can only cancel reservation if the start date is in the future
	 * @param reservation Add reservation to the currently loaded Account
	 * @return
	 */
	public void editReservation(Reservation reservation) {
		// TODO implement here
	}

	/**
	 * @return
	 */
	public List<Reservation> getReservations() {
		// TODO implement here
		return null;
	}

}