import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * @author Dawid Kupny
 *
 */

public class AddressBookApp {
	public static final int EXIT = 0;
	public static final int ADD_ADDRESS = 1;
	public static final int SHOW_ADDRESSES = 2;

	public static void main(String[] args) throws SQLException {
		DataBase dataBase = DataBase.getInstance();
		int userOption;

		dataBase.connect();

		try(Scanner sc = new Scanner(System.in);) {
			System.out.println("KSIAZKA ADRESOWA");
			do {
				printOptions();
				userOption = sc.nextInt();
				sc.nextLine();

				switch(userOption) {
				case EXIT:
					break;
				case ADD_ADDRESS:
					readData(sc, dataBase);
					break;
				case SHOW_ADDRESSES:
					printData();
					break;
				}
			} while (userOption != EXIT);
		dataBase.disconnect();
		}

	}

	static void readData(Scanner sc, DataBase dataBase/*, List<Person> list*/) throws SQLException {
		System.out.print("Podaj imie: ");
		String firstName = sc.nextLine();
		System.out.print("Podaj nazwisko: ");
		String lastName = sc.nextLine();
		System.out.print("Podaj ulice: ");
		String street = sc.nextLine();
		System.out.print("Podaj nr domu: ");
		String houseNumber = sc.nextLine();
		System.out.print("Podaj kod pocztowy: ");
		String postalCode = sc.nextLine();
		System.out.print("Podaj miasto: ");
		String city = sc.nextLine();

		dataBase.executeUpdate("INSERT INTO addresses VALUES ('"+firstName+"', '"+lastName+"', '"+street+"', '"+houseNumber+""
				+ "', '"+postalCode+"', '"+city+"')");
		System.out.println("Aby dodac kolejny wpis wcisnij \"1\", aby wyjsc do glownego menu wcisnij dowolny klawisz...");
		String input = sc.nextLine();
		if(!input.equals("1"))
			return;

		readData(sc, dataBase);
	}

	static void printData() throws SQLException {
		ResultSet rs = DataBase.getInstance().executeQuery("select * from addresses");

		while(rs.next()) {
			System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getString(6));
		}

	}

	static void printOptions() {
		System.out.println("0 - Wyjscie");
		System.out.println("1 - Dodanie obiektu do ksiazki adresowej");
		System.out.println("2 - Wyswietlenie ksiazki adresowej");
	}
}
