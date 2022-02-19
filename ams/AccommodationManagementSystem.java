package ams;

public class AccommodationManagementSystem {
	public static void main(String... args) {
		test1();
		test2();
    }

	public static void test1() {
		System.out.println("\nTest create new Account:\n");
		Address testAddress = new Address("4083 Narrow St.", "Montgomery City", "ARK", "48910");
        Account testAccount = new Account("MSUO0414", testAddress, "081-490-9491", "MSUO0414@gmail.com");
		System.out.println(Helpers.printXml(testAccount.toString(), 2));
	}

	public static void test2() {
		System.out.println("\nTest load Account from file:\n");
		String fileName = "ABCD1234/accABCD1234.xml";
		Account testAccount = new Account(fileName);
		System.out.println(Helpers.printXml(testAccount.toString(), 2));
	}
}
