package com.silviaodwyer;

import javax.jms.Destination;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.jms.core.JmsTemplate;

public class JmsCreator {
	private JmsTemplate jmsTemplate;
	private Destination destination;
	
	public JmsTemplate getJmsTemplate() {
		return jmsTemplate;
	}
	
	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}
	
	public Destination getDestination() {
		return destination;
	}
	
	public void setDestination(Destination destination) {
		this.destination = destination;
	}
	
}
