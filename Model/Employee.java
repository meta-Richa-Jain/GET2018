package Model;

import java.util.Date;

public class Employee {

	private String firstName;
	private String lastName;
	private String email;
	private int age;
	private Date dob;
	private String contactNumber;
	private String password;
	private String orgName;
	private String image_url;

	public Employee(String firstName, String lastName, String email, int age, Date dob, String contactNumber,
			String password, String orgName) {

		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.age = age;
		this.dob = dob;
		this.contactNumber = contactNumber;
		this.password = password;
		this.orgName = orgName;
		this.image_url = "C:/Users/user/eclipse-workspace/EAD-Assignment4/WebContent/default.png";

	}

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getImage_url() {
		return image_url;
	}

	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}

}
