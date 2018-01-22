package com.silviaodwyer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;

public class Sender {
	private static final Logger LOGGER = LoggerFactory.getLogger(Sender.class);
	
	@Autowired
	private JmsTemplate jmsTemplate;
	
	public void send(String destination, Sting message) {
		LOGGER.info("sending message='{}' to destination='{}'", message, destination);
		jmsTemplate.convertAndSend(destination, message);
	}
}
