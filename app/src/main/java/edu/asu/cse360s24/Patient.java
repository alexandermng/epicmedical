package edu.asu.cse360s24;

import java.util.Random;
import java.io.Serializable;
import java.util.ArrayList;

public class Patient implements Serializable {

    String id;
    String firstName;
	String lastName;
    String username;
    String password;
    String dateOfBirth; // "YYYY-MM-DD"
    int age;
    String phoneNumber; // "###-###-####"
    String insuranceID;
    String insuranceCompany;
    String pharmacy;
    ArrayList<Message> messages;

    public Patient(String id) {
        this.id = id;
        this.messages = new ArrayList<Message>();
    }

    private static Random rand = new Random();

    static String generateID() {
        return String.valueOf(rand.nextInt(99999));
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getInsuranceID() {
		return insuranceID;
	}

	public void setInsuranceID(String insuranceID) {
		this.insuranceID = insuranceID;
	}

	public String getInsuranceCompany() {
		return insuranceCompany;
	}

	public void setInsuranceCompany(String insuranceCompany) {
		this.insuranceCompany = insuranceCompany;
	}

	public String getPharmacy() {
		return pharmacy;
	}

	public void setPharmacy(String pharmacy) {
		this.pharmacy = pharmacy;
	}
}