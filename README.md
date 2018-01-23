# Java-Instant-Messenger
A WIP Instant Messenger implemented using Java Spring, the Java Message Service, and ActiveMQ 

Java Spring Instant Messenger (name yet to be decided) is an active model topic-subscription instant messenger, which is implemented through the Java Spring framework, the Java Message Service, as well as the ActiveMQ message broker service. Spring allows for the abstraction of messaging-based systems, and it also doesn't need explicit connections or input streams to be set up since the JMS as well as the Spring Framework can work with one another, and the Spring FRamework also abstractifies a lot of the backend.

This instant messenger is currently in development, and requires further functionality to be integrated in order for it to be
available on a web browser. 

For now, I ask you don't download it yet, as it still requires further development. :) 

## Technologies Used
-- This messenger will be deployed as a Spring Boot Application, and will be deployed on Amazon Web Service's, using their
framework. In order for this to occur, I have coded this messenger using the Java Spring Framework. 

-- The Java Message Service has additional support when used in conjunction with the Spring Framework, and the Spring Framework also abstractifies the 
networking, so that no extra configurations have to be added. The JMS helps for asynchronous 
messaging, which in turn can allow all users in a chat room view all messages sent forth between users. 

-- This messenger implements the use of ActiveMQ, which is a message broker service. 
It also sets a standard for all message types to be sent.
