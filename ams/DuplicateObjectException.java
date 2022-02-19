package ams;

/**
 * If duplicate account/reservation exists throw unchecked user defined exception
 */
public class DuplicateObjectException extends RuntimeException {

	private String accountNumber;
	private String reservationNumber;

	/**
	 * @param account
	 */
	public DuplicateObjectException(Account account) {
		Helpers.validateParameters(account.toString());
		this.accountNumber = account.getAccountNumber();
	}

	/**
	 * Overload constructor if parameter type is different.
	 * @param reservation Overloading
	 */
	public DuplicateObjectException(Reservation reservation) {
		Helpers.validateParameters(reservation.toString());
		this.reservationNumber = reservation.getReservationNumber();
	}

	/**
	 * @return Error message string
	 */
	public String toString() {
		if (accountNumber != null) {
			return "Error adding account: " + accountNumber + ". Account number has already existed.";
		}
		if (reservationNumber != null) {
			return "Error adding reservation: " + reservationNumber + ". Reservation number has already existed.";
		}
		return "";
	}

}