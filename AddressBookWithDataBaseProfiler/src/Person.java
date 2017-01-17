
public class Person implements Comparable<Person>{
	private String firstName;
	private String lastName;
	private String street;
	private String houseNumber;
	private String postalCode;
	private String city;

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getHouseNumber() {
		return houseNumber;
	}
	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}

	public Person(String firstName, String lastName, String street, String houseNumber, String postalCode, String city) {
		setFirstName(firstName);
		setLastName(lastName);
		setStreet(street);
		setHouseNumber(houseNumber);
		setPostalCode(postalCode);
		setCity(city);
	}

	@Override
	public String toString() {
		return "> "+getFirstName()+" "+getLastName()+" ul. "+getStreet()+" "+getHouseNumber()+", "+getPostalCode()+" "+getCity();
	}

	@Override
	public int compareTo(Person p) {
		int firstNameCompare = firstName.compareTo(p.getFirstName());
		if(firstNameCompare != 0) {
			return firstNameCompare;
		}
		int lastNameCompare = lastName.compareTo(p.getLastName());
		if(lastNameCompare != 0) {
			return lastNameCompare;
		}
		int streetCompare = street.compareTo(p.getStreet());
		if(streetCompare != 0) {
			return streetCompare;
		}
		return houseNumber.compareTo(p.getHouseNumber());
	}



}
