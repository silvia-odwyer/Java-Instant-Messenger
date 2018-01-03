package client;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

import javax.swing.SwingUtilities;

import javafx.application.Platform;

public class Client {
	private Socket connection;
	private String serverIP;
	private ObjectOutputStream outputStream;
	private ObjectInputStream inputStream;
	
	
	public Client(String host) {
		serverIP = host;	
		
	}
	public void startApp() throws IOException {
		try {
			System.out.println("CLIENT: Starting the application now . . .");
			connectToServer();
			setUpStreams();
			whileChatting();
			
		}catch(EOFException eofException) {
			System.out.println("CLIENT: The client terminated the connection . . . :(");
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			closeApp();
		}
		
	}
	
	public void testMethod() {
		System.out.println("CLIENT: The Client class is fully functioning and working :)");
	}
	
	public void connectToServer() throws IOException {
		System.out.println("CLIENT: The connectToServer method is working :)");
		// NEED TO UNCOMMENT OUT THE TWO LINES
		// !!!The Port Number below must be changed when this app runs on the server
//		connection = new Socket(InetAddress.getByName("127.0.0.1"), 6789);
//		System.out.println("Connected to:" + connection.getInetAddress().getHostName());
		
	}
	
	private void setUpStreams() throws IOException{
		System.out.println("CLIENT: Attempting to set up streams...");
//		outputStream = new ObjectOutputStream(connection.getOutputStream());
//		outputStream.flush();
//		
//		inputStream = new ObjectInputStream(connection.getInputStream());
		System.out.println("\n CLIENT: Streams are now set up! :D");
		
	}
	
	public void whileChatting() {
		System.out.println("CLIENT: Executing the start of the whileChatting method . . .");
		//allowedToType(true);
		/*do {
			try {
				//message = (String) inputStream.readObject();
				//showMessage("\n" + message);
				
			}catch(ClassNotFoundException classNotfoundException) {
				//showMessage("\n Sorry, but we can't figure out what you sent! You sent something a lil dodgy there! ");
				
			}
			
		}while(!message.equals("SERVER: END"));*/
		
		System.out.println("CLIENT: Reached the end of the whileChatting method . . .");
		
	}
	
	public void showMessage() {
		
		
	}
	
	
	
	public void closeApp() {
		System.out.println("CLIENT: Closing Client-side app now . . .");
		try {
			inputStream.close();
		} catch (IOException e) {
			System.out.println("Couldn't close the input stream . . .");
			e.printStackTrace();
		}
		try {
			outputStream.close();
		} catch (IOException e) {
			System.out.println("Couldn't close the output stream . . .");
			e.printStackTrace();
		}
	}


}
