
import java.util.*;

/**
 * Reservation number prefixes: HT = hotel, CB = cabin, SH = house
 */
public abstract class Reservation {

	/**
	 * Default constructor
	 */
	public Reservation() {
	}

	/**
	 * 
	 */
	protected String accountNumber;

	/**
	 * 
	 */
	protected String reservationNumber;

	/**
	 * Validate account
	 * Validate reservation number to avoid duplicate
	 * Get details of the account (address,  number of beds, etc.) from the account's details
	 */
	private Address address;

	/**
	 * 
	 */
	private String status = "draft";

	/**
	 * 
	 */
	private Date checkIn;

	/**
	 * 
	 */
	private Date checkOut;

	/**
	 * 
	 */
	private double price;

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
	public abstract double calculatePrice();

	/**
	 * @return
	 */
	public int calculateNights() {
		// TODO implement here
		return 0;
	}

	/**
	 * Update reservation data using passed in parameters
	 * @param checkIn 
	 * @param checkOut 
	 * @param address 
	 * @return
	 */
	public void updateReservation(Date checkIn, Date checkOut, Address address) {
		// TODO implement here
		return null;
	}

	/**
	 * Validate parameters
	 * Validate account
	 * Validate reservation number to avoid duplicate
	 * Get details of lodge (address, number of beds, etc.)
	 * Calculate the price based on check in and check out dates and the type of lodge.
	 * @param accountNumber 
	 * @param reservationNumber 
	 * @param checkIn 
	 * @param checkOut
	 */
	public void Reservation(String accountNumber, String reservationNumber, Date checkIn, Date checkOut) {
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
	 * @return
	 */
	public String getReservationNumber() {
		// TODO implement here
		return "";
	}

	/**
	 * @return
	 */
	public String getAddress() {
		// TODO implement here
		return "";
	}

	/**
	 * @return
	 */
	public String getStatus() {
		// TODO implement here
		return "";
	}

	/**
	 * @return
	 */
	public Date getCheckIn() {
		// TODO implement here
		return null;
	}

	/**
	 * @return
	 */
	public Date getCheckOut() {
		// TODO implement here
		return null;
	}

	/**
	 * @return
	 */
	public double getPrice() {
		// TODO implement here
		return 0.0d;
	}

	/**
	 * @param status
	 */
	public void setStatus(String status) {
		// TODO implement here
	}

	/**
	 * @param checkInDate
	 */
	public void setCheckIn(Date checkInDate) {
		// TODO implement here
	}

	/**
	 * @param checkOutDate
	 */
	public void setCheckOut(Date checkOutDate) {
		// TODO implement here
	}

}