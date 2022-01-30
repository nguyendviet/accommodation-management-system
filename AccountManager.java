
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
	 * No duplicate accounts. If duplicate found, throw DuplicateObjectException.
	 * @param account 
	 * @return
	 */
	public void createNewAccount(Account account) throws DuplicateObjectException {
		// TODO implement here
	}

	/**
	 * Look for file name with specific path. Return file output if found. 
	 * If file not found, throw IllegalLoadException.
	 * @param fileName
	 */
	public void openFromFile(String fileName) throws IllegalLoadException {
		// TODO implement here
	}

	/**
	 * Save account information in file.
	 * If found duplicate, throw DuplicateObjectException.
	 * @param fileName 
	 * @return
	 */
	public void saveToFile(String fileName) throws DuplicateObjectException {
		// TODO implement here
	}

	/**
	 * Add reservation to a new file. 
	 * If duplicate found, throw DuplicateObjectException.
	 * @param reservation
	 * @return
	 */
	public void addReservation(Reservation reservation) throws DuplicateObjectException {
		// TODO implement here
	}

	/**
	 * Validate parameters
	 * Find existing reservation based on the input reservation number
	 * Update the details if found. If file not found, throw IllegalLoadException.
	 * @param reservation
	 * @return
	 */
	public void editReservation(Reservation reservation) throws IllegalLoadException {
		// TODO implement here
	}

	/**
	 * Cancel reservation matching reservation number from currently loaded Account.  
	 * Can only cancel reservation if the start date is in the future
	 * Delete reservation entry if found. 
	 * If file not found, throw IllegalLoadException.
	 * @param reservationNumber
	 * @return
	 */
	public void deleteReservation(String reservationNumber) throws IllegalLoadException {
		// TODO implement here
	}

	/**
	 * Look for account. Return account output if found. 
	 * If account not found, throw IllegalLoadException.
	 * @return
	 */
	public Account getAccount() throws IllegalLoadException {
		// TODO implement here
		return null;
	}

}