package client;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	
	private String serverIP;
	private ServerSocket server;
	private Socket connection;
	private ObjectOutputStream outputStream;
	private ObjectInputStream inputStream;
	
	public Server(String host) {
		serverIP = host;
	}
	
	public void startServer() throws EOFException, IOException{
		while(true){
			try {
			System.out.println("SERVER: Starting the application now . . .");
			server = new ServerSocket(6789, 100);
			waitForConnection();
			setUpStreams();
			whileChatting();
			
			}finally {
				closeServer();
			}
		}
			
	}
	
	public void waitForConnection() {
		System.out.println("SERVER: Opening the server for possible connections...");
		try {
			connection = server.accept();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	public void setUpStreams() {
		System.out.println("SERVER: Setting up streams for the server...");
	}
	
	public void whileChatting() {
		System.out.println("SERVER: Starting the whileChatting method ...");
	}
	
	public void closeServer() {
		System.out.println("SERVER: Closing the server...");
		try {
			inputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			outputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			server.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
