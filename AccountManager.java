
import java.util.*;

/**
 * 
 */
public class AccountManager {

	/**
	 * Default constructor
	 */
	public AccountManager() {
	}

	/**
	 * Store and manage a single Account object at a time
	 */
	private Account account;

	/**
	 * Load new Account from the passed in object (close the currently loaded Account).
	 * No duplicate accounts.
	 * @param account 
	 * @return
	 */
	public void createNewAccount(Account account) {
		// TODO implement here
	}

	/**
	 * Look for file name with specific path. Return file output or not found.
	 * @param fileName
	 */
	public void openFromFile(String fileName) {
		// TODO implement here
	}

	/**
	 * Save account information in file
	 * @param fileName 
	 * @return Save current Account data to a file
	 */
	public void saveToFile(String fileName) {
		// TODO implement here
	}

	/**
	 * @param reservation Add reservation to the currently loaded Account
	 * @return
	 */
	public void addReservation(Reservation reservation) {
		// TODO implement here
	}

	/**
	 * Validate parameters
	 * Find existing reservation based on the input reservation number
	 * Update the details if found
	 * @param reservation Add reservation to the currently loaded Account
	 * @return
	 */
	public void editReservation(Reservation reservation) {
		// TODO implement here
	}

	/**
	 * Cancel reservation matching reservation number from currently loaded Account.  
	 * Can only cancel reservation if the start date is in the future
	 * Delete reservation entry
	 * @param reservationNumber Add reservation to the currently loaded Account
	 * @return
	 */
	public void deleteReservation(String reservationNumber) {
		// TODO implement here
	}

	/**
	 * @return
	 */
	public Account getAccount() {
		// TODO implement here
		return null;
	}

}