package test;

import java.time.LocalDate;

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
        // addReservationTest();
        // deleteReservationTest();
        cancelReservationTest();
    }

    public static void createNewAccountTest() {
        System.out.println("\n=== Create new account tests ===");

        Address address = new Address("street", "city", "state", "zipcode");

        System.out.println("\n📌 Create an account that already exists.");
        Account existingAccount = new Account("ABCD1234", address, "test", "test@test.com");
        try {
            accountManager.createNewAccount(existingAccount);
        } catch (Exception e) {
            String expectedError = "Error adding account: " + existingAccount.getAccountNumber() + ". Account number already exists.";
            Helper.checkPassingTest(expectedError, e.toString());
        }

        System.out.println("\n📌 Create an account that doesn't exist.");
        Account newAccount = new Account("ZXCV4909", address, "test", "test@test.com");
        // Clean up test file
        Helper.deleteFile("./accounts/" + newAccount.getAccountNumber());
        try {
            accountManager.createNewAccount(newAccount);
            System.out.println("✅ Account created successfully.");
            accountManager.openFromFile(newAccount.getAccountNumber());
            System.out.println(Helper.beautifyXml(accountManager.toString(), 2));
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public static void openFromFileTest() {
        System.out.println("\n=== Open from file tests ===");
        
        System.out.println("\n📌 Open a file that already exists.");
        accountManager.openFromFile("ABCD1234");
        System.out.println("✅ Account " + accountManager.getAccountNumber() + " loaded successfully.");
        System.out.println(Helper.beautifyXml(accountManager.toString(), 2));

        System.out.println("\n📌 Open an account file that doesn't exist.");
        try {
            accountManager.openFromFile("NOPE0000");
        } catch (Exception e) {
            String expectedError = "Error loading file: accNOPE0000. File doesn't exist.";
            Helper.checkPassingTest(expectedError, e.toString());
        }
    }

    public static void addReservationTest() {
        System.out.println("\n=== Add reservation tests ===");

        Address address = new Address("street", "city", "state", "zipcode");

        System.out.println("\n📌 Add a reservation that already exists.");
        HotelReservation existingHotelReservation = new HotelReservation("ABCD1234", "HOTEL9087", "hotel", address.toString(), "2022-10-01", "2022-11-01", "1000", null, true);
        try {
            accountManager.addReservation(existingHotelReservation);
        } catch (Exception e) {
            String expectedError = "Error adding reservation: " + existingHotelReservation.getReservationNumber() + ". Reservation number already exists.";
            Helper.checkPassingTest(expectedError, e.toString());
        }

        System.out.println("\n📌 Add a new reservation.");
        HouseReservation newHouseReservation = new HouseReservation("ABCD1234", "HOUSE0532", "house", address.toString(), "2022-04-20", "2022-05-20", "2", "3", "2", "2000", null, 3);
        accountManager.openFromFile(newHouseReservation.getAccountNumber());
        // Clean up
        accountManager.deleteReservation(newHouseReservation.getReservationNumber());

        System.out.println("Account before adding:");
        System.out.println(Helper.beautifyXml(accountManager.toString(), 2));
        accountManager.addReservation(newHouseReservation);
        System.out.println("✅ Reservation " + newHouseReservation.getReservationNumber() + " has been added successfully.");
        System.out.println("Account after adding:");
        System.out.println(Helper.beautifyXml(accountManager.toString(), 2));
    }

    public static void deleteReservationTest() {
        System.out.println("\n=== Delete reservation tests ===");

        System.out.println("\n📌 Delete an existing reservation.");
        accountManager.openFromFile("ABCD1234");
        // Add new reservation to delete
        Address address = new Address("street", "city", "state", "zipcode");
        HouseReservation newHouseReservation = new HouseReservation("ABCD1234", "HOUSE9999", "house", address.toString(), "2022-04-20", "2022-05-20", "2", "3", "2", "2000", null, 3);
        accountManager.addReservation(newHouseReservation);
        System.out.println("Account before deleting:");
        System.out.println(Helper.beautifyXml(accountManager.toString(), 2));
        accountManager.deleteReservation("HOUSE9999");
        System.out.println("✅ Reservation " + newHouseReservation.getReservationNumber() + " has been deleted successfully.");
        System.out.println("Account after deleting:");
        System.out.println(Helper.beautifyXml(accountManager.toString(), 2));

        System.out.println("\n📌 Delete a non-existing reservation.");
        try {
            accountManager.deleteReservation("HOTEL1983");
        } catch (Exception e) {
            String expectedError = "Error loading file: resHOTEL1983. File doesn't exist.";
            Helper.checkPassingTest(expectedError, e.toString());
        }
    }

    public static void cancelReservationTest() {
        System.out.println("\n=== Cancel reservation tests ===");

        System.out.println("\n📌 Cancel an existing reservation.");
        accountManager.openFromFile("ABCD1234");

        // Create a hotel reservation to cancel
        Address address = new Address("street", "city", "state", "zipcode");
        LocalDate today = LocalDate.now();
        LocalDate futureCheckin = today.plusDays(30);
        LocalDate futureCheckout = today.plusDays(45);
        // System.out.println(futureCheckin.toString() + " to " + futureCheckout.toString());

        HotelReservation cancellableHotelRes = new HotelReservation("ABCD1234", "HOTEL4801", "reservationType", address.toString(), futureCheckin.toString(), futureCheckout.toString(), "200", "test@email.com", true);
        accountManager.addReservation(cancellableHotelRes);
        System.out.println("Reservations before: " + accountManager.getReservations().toString());
        accountManager.cancelReservation("HOTEL4801");
        System.out.println("Reservations after: " + accountManager.getReservations().toString());

        System.out.println("\n📌 Cancel an existing reservation but checkin date has passed.");

        System.out.println("\n📌 Cancel a non-existing reservation.");
        try {
            accountManager.cancelReservation("HOTEL1234");
        } catch (Exception e) {
            String expectedError = "Error loading file: resHOTEL1234. File doesn't exist.";
            Helper.checkPassingTest(expectedError, e.toString());
        }
    }
}
