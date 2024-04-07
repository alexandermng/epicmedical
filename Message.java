package epicmedical;

public class Message {

	private String to = "";
	private String from = "";
	private String message = "";
	
	
	Message(String to, String from, String message){
		this.to = to;
		this.from = from;
		this.message = message;
	}


	private String getTo() {
		return to;
	}


	private void setTo(String to) {
		this.to = to;
	}


	private String getFrom() {
		return from;
	}


	private void setFrom(String from) {
		this.from = from;
	}


	private String getMessage() {
		return message;
	}


	private void setMessage(String message) {
		this.message = message;
	}
}
