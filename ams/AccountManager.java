package ams;

import java.io.File;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

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
	public void openFromFile(String accountNumber) throws IllegalLoadException {
		Helper.validateParameters(accountNumber);

		File accountFile = Helper.getFilePath(accountNumber, accountNumber, "acc");
		boolean exists = accountFile.exists();
		if (!exists) {
			throw new IllegalLoadException("acc" + accountNumber);
		}

		Account loadedAccount = new Account(accountNumber);
		this.account = loadedAccount;
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
	 * @param hotelReservation
	 * @return
	 */
	public void addReservation(HotelReservation hotelReservation) throws DuplicateObjectException {
		Helper.validateParameters(hotelReservation.toString());

		String accountNumber = hotelReservation.getAccountNumber();
		String reservationNumber = hotelReservation.getReservationNumber();
		File reservationFile = Helper.getFilePath(accountNumber, reservationNumber, "res");
		boolean exists = reservationFile.exists();
		if (exists) {
			throw new DuplicateObjectException(hotelReservation);
		}
		// Add hotelReservation to account
		this.account.addReservation(hotelReservation);
		// Update account file
		this.account.saveToFile();
		// Save reservation file
		this.account.saveToFile(hotelReservation);
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
	public void cancelReservation(String reservationNumber) throws IllegalLoadException {
		Helper.validateParameters(reservationNumber);
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate today = LocalDate.now();
		ArrayList<String> reservations = this.account.getReservations();
		String accountNumber = this.account.getAccountNumber();

		if (reservations.contains(reservationNumber)) {
			String reservationType = Helper.getReservationType(reservationNumber);
			String checkin = "";
			
			switch (reservationType) {
				case "CABIN":
					CabinReservation cabin = new CabinReservation(accountNumber, reservationNumber);
					checkin = cabin.getCheckIn();
				case "HOTEL":
					HotelReservation hotel = new HotelReservation(accountNumber, reservationNumber);
					checkin = hotel.getCheckIn();
				default:
					HouseReservation house = new HouseReservation(accountNumber, reservationNumber);
					checkin = house.getCheckIn();
			}

			LocalDate checkinDate = LocalDate.parse(checkin, formatter);
			if (checkinDate.isBefore(today)) {
				throw new IllegalOperationException(accountNumber, reservationNumber, "Checkin date has passed.");
			} else {
				this.deleteReservation(reservationNumber);
			}
		} else {
			throw new IllegalLoadException("res" + reservationNumber);
		}
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
			throw new IllegalLoadException("res" + fileName);
		}
		account.deleteReservation(fileName);
	}

	public String toString() {
		return account.toString();
	}

	public String getAccountNumber() {
		return account.getAccountNumber();
	}

	public ArrayList<String> getReservations() {
		return account.getReservations();
	}

}