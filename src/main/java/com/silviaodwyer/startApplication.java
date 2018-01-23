package com.silviaodwyer;

import javax.jms.ConnectionFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

@SpringBootApplication
@EnableJms
public class startApplication {
	
	@Bean
	public JmsListenerContainerFactory<?> myFactory(ConnectionFactory connectionFactory,
													DefaultJmsListenerContainerFactoryConfigurer configurer) {
		DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
		
		configurer.configure(factory,  connectionFactory);
		
		return factory;
	}
	
	@Bean // Converts all the messages to json
	public MessageConverter jacksonJmsMessageConverter() {
		MappingJackson2MessageConverter jsonConverter = new MappingJackson2MessageConverter();
		jsonConverter.setTargetType(MessageType.TEXT);
		jsonConverter.setTypeIdPropertyName("_type");
		return jsonConverter;
	}
	
	public static void main(String[] args) {
		// The following line will launch the application
		ConfigurableApplicationContext context = SpringApplication.run(startApplication.class, args);
		JmsTemplate jmsTemplate = context.getBean(JmsTemplate.class);
		
		System.out.println("Sending a message: ");
		jmsTemplate.convertAndSend("mailbox", new Message("username", "Hello, World!"));
		
	
	}
	
	

}
