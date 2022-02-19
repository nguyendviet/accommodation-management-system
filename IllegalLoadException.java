import java.util.*;

/**
 * When loading account and/or reservations from file if the file does not exist throw unchecked user defined exception called IllegalLoadException when violation detected
 */
public class IllegalLoadException extends RuntimeException {

	/**
	 * Default constructor
	 */
	public IllegalLoadException() {
	}

	/**
	 * 
	 */
	private String fileName;

	/**
	 * 
	 */
	private String accountNumber;

	/**
	 * 
	 */
	private String reservationNumber;

	/**
	 * return "Error loading account: " + accountNumber + " from file: " + fileName;
	 * return "Error loading reservation: " + reservationNumber + " from file: " + fileName;
	 * @return
	 */
	public String toString() {
		// TODO implement here
		return "";
	}

	/**
	 * @param fileName
	 */
	public void IllegalLoadException(String fileName) {
		// TODO implement here
	}

}