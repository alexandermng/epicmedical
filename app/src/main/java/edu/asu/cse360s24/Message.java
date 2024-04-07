package edu.asu.cse360s24;

import java.io.Serializable;

public class Message implements Serializable {

	private String to; // hmm.. these should be objects. TODO rewrite
	private String from;
	private String message;

	Message(String to, String from, String message) {
		this.to = to;
		this.from = from;
		this.message = message;
	}

	public String getTo() {
		return to;
	}

	public String getFrom() {
		return from;
	}

	public String getMessage() {
		return message;
	}
}
