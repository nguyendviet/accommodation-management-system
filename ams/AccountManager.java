package ams;

import java.io.File;
import java.io.FileWriter;

public class AccountManager {

	/**
	 * Store and manage a single Account object at a time
	 */
	private Account account;

	public AccountManager() {
	}

	/**
	 * Load new Account from the passed in object (close the currently loaded Account).
	 * No duplicate accounts. If duplicate found, throw DuplicateObjectException.
	 * @param account 
	 * @return
	 */
	public void createNewAccount(Account account) throws DuplicateObjectException {
		Helper.validateParameters(account.toString());
		String accountNumber = account.getAccountNumber();
		File accountPath = new File("./accounts/" + accountNumber);
		boolean exists = accountPath.exists();
		if (exists) {
			throw new DuplicateObjectException(account);
		}
		// Create the new account folder
		accountPath.mkdirs();
		// Save the new account attributes
		this.account = account;
		// Save the account attributes to file
		saveToFile(accountPath.toString());
	}

	/**
	 * Look for file name with specific path. Return file output if found. 
	 * If file not found, throw IllegalLoadException.
	 * @param accountNumber
	 */
	public Account openFromFile(String accountNumber) throws IllegalLoadException {
		File accountFile = new File("./accounts/" + accountNumber + "/acc" + accountNumber + ".xml");
		boolean exists = accountFile.exists();
		if (!exists) {
			throw new IllegalLoadException(accountNumber);
		}
		Account loadedAccount = new Account(accountNumber);
		this.account = loadedAccount;
		return loadedAccount;
	}

	/**
	 * Save account information in file.
	 * @param filePath 
	 * @return
	 */
	public void saveToFile(String filePath) {
		try (
			FileWriter fw = new FileWriter(filePath + "/acc" + account.getAccountNumber() + ".xml")) {
			fw.write(Helper.beautifyXml(account.toString(), 2));
		} catch (Exception e) {
			e.printStackTrace();  
		}
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