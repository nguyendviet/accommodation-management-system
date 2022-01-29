
import java.util.*;

/**
 * 
 */
public class House extends Account {

	/**
	 * Default constructor
	 */
	public House() {
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
	 * @param address 
	 * @param phoneNumber 
	 * @param email 
	 * @param floorCount
	 */
	public void House(String accountNumber, Address address, String phoneNumber, String email, int floorCount) {
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
	 * @param floorCount
	 */
	public void setFloorCount(int floorCount) {
		// TODO implement here
	}

}