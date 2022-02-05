
import java.util.*;

/**
 * 
 */
public class HouseReservation extends Reservation {

	/**
	 * Call parent's constructor
	 * Validate parameters 
	 * Assign parameters's values to attributes
	 * @param accountNumber 
	 * @param reservationNumber 
	 * @param address 
	 * @param checkIn 
	 * @param checkOut 
	 * @param price 
	 * @param floorCount
	 */
	public HouseReservation(String accountNumber, String reservationNumber, String address, Date checkIn, Date checkOut, double price, int floorCount) {
		super(accountNumber, reservationNumber, checkIn, checkOut);
	}

	/**
	 * Call parent's constructor
	 * Validate the path to the file. If file not found, throw IllegalLoadException.
	 * Load all the reservation attributes to the object’s attributes.
	 * Assign parameters's values to attributes
	 * @param fileName
	 */
	public HouseReservation(String fileName) throws IllegalLoadException {
		super(fileName);
	}

	/**
	 * 
	 */
	private int floorCount;

	/**
	 * Overriding parent's method
	 * return "<house>" + super.toString() + "<floorCount>" + floorCount + "<floorCount></house>";
	 * @return
	 */
	public String toString() {
		// TODO implement here
		return "";
	}

	/**
	 * @return
	 */
	public double calculatePrice() {
		// TODO implement here
		return 0.0d;
	}

	

	/**
	 * @return
	 */
	public House getHouseInfo() {
		// TODO implement here
		return null;
	}

}