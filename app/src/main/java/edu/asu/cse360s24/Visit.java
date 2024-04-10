package edu.asu.cse360s24;

import java.io.Serializable;

public class Visit implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	String date;
	Doctor doctor;
	Nurse nurse;
	
	String weight;
	String height;
	String bodyTemp;
	String bloodPressure;
	String allergies;
	String concerns;
	
	String previousIssues;
	String prescriptions;
	String immuneHistory;
	String recommendations;
	String examNotes;
	String prescription;
	
	public Visit() {
		
	}

	public String toString() {
		return "Visit with Dr. "+doctor.lastName+" on "+date;
	}
}
