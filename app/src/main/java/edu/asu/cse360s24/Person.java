package edu.asu.cse360s24;

import java.io.Serializable;
import java.util.ArrayList;

public class Person implements Serializable {
	
	private static final long serialVersionUID = 1L;
	 String firstName;
	 String lastName;
	 String username;
	 String password;
	 ArrayList<Message> messages;
	 
	 public Person() {
		 this.messages = new ArrayList<Message>();
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

}
