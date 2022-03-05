package ams;
import java.util.*;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public abstract class Reservation {

	protected String accountNumber;
	protected String reservationNumber;
	private String reservationType;
	private String address;
	private String checkIn;
	private String checkOut;
	private String beds;
	private String bedrooms;
	private String bathrooms;
	private String size;
	private String price;
	private String email = null;
	private String status = "draft";
	private String nights;
	private boolean hasFullKitchen;
	private boolean hasLoft;
	private boolean hasKitchenette;
	private int floorCount;

	/**
	 * @param accountNumber 
	 * @param reservationNumber 
	 * @param checkIn 
	 * @param checkOut
	 */
	public Reservation(String accountNumber, String reservationNumber, String reservationType, String address, String checkIn, String checkOut, String beds, String bedrooms, String bathrooms, String sizee, String email) {
		// Validate parameters
		Helper.validateParameters(accountNumber, reservationNumber, reservationType, address, checkIn, checkOut, beds, bedrooms, bathrooms, size);

		// Assign parameters to object
		this.accountNumber = accountNumber;
		this.reservationNumber = reservationNumber;
		this.reservationType = reservationType;
		this.address = address;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.beds = beds;
		this.bedrooms = bedrooms;
		this.bathrooms = bathrooms;
		this.size = size;
		// If lodge has email assign it, otherwise null
		this.email = email;
		this.nights = calculateNights();
		this.price = calculatePrice();
	}

	/**
	 * Overloading constructor for Cabin reservation
	 * @param args
	 * @param hasFullKitchen
	 * @param hasLoft
	 */
	public Reservation(String accountNumber, String reservationNumber, String reservationType, String address, String checkIn, String checkOut, String beds, String bedrooms, String bathrooms, String size, String email, boolean hasFullKitchen, boolean hasLoft) {
		// Validate parameters
		Helper.validateParameters(accountNumber, reservationNumber, reservationType, address, checkIn, checkOut, beds, bedrooms, bathrooms, size);

		// Assign parameters to object
		this.accountNumber = accountNumber;
		this.reservationNumber = reservationNumber;
		this.reservationType = reservationType;
		this.address = address;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.beds = beds;
		this.bedrooms = bedrooms;
		this.bathrooms = bathrooms;
		this.size = size;
		// If lodge has email assign it, otherwise null
		this.email = email;
		this.nights = calculateNights();
		this.price = calculatePrice();
		this.hasFullKitchen = hasFullKitchen;
		this.hasLoft = hasLoft;
	}

	/**
	 * Overloading constructor for Hotel reservation
	 * @param args
	 * @param hasKitchenette
	 */
	public Reservation(String accountNumber, String reservationNumber, String reservationType, String address, String checkIn, String checkOut, String size, String email, boolean hasKitchenette) {
		// Validate parameters
		Helper.validateParameters(accountNumber, reservationNumber, reservationType, address, checkIn, checkOut, size);

		// Assign parameters to object
		this.accountNumber = accountNumber;
		this.reservationNumber = reservationNumber;
		this.reservationType = reservationType;
		this.address = address;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.beds = "2";
		this.bedrooms = "1";
		this.bathrooms = "1";
		this.size = size;
		// If lodge has email assign it, otherwise null
		this.email = email;
		this.nights = calculateNights();
		this.price = calculatePrice();
		this.hasKitchenette = hasKitchenette;
	}

	/**
	 * Overloading constructor for House reservation
	 * @param args
	 * @param floorCount
	 */
	public Reservation(String accountNumber, String reservationNumber, String reservationType, String address, String checkIn, String checkOut, String beds, String bedrooms, String bathrooms, String size, String email, int floorCount) {
		// Validate parameters
		Helper.validateParameters(accountNumber, reservationNumber, reservationType, address, checkIn, checkOut, beds, bedrooms, bathrooms, size);

		// Assign parameters to object
		this.accountNumber = accountNumber;
		this.reservationNumber = reservationNumber;
		this.reservationType = reservationType;
		this.address = address;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.beds = beds;
		this.bedrooms = bedrooms;
		this.bathrooms = bathrooms;
		this.size = size;
		// If lodge has email assign it, otherwise null
		this.email = email;
		this.nights = calculateNights();
		this.price = calculatePrice();
		this.floorCount = floorCount;
	}

	/**
	 * Overloading constructor if load from file
	 * @param fileName
	 */
	public Reservation(String accountNumber, String reservationNumber) throws IllegalLoadException {
		// Validate parameter is not null and throw IllegalArgumentException.
		Helper.validateParameters(accountNumber, reservationNumber);

		// Create a constructor of file class and parsing an XML file 
		try { 
			File reservationFile = new File("./accounts/" + accountNumber + "/res" + reservationNumber + ".xml");  
			// Create an instance of factory that gives a document builder  
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();  
			// Ceate an instance of builder to parse the specified xml reservationFile  
			DocumentBuilder db = dbf.newDocumentBuilder();  
			Document document = db.parse(reservationFile);
			
			// Assign values from file to object
			this.accountNumber = Helper.getValueFromTag("accountNumber", document);
			this.reservationNumber = Helper.getValueFromTag("reservationNumber", document);
			this.reservationType = Helper.getValueFromTag("reservationType", document);
			this.status = Helper.getValueFromTag("status", document);
			this.checkIn = Helper.getValueFromTag("checkIn", document);
			this.checkOut = Helper.getValueFromTag("checkOut", document);
			this.beds = Helper.getValueFromTag("beds", document);
			this.bathrooms = Helper.getValueFromTag("bathrooms", document);
			this.size = Helper.getValueFromTag("size", document);
			this.price = Helper.getValueFromTag("price", document);

			String street = Helper.getValueFromTag("street", document);
			String city = Helper.getValueFromTag("city", document);
			String state = Helper.getValueFromTag("state", document);
			String zipcode = Helper.getValueFromTag("zipcode", document);
			Address address = new Address(street, city, state, zipcode);
			this.address = address.toString();

			switch (this.reservationType) {
				case "cabin":
					this.hasFullKitchen = Boolean.parseBoolean(Helper.getValueFromTag("hasFullKitchen", document));
					this.hasLoft = Boolean.parseBoolean(Helper.getValueFromTag("hasLoft", document));
				case "hotel":
					this.hasKitchenette = Boolean.parseBoolean(Helper.getValueFromTag("hasKitchenette", document));
				case "house":
					this.floorCount = Integer.parseInt(Helper.getValueFromTag("hasKitchenette", document));
				default:
					break;
			}
		} catch (Exception e) {  
			e.printStackTrace();
		}  
	}

	/**
	 * @return
	 */
	public String toString() {
		String defaultReservation = 
			"<reservationNumber>" + reservationNumber + "</reservationNumber>" +
			"<accountNumber>" + accountNumber + "</accountNumber>" +
			"<reservationType>" + reservationType + "</reservationType>" +
			address +
			"<email>" + email + "</email>" +
			"<status>" + status + "</status>" +
			"<checkIn>" + checkIn + "</checkIn>" +
			"<checkOut>" + checkOut + "</checkOut>" +
			"<beds>" + beds + "</beds>" +
			"<bathrooms>" + bathrooms + "</bathrooms>" +
			"<size>" + size + "</size>" +
			"<price>" + price + "</price>" + 
			"<nights>" + nights + "</nights>";
		
		switch(reservationType) {
			case "cabin":
				return
					"<reservation>" +
						defaultReservation +
						"<hasFullKitchen>" + hasFullKitchen + "</hasFullKitchen>" +
						"<hasLoft>" + hasLoft + "</hasLoft>" +
					"</reservation>"; 
			case "hotel":
				return
					"<reservation>" +
						defaultReservation +
						"<hasKitchenette>" + hasKitchenette + "</hasKitchenette>" +
					"</reservation>";
			case "house":
				return
				"<reservation>" +
					defaultReservation +
					"<floorCount>" + floorCount + "</floorCount>" +
				"</reservation>";
			default:
				return
					"<reservation>" +
						defaultReservation +
					"</reservation>";
		}
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
	public String calculateNights() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String checkInStr = checkIn.formatted(formatter);
		String checkOutStr = checkOut.formatted(formatter);
		LocalDate parsedCheckIn = LocalDate.parse(checkInStr, formatter);
		LocalDate parsedCheckOut = LocalDate.parse(checkOutStr, formatter);
		Long diff = ChronoUnit.DAYS.between(parsedCheckIn,parsedCheckOut);
		String nightCount = Long.toString(diff);
		return nightCount;
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
		this.setCheckIn(checkIn.toString());
		this.setCheckOut(checkOut.toString());
		this.address = address.toString();
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public String getReservationNumber() {
		return reservationNumber;
	}

	public String getReservationType() {
		return reservationType;
	}

	public String getAddress() {
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

	public String getSize() {
		return size;
	}

	public boolean getFullKitchen() {
		return hasFullKitchen;
	}

	public boolean getKitchenette() {
		return hasKitchenette;
	}

	public String getBathrooms() {
		return bathrooms;
	}

	/**
	 * If for some reasons, cannot complete the reservation 
	 * (e.g. lodge doesn't have available rooms at the time of booking), 
	 * throw IllegalOperationException.
	 * @param status
	 */
	public void setStatus(String status) throws IllegalOperationException {
		Helper.validateParameters(status);
		this.status = status;
	}

	/**
	 * Update/replace the class's checkIn attribute with the parameter. This 
	 * action is only allowed when the reservation’s status is “draft”. 
	 * Otherwise, throw IllegalOperationException.
	 * @param checkInDate
	 */
	public void setCheckIn(String checkInDate) throws IllegalOperationException {
		Helper.validateParameters(checkInDate);
		this.checkIn = checkInDate;
	}

	/**
	 * Update/replace the class's checkOut attribute with the parameter. This 
	 * action is only allowed when the reservation’s status is “draft”. 
	 * Otherwise, throw IllegalOperationException.
	 * @param checkOutDate
	 */
	public void setCheckOut(String checkOutDate) throws IllegalOperationException {
		Helper.validateParameters(checkOutDate);
		this.checkOut = checkOutDate;
	}

}