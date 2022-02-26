package ams;

public class AccommodationManagementSystem {
	public static void main(String... args) {
		test1();
		test2();
		// test3();
		// test4();
		// test5();
    }

	public static void test1() {
		System.out.println("\nTest create new Account:\n");
		Address address = new Address("4083 Narrow St.", "Montgomery City", "AZ", "48910");
        Account account = new Account("MSUO0414", address, "081-490-9491", "MSUO0414@gmail.com");
		System.out.println(Helper.beautifyXml(account.toString(), 2));
	}

	public static void test2() {
		System.out.println("\nTest load Account from file:\n");
		String accountNumber = "ABCD1234";
		Account account = new Account(accountNumber);
		System.out.println(Helper.beautifyXml(account.toString(), 2));
	}

	// public static void test3() {
	// 	System.out.println("\nTest create new Cabin Reservation:\n");
	// 	Address address = new Address("9491 Block Rd.", "Vice City", "YA", "84712");
	// 	CabinReservation cabin = new CabinReservation("NULC1428", "resCABIN5014", address, "2022-10-13", "2022-12-13", "2000", false, true);
	// 	System.out.println(Helper.beautifyXml(cabin.toString(), 2));
	// }

	// public static void test4() {
	// 	System.out.println("\nTest load Hotel Reservation from file:\n");
	// 	String fileName = "ABCD1234/resHOTEL9087.xml";
	// 	HotelReservation hotel = new HotelReservation(fileName);
	// 	System.out.println(Helper.beautifyXml(hotel.toString(), 2));
	// }

	// public static void test5() {
	// 	System.out.println("\nTest create new House Reservation:\n");
	// 	Address address = new Address("134 Elm St.", "Vice City", "BA", "84341");
	// 	HouseReservation house = new HouseReservation("YQCO1023", "resHOUSE1314", address, "2022-10-13", "2022-12-13", "2000", 1);
	// 	System.out.println(Helper.beautifyXml(house.toString(), 2));
	// }
}
