package com.silviaodwyer.mvc;

import java.util.ArrayList;
import java.util.List;
//WelcomeService.java implements the Generic Welcome Service interface.

public class viewMessageService implements GenericViewMessageService {
	public List<String> getMessage(String name){
		List<String> myMessage = new ArrayList<String>();
		
		// Add data to the list
		myMessage.add("Hello! ");
		myMessage.add(name);
		myMessage.add(", welcome to the Java Spring course :-)");
		
		return myMessage;
	}

}
