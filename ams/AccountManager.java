package ams;

import java.io.File;
import java.io.FileWriter;

import javax.naming.ldap.ExtendedRequest;

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
		File accountFolder = new File("./accounts/" + account.getAccountNumber());
		boolean exists = accountFolder.exists();
		if (exists) {
			throw new DuplicateObjectException(account);
		}
		this.account = account;
		this.account.saveToFile();
	}

	/**
	 * Look for file name with specific path. Return file output if found. 
	 * If file not found, throw IllegalLoadException.
	 * @param accountNumber
	 */
	public Account openFromFile(String accountNumber) throws IllegalLoadException {
		Helper.validateParameters(accountNumber);

		File accountFile = Helper.getFilePath(accountNumber, accountNumber, "acc");
		boolean exists = accountFile.exists();
		if (!exists) {
			throw new IllegalLoadException(accountNumber);
		}

		Account loadedAccount = new Account(accountNumber);
		this.account = loadedAccount;
		
		return loadedAccount;
	}

	/**
	 * Save information in file.
	 * @param filePath 
	 * @param content 
	 * @return
	 */
	public void saveToFile(String filePath, String content) {
		Helper.validateParameters(filePath, content);
		
		try (
			FileWriter fw = new FileWriter(filePath)) {
			fw.write(Helper.beautifyXml(content, 2));
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
		Helper.validateParameters(reservation.toString());

		String accountNumber = reservation.getAccountNumber();
		String reservationNumber = reservation.getReservationNumber();
		File reservationFile = Helper.getFilePath(accountNumber, reservationNumber, "res");
		boolean exists = reservationFile.exists();
		if (exists) {
			throw new DuplicateObjectException(reservation);
		}
		// Add reservation to account
		this.account.addReservation(reservation);
		// Update account file
		this.account.saveToFile();
	}

	public void addReservation(CabinReservation cabinReservation) throws DuplicateObjectException {
		Helper.validateParameters(cabinReservation.toString());

		String accountNumber = cabinReservation.getAccountNumber();
		String reservationNumber = cabinReservation.getReservationNumber();
		File reservationFile = Helper.getFilePath(accountNumber, reservationNumber, "res");
		boolean exists = reservationFile.exists();
		if (exists) {
			throw new DuplicateObjectException(cabinReservation);
		}
		// Add cabinReservation to account
		this.account.addReservation(cabinReservation);
		// Update account file
		this.account.saveToFile();
		this.account.saveToFile(cabinReservation);
	}

	/**
	 * Add reservation to a new file. 
	 * If duplicate found, throw DuplicateObjectException.
	 * @param houseReservation
	 * @return
	 */
	public void addReservation(HouseReservation houseReservation) throws DuplicateObjectException {
		Helper.validateParameters(houseReservation.toString());

		String accountNumber = houseReservation.getAccountNumber();
		String reservationNumber = houseReservation.getReservationNumber();
		File reservationFile = Helper.getFilePath(accountNumber, reservationNumber, "res");
		boolean exists = reservationFile.exists();
		if (exists) {
			throw new DuplicateObjectException(houseReservation);
		}
		// Add houseReservation to account
		this.account.addReservation(houseReservation);
		// Update account file
		this.account.saveToFile();
		// Save reservation file
		this.account.saveToFile(houseReservation);
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
	public void deleteReservation(String fileName) throws IllegalLoadException {
		File file = new File("./accounts/" + account.getAccountNumber() + "/res" + fileName + ".xml");
		boolean exists = file.exists();
		if (!exists) {
			throw new IllegalLoadException(fileName);
		}
		account.deleteReservation(fileName);
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