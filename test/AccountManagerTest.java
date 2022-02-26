package test;

import ams.Account;
import ams.AccountManager;
import ams.Address;
import ams.Helper;
import ams.HotelReservation;
import ams.HouseReservation;

public class AccountManagerTest {

    private static AccountManager accountManager = new AccountManager();

    public static void main(String []args) {
        // createNewAccountTest();
        // openFromFileTest();
        // saveToFileTest();
        // addReservationTest();
        deleteReservationTest();
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
            Helper.checkPassingTest(expectedError, e.toString());
        }

        System.out.println("\nCreate an account that doesn't exist.");
        Account newAccount = new Account("ZXCV4909", address, "test", "test@test.com");
        // Clean up test file
        Helper.deleteFile("./accounts/" + newAccount.getAccountNumber());
        try {
            accountManager.createNewAccount(newAccount);
            System.out.println("Account created successfully.");
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
            accountManager.openFromFile("NOPE0000");
        } catch (Exception e) {
            String expectedError = "Error loading file: NOPE0000. File doesn't exist.";
            Helper.checkPassingTest(expectedError, e.toString());
        }
    }

    // public static void saveToFileTest() {
    //     System.out.println("\n=== Save to file tests ===");

    //     System.out.println("\nSave to a file that already exists.");
    //     Account loadedAccount = accountManager.openFromFile("ABCD1234");
    //     System.out.println("Account details before:");
    //     System.out.println(Helper.beautifyXml(loadedAccount.toString(), 2));
    //     Address newAddress = new Address("1000 Sesame St.", "Fun City", "Sesame", "10942");
    //     loadedAccount.setAddress(newAddress);
    //     loadedAccount.setEmail("test@email.com");
    //     accountManager.saveToFile("./accounts/ABCD1234/accABCD1234.xml", loadedAccount.toString());
    //     System.out.println("Account details after:");
    //     System.out.println(Helper.beautifyXml(loadedAccount.toString(), 2));
    //     System.out.println("File updated successfully.");

    //     // Reset
    //     Address oldAddress = new Address("9082 Example St.", "Big City", "Small", "10942");
    //     loadedAccount.setAddress(oldAddress);
    //     loadedAccount.setEmail("email2@test.com");
    //     accountManager.saveToFile("./accounts/ABCD1234/accABCD1234.xml", loadedAccount.toString());
    // }

    public static void addReservationTest() {
        System.out.println("\n=== Add reservation tests ===");

        Address address = new Address("street", "city", "state", "zipcode");

        System.out.println("\nAdd a reservation that already exists.");
        HotelReservation existingHotelReservation = new HotelReservation("ABCD1234", "HOTEL9087", "hotel", address.toString(), "2022-10-01", "2022-11-01", "1000", "2000", null, true);
        try {
            accountManager.addReservation(existingHotelReservation);
        } catch (Exception e) {
            String expectedError = "Error adding reservation: " + existingHotelReservation.getReservationNumber() + ". Reservation number already exists.";
            Helper.checkPassingTest(expectedError, e.toString());
        }

        System.out.println("\nAdd a new reservation.");
        HouseReservation newHouseReservation = new HouseReservation("ABCD1234", "HOUSE0532", "house", address.toString(), "2022-04-20", "2022-05-20", "2", "3", "2", "2000", "15000", null, 3);
        Account account = accountManager.openFromFile(newHouseReservation.getAccountNumber());
        System.out.println("Account before adding:");
        System.out.println(Helper.beautifyXml(account.toString(), 2));
        accountManager.addReservation(newHouseReservation);
        System.out.println("Account after adding:");
        System.out.println(Helper.beautifyXml(account.toString(), 2));
        // Reset
        // accountManager.deleteReservation(newHouseReservation);
    }

    public static void deleteReservationTest() {
        accountManager.openFromFile("ABCD1234");
        Address address = new Address("street", "city", "state", "zipcode");
        HouseReservation newHouseReservation = new HouseReservation("ABCD1234", "HOUSE9999", "house", address.toString(), "2022-04-20", "2022-05-20", "2", "3", "2", "2000", "15000", null, 3);
        // accountManager.addReservation(newHouseReservation);
        
        accountManager.deleteReservation("HOUSE9999");
    }
}
