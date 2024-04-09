package edu.asu.cse360s24;

import java.io.Serializable;
import java.util.HashMap;

class Store implements Serializable {
	HashMap<String, Patient> patients; // patients by ID
	HashMap<String, String> config; // idk, misc configstuffs
	
	public Store() {
		patients = new HashMap<String, Patient>();
		config = new HashMap<String, String>();
	}
}
