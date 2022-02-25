package ams;
import java.util.*;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import java.io.File;

public abstract class Reservation {

	protected String accountNumber;
	protected String reservationNumber;
	private Address address;
	private String status = "draft";
	private String checkIn;
	private String checkOut;
	private String price;

	/**
	 * @param accountNumber 
	 * @param reservationNumber 
	 * @param checkIn 
	 * @param checkOut
	 */
	public Reservation(String accountNumber, String reservationNumber, Address address, String checkIn, String checkOut) {
		// Validate parameters
		Helper.validateParameters(accountNumber, reservationNumber, address.toString(), checkIn, checkOut);

		// Assign parameters to object
		this.accountNumber = accountNumber;
		this.reservationNumber = reservationNumber;
		this.address = address;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.price = calculatePrice();
	}

	/**
	 * Overloading constructor if load from file
	 * @param fileName
	 */
	public Reservation(String fileName) throws IllegalLoadException {
		// Validate parameter is not null and throw IllegalArgumentException.
		Helper.validateParameters(fileName);

		// Create a constructor of file class and parsing an XML file 
		try { 
			File reservationFile = new File("./accounts/" + fileName);  
			// Create an instance of factory that gives a document builder  
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();  
			// Ceate an instance of builder to parse the specified xml reservationFile  
			DocumentBuilder db = dbf.newDocumentBuilder();  
			Document document = db.parse(reservationFile);
			String street = Helper.getValueFromTag("street", document);
			String city = Helper.getValueFromTag("city", document);
			String state = Helper.getValueFromTag("state", document);
			String zipcode = Helper.getValueFromTag("zipcode", document);
			
			// Assign values from file to object
			this.accountNumber = Helper.getValueFromTag("accountNumber", document);
			this.address = new Address(street, city, state, zipcode);
			this.status = Helper.getValueFromTag("status", document);
			this.checkIn = Helper.getValueFromTag("checkIn", document);
			this.checkOut = Helper.getValueFromTag("checkOut", document);
			this.price = Helper.getValueFromTag("price", document);
			
		} catch (Exception e) {  
			e.printStackTrace();
		}  
	}

	/**
	 * @return
	 */
	public String toString() {
		return
			"<reservation>" + 
				"<reservationNumber>" + reservationNumber + "</reservationNumber>" +
				"<accountNumber>" + accountNumber + "</accountNumber>" +
				address.toString() +
				"<status>" + status + "</status>" +
				"<checkIn>" + checkIn + "</checkIn>" +
				"<checkOut>" + checkOut + "</checkOut>" +
				"<price>" + price + "</price>" +
			"</reservation>";
	}

	/**
	 * Required method for the subclass to implement.
	 * @return
	 */
	public abstract String calculatePrice();

	/**
	 * Calculate the nights based on the class’s attributes checkIn and checkOut.
	 * @return
	 */
	public int calculateNights() {
		// TODO implement here
		return 0;
	}

	/**
	 * Update reservation data using passed in parameters.
	 * Update the details if found. If file not found, throw IllegalLoadException.
	 * @param checkIn 
	 * @param checkOut 
	 * @param address 
	 * @return
	 */
	public void updateReservation(Date checkIn, Date checkOut, Address address) throws IllegalLoadException {
		// Validate parameters
		Helper.validateParameters(checkIn.toString(), checkOut.toString());
		// TODO implement here
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public String getReservationNumber() {
		return reservationNumber;
	}

	public Address getAddress() {
		return address;
	}

	public String getStatus() {
		return status;
	}

	public String getCheckIn() {
		return checkIn;
	}

	public String getCheckOut() {
		return checkOut;
	}

	public String getPrice() {
		return price;
	}

	/**
	 * If for some reasons, cannot complete the reservation 
	 * (e.g. lodge doesn't have available rooms at the time of booking), 
	 * throw IllegalOperationException.
	 * @param status
	 */
	public void setStatus(String status) throws IllegalOperationException {
		// TODO implement here
	}

	/**
	 * Update/replace the class's checkIn attribute with the parameter. This 
	 * action is only allowed when the reservation’s status is “draft”. 
	 * Otherwise, throw IllegalOperationException.
	 * @param checkInDate
	 */
	public void setCheckIn(String checkInDate) throws IllegalOperationException {
		// TODO implement here
	}

	/**
	 * Update/replace the class's checkOut attribute with the parameter. This 
	 * action is only allowed when the reservation’s status is “draft”. 
	 * Otherwise, throw IllegalOperationException.
	 * @param checkOutDate
	 */
	public void setCheckOut(String checkOutDate) throws IllegalOperationException {
		// TODO implement here
	}

}