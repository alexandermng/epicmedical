package edu.asu.cse360s24;

import java.io.Serializable;

public class Person implements Serializable {
	protected static final long serialVersionUID = 1L;

	String firstName;
	String lastName;
	String username;
	String password;

	public Person() {
	}

	public String getName() {
		return firstName + " " + lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}
}
