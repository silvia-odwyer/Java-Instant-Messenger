import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;
import javax.swing.*;

public class Client extends JFrame {
	private JTextField messageText;
	private JTextArea chatWindow;
	private String message = "";
	private String serverIP;
	private ObjectOutputStream outputStream;
	private ObjectInputStream inputStream;
	private Socket connection;
	
	public Client(String host) {
		super("Client Messaging Window");
		serverIP = host;
		messageText = new JTextField();
		messageText.setEditable(false);
		messageText.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent event) {
					sendMessageToServer(event.getActionCommand());
					messageText.setText("");
				}
			}
		);
		add(messageText, BorderLayout.NORTH);
		chatWindow = new JTextArea();
		add(new JScrollPane(chatWindow), BorderLayout.CENTER);
		setSize(300, 150);
		setVisible(true);
	
	}
	
	// Starts the client app, so that it can get running
	public void startClientApp() {
		try {
			connectToServer();
			setUpStreams();
			whileChatting();
			
		}catch(EOFException eofExxception) {
			showMessage("\n Client terminated the connection :(");
		}catch(IOException ioException) {
			ioException.printStackTrace();
		}finally {
			closeApp();
		}
	}
	
	// Creates a connection to the server and displays whether successful or not 
	
	private void connectToServer() throws IOException{
		showMessage("Attempting connection... \n");
		
		// !!!The Port Number below must be changed when this app runs on the server
		connection = new Socket(InetAddress.getByName(serverIP), 6789);
		showMessage("Connected to:" + connection.getInetAddress().getHostName());
	}
	
	
	// Sets up the streams so that all messages can be received and sent
	private void setUpStreams() throws IOException{
		outputStream = new ObjectOutputStream(connection.getOutputStream());
		outputStream.flush();
		
		inputStream = new ObjectInputStream(connection.getInputStream());
		showMessage("\n Streams are now set up! :D");
		
	}
	

}