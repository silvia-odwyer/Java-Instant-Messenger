package application;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

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
			System.out.println("Starting the application now . . .");
			connectToServer();
			setUpStreams();
			whileChatting();
			
		}catch(EOFException eofException) {
			System.out.println("The client terminated the connection . . . :(");
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			closeApp();
		}
		
	}
	
	public void testMethod() {
		System.out.println("The Client class is fully functioning and working :)");
	}
	
	public void connectToServer() throws IOException {
		System.out.println("The connectToServer method is working :)");
		// NEED TO UNCOMMENT OUT THE TWO LINES
		// !!!The Port Number below must be changed when this app runs on the server
//		connection = new Socket(InetAddress.getByName("127.0.0.1"), 6789);
//		System.out.println("Connected to:" + connection.getInetAddress().getHostName());
		
	}
	
	private void setUpStreams() throws IOException{
		outputStream = new ObjectOutputStream(connection.getOutputStream());
		outputStream.flush();
		
		inputStream = new ObjectInputStream(connection.getInputStream());
		System.out.println("\n Streams are now set up! :D");
		
	}
	
	public void whileChatting() {
		
	}
	
	public void showMessage() {
		
	}
	
	public void closeApp() {
		
	}


}
