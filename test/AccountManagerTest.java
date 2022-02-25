package test;

import ams.Account;
import ams.AccountManager;
import ams.Address;
import ams.Helper;
import ams.HotelReservation;

public class AccountManagerTest {

    private static AccountManager accountManager = new AccountManager();

    public static void main(String []args) {
        // createNewAccountTest();
        // openFromFileTest();
        // saveToFileTest();
        addReservationTest();
    }

    public static void createNewAccountTest() {
        System.out.println("\n=== Create new account tests ===");

        Address address = new Address("street", "city", "state", "zipcode");

        System.out.println("\nCreate an account that already exists.");
        Account existingAccount = new Account("ABCD1234", address, "test", "test@test.com");
        try {
            accountManager.createNewAccount(existingAccount);
        } catch (Exception e) {
            String expectedError = "Error adding account: " + existingAccount.getAccountNumber() + ". Account number already exists.";
            System.out.println("Expected error: " + expectedError);
            System.out.println("Test pass: " + e.toString().equals(expectedError));
        }

        System.out.println("\nCreate an account that doesn't exist.");
        Account newAccount = new Account("ZXCV4909", address, "test", "test@test.com");
        // Clean up old test file
        Helper.deleteFile("./accounts/" + newAccount.getAccountNumber());
        try {
            accountManager.createNewAccount(newAccount);
            System.out.println("Account created successfully:");
            Account loadedAccount = accountManager.openFromFile(newAccount.getAccountNumber());
            System.out.println(Helper.beautifyXml(loadedAccount.toString(), 2));
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public static void openFromFileTest() {
        System.out.println("\n=== Open from file tests ===");
        
        System.out.println("\nOpen a file that already exists.");
        Account loadedAccount = accountManager.openFromFile("ABCD1234");
        System.out.println("Account " + loadedAccount.getAccountNumber() + " loaded successfully.");
        System.out.println(Helper.beautifyXml(loadedAccount.toString(), 2));

        System.out.println("\nOpen a file that doesn't exist.");
        try {
            accountManager.openFromFile("NOTE0000");
        } catch (Exception e) {
            String expectedError = "Error loading file: NOPE0000. File doesn't exist.";
            System.out.println("Expected error: " + expectedError);
            System.out.println("Test pass: " + e.toString().equals(expectedError));
        }
    }

    public static void saveToFileTest() {
        System.out.println("\n=== Save to file tests ===");

        System.out.println("\nSave to a file that already exists.");
        Account loadedAccount = accountManager.openFromFile("ABCD1234");
        accountManager.saveToFile("./accounts/ABCD1234", "acc");
        System.out.println(Helper.beautifyXml(loadedAccount.toString(), 2));

        System.out.println("\nSave to a file that already exists but with wrong type.");
        try {
            accountManager.saveToFile("./accounts/ABCD1234", "abc");
        } catch (Exception e) {
            String expectedError = "java.lang.IllegalArgumentException: fileType must be 'acc' or 'res'.";
            System.out.println("Expected error: " + expectedError);
            System.out.println("Test pass: " + e.toString().equals(expectedError));
        }
    }

    public static void addReservationTest() {
        System.out.println("\n=== Add reservation tests ===");

        Address address = new Address("street", "city", "state", "zipcode");

        System.out.println("\nAdd a reservation that already exists.");
        // HotelReservation existingHotelReservation = new HotelReservation("ABCD1234", "resHOTEL9087", address, "2022-10-01", "2022-10-10", "1000", true);
        // accountManager.addReservation(existingHotelReservation);
        // try {
        //     accountManager.addReservation(existingHotelReservation);
        // } catch (Exception e) {
        //     String expectedError = "Error adding account: " + existingHotelReservation.getAccountNumber() + ". Account number already exists.";
        //     System.out.println("Expected error: " + expectedError);
        //     System.out.println("Test pass: " + e.toString().equals(expectedError));
        // }
    }
}
