package ams;

/**
 * When loading account and/or reservations from file if the file does not exist 
 * throw unchecked user defined exception called IllegalLoadException when 
 * violation detected
 */
public class IllegalLoadException extends RuntimeException {

	private String fileName;

	/**
	 * @param fileName
	 */
	public IllegalLoadException(String fileName) {
		Helpers.validateParameters(fileName);
		this.fileName = fileName;
	}

	/**
	 * @return Error message string
	 */
	public String toString() {
		return "Error loading file: " + fileName;
	}

}