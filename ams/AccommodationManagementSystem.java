package ams;

import test.AccountManagerTest;

public class AccommodationManagementSystem {
	public static void main(String... args) {
		AccountManagerTest.createNewAccountTest();
		AccountManagerTest.openFromFileTest();
		AccountManagerTest.addReservationTest();
		AccountManagerTest.deleteReservationTest();
		AccountManagerTest.cancelReservationTest();
    }
}
