package com.silviaodwyer.mvc;

import java.util.ArrayList;
import java.util.List;
//WelcomeService.java implements the Generic Welcome Service interface.

public class viewMessageService implements GenericViewMessageService {
	public List<String> getMessage(String name){
		List<String> myMessage = new ArrayList<String>();
		// Will print out the message as received from the JMS Queue in due time
		// Add data to the list
		myMessage.add("Hello! ");
		myMessage.add(name);
		myMessage.add("you have received a message");
		
		return myMessage;
	}

}
