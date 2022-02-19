import java.util.*;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import java.io.File;

public class Account {

	private String accountNumber;
	private Address address;
	private String phoneNumber;
	private String email = null;
	private Vector<Reservation> reservations;

	public static void main(String... args) {
		// Address testAddress = new Address("street", "city", "state", "zipcode");
        // Account testAccount = new Account("accountNumber", testAddress, "phoneNumber", "email");
		// System.out.println("\n" + testAccount.toString());

		String fileName = "ABCD1234/accABCD1234.xml";
		Account testAccount2 = new Account(fileName);
		System.out.println("\n" + testAccount2.toString());
    }

	/**
	 * Construct to create Account object and assign values for a new Account 
	 * object
	 * Check for existing account number to avoid duplicate
	 * @param accountNumber 
	 * @param address 
	 * @param phoneNumber 
	 * @param email
	 */
	public Account(String accountNumber, Address address, String phoneNumber, 
	String email) throws IllegalArgumentException {
		// Validate parameters and throws IllegalArgumentException except for 
		// email address
		Helpers.validateParameters(accountNumber, address.toString(), phoneNumber);

		this.accountNumber = accountNumber;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.email = email;
		reservations = new Vector<Reservation>();
	}

	/**
	 * Overloading constructor if parameter is a file name
	 * Validate parameters and throws IllegalArgumentException
	 * Read content from file
	 * @param fileName 
	 */
	public Account(String fileName) throws IllegalArgumentException {
		// Validate parameters and throws IllegalArgumentException
		Helpers.validateParameters(fileName);

		// Create a constructor of file class and parsing an XML file 
		try { 
			File accountFile = new File("./accounts/" + fileName);  
			// Create an instance of factory that gives a document builder  
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();  
			// Ceate an instance of builder to parse the specified xml accountFile  
			DocumentBuilder db = dbf.newDocumentBuilder();  
			Document document = db.parse(accountFile);
			// Assign values from file to object
			this.accountNumber = Helpers.readTagFromDocument(document, "accountNumber");

			String street = Helpers.readTagFromDocument(document, "street");
			String city = Helpers.readTagFromDocument(document, "city");
			String state = Helpers.readTagFromDocument(document, "state");
			String zipcode = Helpers.readTagFromDocument(document, "zipcode");
			this.address = new Address(street, city, state, zipcode);
			this.phoneNumber = Helpers.readTagFromDocument(document, "phoneNumber");
			this.email = Helpers.readTagFromDocument(document, "email");
			reservations = new Vector<Reservation>();
		} catch (Exception e) {  
			e.printStackTrace();  
		}  
	}

	/**
	 * @return String in XML format
	 */
	public String toString() {
		return 
			"<account>" + 
				"<accountNumber>" + accountNumber + "</accountNumber>" +
				address.toString() +
				"<phoneNumber>" + phoneNumber + "</phoneNumber>" + 
				"<email>" + email + "</email>" + 
				"<reservations>" +
					"<reservation></reservation>" +
				"</reservations>" + 
			"</account>";
	}

	/**
	 * @return
	 */
	public Address getAddress() {
		// TODO implement here
		return null;
	}

	/**
	 * @param address 
	 * @return
	 */
	public void setAddress(Address address) {
		// TODO implement here
	}

	/**
	 * @return
	 */
	public String getPhoneNumber() {
		// TODO implement here
		return "";
	}

	/**
	 * @param phoneNumber 
	 * @return
	 */
	public void setPhoneNumber(String phoneNumber) {
		// TODO implement here
	}

	/**
	 * @return
	 */
	public String getEmail() {
		// TODO implement here
		return "";
	}

	/**
	 * @param email 
	 * @return
	 */
	public void setEmail(String email) {
		// TODO implement here
	}

	/**
	 * @return
	 */
	public String getAccountNumber() {
		// TODO implement here
		return "";
	}

	/**
	 * Save account information in file.
	 * If found duplicate, throw DuplicateObjectException.
	 * @param fileName 
	 * @return
	 */
	public void saveToFile(String fileName) throws DuplicateObjectException {
		// TODO implement here
	}

	/**
	 * Add reservation object to the Vector of Reservation objects (check for duplicates)
	 * and return the reservation number.
	 * If duplicate found, throw DuplicateObjectException.
	 * @param reservation Add reservation to the currently loaded Account
	 * @return
	 */
	public String addReservation(Reservation reservation) throws DuplicateObjectException {
		// TODO implement here
		return "";
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

	/**
	 * @return
	 */
	public List<Reservation> getReservations() {
		// TODO implement here
		return null;
	}

}