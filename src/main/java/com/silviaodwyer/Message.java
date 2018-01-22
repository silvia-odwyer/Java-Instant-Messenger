package com.silviaodwyer;

public class Message {
	private String message;
	private String toUsername;
	
	public Message() {
		
	}
	
	public Message(String toUsername, String message) {
		this.message = message;
		this.toUsername = toUsername;
	}
	
	public String getToUsername() {
		return toUsername;
	}
	
	public void SetTo(String toUsername) {
		this.toUsername = toUsername;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	@Override
	public String toString() {
		return String.format("Message{to=%s, message=%s}", getToUsername(), getMessage());
	}

}
