package com.silviaodwyer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Listener {
	@JmsListener(destination = "mailbox", containerFactory = "myFactory")
	public void receiveMessageContents(Message message) {
		System.out.println("You have received a message.");
		System.out.println("The message you received is: ");
		System.out.println("MESSAGE: " + message + ".");
	}
}
