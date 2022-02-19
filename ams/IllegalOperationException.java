package ams;
import java.util.*;

/**
 * On cancelling or completing reservation if it cannot be finalized, throw unchecked user defined exception
 */
public class IllegalOperationException extends RuntimeException {

	/**
	 * Default constructor
	 */
	public IllegalOperationException() {
	}

	/**
	 * 
	 */
	private String accountNumber;

	/**
	 * 
	 */
	private String reservationNumber;

	/**
	 * Reasons for completing reservation errors (e.g. lodge doesn't have available rooms at the time of booking).
	 */
	private String message;

	/**
	 * return "Error cancelling reservation: " + reservationNumber + " for account: " + accountNumber + " . Reservation can only be cancelled if the start date is in the future.";
	 * return "Error completing reservation: " + reservationNumber + " for account: " + accountNumber + " . Reason: " + message;
	 * @return
	 */
	public String toString() {
		// TODO implement here
		return "";
	}

	/**
	 * @param accountNumber 
	 * @param reservationNumber
	 */
	public void IllegalOperationException(String accountNumber, String reservationNumber) {
		// TODO implement here
	}

}