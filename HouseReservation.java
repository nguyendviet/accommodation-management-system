
import java.util.*;

/**
 * 
 */
public class HouseReservation extends Reservation {

	/**
	 * Default constructor
	 */
	public HouseReservation() {
	}

	/**
	 * 
	 */
	private int floorCount;

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
	public void HouseReservation(String accountNumber, String reservationNumber, String address, Date checkIn, Date checkOut, double price, int floorCount) {
		// TODO implement here
	}

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

	/**
	 * @return
	 */
	public abstract double calculatePrice();

}