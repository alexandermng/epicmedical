package edu.asu.cse360s24;

import java.io.Serializable;

public class Message implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Person from;
	private String message;

	Message(Person from, String message) {
		this.from = from;
		this.message = message;
	}

	public Person getFrom() {
		return from;
	}

	public String getMessage() {
		return message;
	}
}
