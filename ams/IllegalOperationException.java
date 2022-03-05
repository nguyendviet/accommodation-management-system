package ams;

/**
 * On cancelling or completing reservation if it cannot be finalized, throw 
 * unchecked user defined exception
 */
public class IllegalOperationException extends RuntimeException {

	private String accountNumber;
	private String reservationNumber;
	/**
	 * Reasons for completing reservation errors (e.g. lodge doesn't have available rooms at the time of booking).
	 */
	private String message;

	/**
	 * @param accountNumber 
	 * @param reservationNumber
	 */
	public IllegalOperationException(String accountNumber, String reservationNumber, String message) {
		Helper.validateParameters(accountNumber, reservationNumber, message);
		this.accountNumber = accountNumber;
		this.reservationNumber = reservationNumber;
		this.message = message;
	}

	/**
	 * @return Error message string
	 */
	public String toString() {
		return "Error modifying reservation: " + reservationNumber + " for account: " + accountNumber + ". Reason: " + message;
	}

}