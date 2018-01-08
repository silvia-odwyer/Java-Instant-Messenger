package client;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

import javax.swing.SwingUtilities;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Client {
	private Socket connection;
	private String serverIP;
	private ObjectOutputStream outputStream;
	private ObjectInputStream inputStream;
	private String su3;
	public String currentStatus;
	
	public Client(String host) {
		serverIP = host;	
		
	}
	
	public static void connectionRequest() throws IOException {
		// NEED TO UNCOMMENT OUT THE TWO LINES
		// !!!The Port Number below must be changed when this app runs on the server
//		connection = new Socket(InetAddress.getByName("127.0.0.1"), 6789);
//		System.out.println("Connected to:" + connection.getInetAddress().getHostName());
		
	}
	
	public static void setUpStreams() throws IOException{
		System.out.println("SET UP STREAMS IS WORKING");
//		outputStream = new ObjectOutputStream(connection.getOutputStream());
//		outputStream.flush();
//		
//		inputStream = new ObjectInputStream(connection.getInputStream());

	}
	
	public static void whileChatting() throws IOException{
		System.out.println("WHILE CHATTING HAS BEEN CALLED");
		//allowedToType(true);
				/*do {
					try {
						//message = (String) inputStream.readObject();
						//showMessage("\n" + message);
						
					}catch(ClassNotFoundException classNotfoundException) {
						//showMessage("\n Sorry, but we can't figure out what you sent! You sent something a lil dodgy there! ");
						
					}
					
				}while(!message.equals("SERVER: END"));*/
	}
	
}
