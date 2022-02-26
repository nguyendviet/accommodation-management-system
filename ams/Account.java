package ams;
import java.util.*;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.File;
import java.io.FileWriter;

public class Account {
	
	private String accountNumber;
	private Address address;
	private String phoneNumber;
	private String email = null;
	private ArrayList<String> reservations;

	/**
	 * Construct to create Account object and assign values for a new Account 
	 * object
	 * @param accountNumber 
	 * @param address 
	 * @param phoneNumber 
	 * @param email
	 */
	public Account(String accountNumber, Address address, String phoneNumber, 
	String email) throws IllegalArgumentException {
		// Validate parameters and throws IllegalArgumentException except for 
		// email address
		Helper.validateParameters(accountNumber, address.toString(), phoneNumber);

		this.accountNumber = accountNumber;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.email = email;
		reservations = new ArrayList<String>();
	}

	/**
	 * Overloading constructor if parameter is a file name
	 * Validate parameters and throws IllegalArgumentException
	 * Read content from file
	 * @param accountNumber 
	 */
	public Account(String accountNumber) throws IllegalArgumentException {
		// Validate parameters and throws IllegalArgumentException
		Helper.validateParameters(accountNumber);

		// Create a constructor of file class and parsing an XML file 
		try { 
			File accountFile = new File("./accounts/" + accountNumber +"/acc" + accountNumber + ".xml");
			boolean exists = accountFile.exists();
			if (!exists) {
				throw new IllegalLoadException(accountNumber);
			}
			// Create an instance of factory that gives a document builder  
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();  
			// Ceate an instance of builder to parse the specified xml accountFile  
			DocumentBuilder db = dbf.newDocumentBuilder();  
			Document document = db.parse(accountFile);
			String street = Helper.getValueFromTag("street", document);
			String city = Helper.getValueFromTag("city", document);
			String state = Helper.getValueFromTag("state", document);
			String zipcode = Helper.getValueFromTag("zipcode", document);
			// Assign values from file to object
			this.accountNumber = Helper.getValueFromTag("accountNumber", document);
			this.address = new Address(street, city, state, zipcode);
			this.phoneNumber = Helper.getValueFromTag("phoneNumber", document);
			this.email = Helper.getValueFromTag("email", document);
			this.reservations = new ArrayList<String>();
			
			NodeList reservationList = document.getElementsByTagName("reservations");

			for (int i = 0; i < reservationList.getLength(); i++) {
				Node reservationNode = reservationList.item(i);
				if (reservationNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) reservationNode;
					String reservationNumber = eElement.getAttribute("reservationNumber");
					System.out.println(reservationNumber);
					this.reservations.add(reservationNumber);
				}
			}
		} catch (Exception e) {  
			e.printStackTrace();
		}  
	}

	/**
	 * @return String in XML format
	 */
	public String toString() {
		StringBuilder reservationNumbers = new StringBuilder();
		// System.out.println("this reservations" + reservations.toString() + reservations.size());
		if (!reservations.isEmpty()) {
			for (int i = 0; i < reservations.size(); i++) {
				String reservationNumber = reservations.get(i);
				if (reservationNumber != "") {
					reservationNumbers.append("<reservation>" + reservationNumber + "</reservation>");
				}
			}
		}
		return
			"<account>" + 
				"<accountNumber>" + accountNumber + "</accountNumber>" +
				address.toString() +
				"<phoneNumber>" + phoneNumber + "</phoneNumber>" + 
				"<email>" + email + "</email>" + 
				"<reservations>" +
					reservationNumbers.toString() +
				"</reservations>" + 
			"</account>";
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		Helper.validateParameters(address.toString());
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		Helper.validateParameters(phoneNumber);
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		Helper.validateParameters(email);
		this.email = email;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	/**
	 * Save account information in file.
	 * If found duplicate, throw DuplicateObjectException.
	 * @param accountNumber 
	 * @return
	 */
	public void saveToFile() throws DuplicateObjectException {
		File folder = new File("./accounts/" + accountNumber);
		// Make account folder
		folder.mkdirs();
		try (
			FileWriter fw = new FileWriter("./accounts/" + accountNumber + "/acc" + accountNumber + ".xml")) {
			fw.write(Helper.beautifyXml(this.toString(), 2));
		} catch (Exception e) {
			e.printStackTrace();  
		}
	}

	public void saveToFile(HouseReservation houseReservation) throws DuplicateObjectException {
		try (
			FileWriter fw = new FileWriter("./accounts/" + accountNumber + "/res" + houseReservation.getReservationNumber() + ".xml")) {
			fw.write(Helper.beautifyXml(houseReservation.toString(), 2));
		} catch (Exception e) {
			e.printStackTrace();  
		}
	}

	/**
	 * Add reservation object to the ArrayList of Reservation objects (check for duplicates)
	 * and return the reservation number.
	 * If duplicate found, throw DuplicateObjectException.
	 * @param reservation Add reservation to the currently loaded Account
	 * @return
	 */
	public String addReservation(Reservation reservation) throws DuplicateObjectException {
		Helper.validateParameters(reservation.toString());
		this.reservations.add(reservation.getReservationNumber());
		System.out.println("this save to file:");
		this.saveToFile();
		return reservation.getReservationNumber();
	}

	public String addReservation(CabinReservation reservation) throws DuplicateObjectException {
		Helper.validateParameters(reservation.toString());
		this.reservations.add(reservation.getReservationNumber());
		return reservation.getReservationNumber();
	}

	public String addReservation(HotelReservation reservation) throws DuplicateObjectException {
		Helper.validateParameters(reservation.toString());
		this.reservations.add(reservation.getReservationNumber());
		return reservation.getReservationNumber();
	}

	public String addReservation(HouseReservation reservation) throws DuplicateObjectException {
		Helper.validateParameters(reservation.toString());
		this.reservations.add(reservation.getReservationNumber());
		System.out.println("this save to file:");
		this.saveToFile();
		this.saveToFile(reservation);
		return reservation.getReservationNumber();
	}

	/**
	 * Cancel reservation matching reservation number from currently loaded Account.  
	 * Can only cancel reservation if the start date is in the future.
	 * If cannot cancel, throw IllegalOperationException.
	 * @param reservation Add reservation to the currently loaded Account
	 * @return
	 */
	public void editReservation(Reservation reservation) throws IllegalOperationException {
		// TODO implement here
	}

	public void deleteReservation(Reservation reservation) throws IllegalOperationException {
		reservations.remove(reservations.indexOf(reservation));
	}

	/**
	 * @return
	 */
	public List<Reservation> getReservations() {
		// TODO implement here
		return null;
	}

}
