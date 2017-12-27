import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Server extends JFrame {
	
	// For now, this Instant Messenger uses Swing for the GUI, mainly because it was quicker 
	// for me to implement and get the actual application up and running (and also because 
	// I'm still learning JavaFX!), but I will be moving over to 
	// JavaFX pretty soon :)
	private ObjectOutputStream outputStream;
	private ObjectInputStream inputStream;
	private JTextArea chatWindow;
	private JTextField messageText;
	private ServerSocket server;
	private Socket connection;
	
	public Server() {
		super("Java Instant Messenger :)");
		messageText = new JTextField();
		messageText.setEditable(false);

		messageText.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent event) {
						sendMessage(event.getActionCommand());
						messageText.setText("");
					}
				}					
			);
			add(messageText, BorderLayout.NORTH);
			chatWindow = new JTextArea();
			add(new JScrollPane(chatWindow));
			setSize(300, 150);
			setVisible(true);
	}
	
	// Set up and run the server application, so that it can continuously keep running
	public void runApplication() {
		try {
			server = new ServerSocket(6789, 100);
			while(true) {
				try {
					waitForConnection();
					setUpStreams();
					whileChatting();
					
				}catch(EOFException eofException) {
					showMessage("\n Server ended the connection");
				}finally {
					closeApp();
				}
			}
		}catch(IOException ioException) {
			ioException.printStackTrace();
		}
	}
	
	// Wait for connection, then display connection information
	private void waitForConnection() throws IOException{
		
		showMessage("Waiting for someone to connect...\n");
		connection = server.accept();
		showMessage("Now connected to " + connection.getInetAddress().getHostName());
	}
	
	// Get stream to send and receive data 
	private void setUpStreams() throws IOException{
		outputStream = new ObjectOutputStream(connection.getOutputStream());
		outputStream.flush();
		inputStream = new ObjectInputStream(connection.getInputStream());
		showMessage("\n The streams are now setup! \n");
	}
	
	// Called so that the conversation can take place
	private void whileChatting() throws IOException{
		String message = "You are now connected!";
		sendMessage(message);
		allowedToType(true);
		do {
			try {
				message = (String) inputStream.readObject();
				showMessage("\n" + message);
				
			}catch(ClassNotFoundException classNotFoundException) {
				showMessage("\n Message could not be sent ");
			}
		}while(!message.equals("CLIENT: END"));
	}
	
	// This closes all connections and streams after done chatting
	private void closeApp() {
		showMessage("\n Closing connections... \n");
		allowedToType(false);
		try {
			outputStream.close();
			inputStream.close();
			connection.close();
		}catch(IOException ioException) {
			ioException.printStackTrace();	
		}
	}
	
	// Updates the messages in the Chat Window
	private void showMessage(final String text) {
		SwingUtilities.invokeLater(
			new Runnable() {
				public void run() {
					chatWindow.append(text);
				}
			}
		);
		
	}
	
	// Send a message to client 
	private void sendMessage(String message) {
		try {
			outputStream.writeObject("SERVER: " + message);
			outputStream.flush();
			showMessage("\n SERVER: " + message);
		}catch(IOException ioException) {
			chatWindow.append("\n ERROR: CANNOT SEND MESSAGE");
		}
	}

	// Let the user type stuff into their box
	private void allowedToType(final boolean tof) {
		SwingUtilities.invokeLater(
			new Runnable() {
				public void run() {
					messageText.setEditable(tof);
				}
			}
		);
	}
}