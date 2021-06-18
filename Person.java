/**
 * This is the person class which holds all the information to create a new
 * person object.
 * 
 * @author Nada
 *
 */
public class Person {
	// Instance variables used to create a new person.
	private String firstName;
	private String lastName;
	private String phone;
	private String email;
	private String address;

	// Getters and Setters
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * Default person constructor
	 * 
	 * @param firstName
	 * @param lastName
	 * @param phone
	 * @param email
	 * @param address
	 */
	public Person(String firstName, String lastName, String phone, String email, String address) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.email = email;
		this.address = address;
	}

	/**
	 * toString displays the Person object data
	 */
	public String toString() {
		String output = "Name: " + firstName + " " + lastName;
		output += "\nMobile Number: " + phone;
		output += "\nEmail: " + email;
		output += "\nAddress: " + address;
		return output;
	}
}