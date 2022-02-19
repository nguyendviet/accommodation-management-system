package ams;

/**
 * On cancelling or completing reservation if it cannot be finalized, throw 
 * unchecked user defined exception
 */
public class IllegalOperationException extends RuntimeException {

	private String accountNumber;
	private String reservationNumber;

	/**
	 * @param accountNumber 
	 * @param reservationNumber
	 */
	public IllegalOperationException(String accountNumber, String reservationNumber) {
		Helpers.validateParameters(accountNumber, reservationNumber);
		this.accountNumber = accountNumber;
		this.reservationNumber = reservationNumber;
	}

	/**
	 * Reasons for completing reservation errors (e.g. lodge doesn't have available rooms at the time of booking).
	 */
	private String message;

	/**
	 * @return Error message string
	 */
	public String toString() {
		return "Error modifying reservation: " + reservationNumber + " for account: " + accountNumber + ". Reason: " + message;
	}

}