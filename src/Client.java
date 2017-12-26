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
	
	// Constructor
	public Client(String host) {
		super("Client Messaging Window");
		serverIP = host;
	}

}
