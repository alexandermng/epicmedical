package edu.asu.cse360s24;

import java.util.ArrayList;
import java.util.Random;
import java.io.Serializable;

public class Patient extends Person implements Serializable {

	private static final long serialVersionUID = 1L;
    String id;
    String dateOfBirth; // "YYYY-MM-DD"
    int age;
    String phoneNumber; // "###-###-####"
    String insuranceID;
    String insuranceCompany;
    String pharmacy;
    String emergencyContact;
    
    ArrayList<Visit> previousVisits;
    
    Doctor doctor;
    Nurse nurse;

    public Patient(String id) {
    	super();
        this.id = id;
    }

    private static Random rand = new Random();

    static String generateID() {
        return String.valueOf(rand.nextInt(99999));
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