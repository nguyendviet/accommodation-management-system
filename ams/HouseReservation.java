package ams;
import java.util.*;

/**
 * 
 */
public class HouseReservation extends Reservation {

	private int floorCount;

	/**
	 * @param accountNumber 
	 * @param reservationNumber 
	 * @param address 
	 * @param checkIn 
	 * @param checkOut 
	 * @param price 
	 * @param floorCount
	 */
	public HouseReservation(String accountNumber, String reservationNumber, String address, Date checkIn, Date checkOut, double price, int floorCount) {
		// Call parent's constructor
		super(accountNumber, reservationNumber, checkIn, checkOut);
		// Validate parameters 
		Helpers.validateParameters(accountNumber, reservationNumber, address, checkIn.toString(), checkOut.toString());
		// Assign parameters's values to attributes
		this.floorCount = floorCount;
	}

	/**
	 * Overloading constructor if load from file
	 * @param fileName
	 */
	public HouseReservation(String fileName) throws IllegalLoadException {
		// Call parent's constructor
		super(fileName);
	}

	
	/**
	 * Overriding parent's method
	 * @returns String in XML format
	 */
	public String toString() {
		return 
			"<house>" + 
				super.toString() + 
				"<floorCount>" + floorCount + "</floorCount>" +
			"</house>";
	}

	/**
	 * @return
	 */
	public double calculatePrice() {
		// TODO implement here
		return 0.0d;
	}

}