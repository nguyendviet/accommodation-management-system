package test;

import ams.Account;
import ams.AccountManager;
import ams.Address;
import ams.Helper;

public class AccountManagerTest {
    public static void main(String []args) {
        createNewAccountTest();
    }

    public static void createNewAccountTest() {
        System.out.println("\n=== Create new account tests ===");
        Address address = new Address("street", "city", "state", "zipcode");

        System.out.println("\nCreate an account that already exists.");
        Account existingAccount = new Account("ABCD1234", address, "test", "test@test.com");
        try {
            AccountManager am = new AccountManager();
            am.createNewAccount(existingAccount);
        } catch (Exception e) {
            String expectedError = "Error adding account: " + existingAccount.getAccountNumber() + ". Account number has already existed.";
            System.out.println("Expected error: " + expectedError);
            System.out.println("Test result: " + e.toString().equals(expectedError));
        }

        System.out.println("\nCreate an account that doesn't exist.");
        Account newAccount = new Account("ZXCV4909", address, "test", "test@test.com");
        // Clean up old test file
        Helper.deleteFile("./accounts/" + newAccount.getAccountNumber());
        try {
            AccountManager am = new AccountManager();
            am.createNewAccount(newAccount);
            System.out.println("Account created successfully:");
            Account loadedAccount = am.openFromFile(newAccount.getAccountNumber());
            System.out.println(Helper.beautifyXml(loadedAccount.toString(), 2));
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
