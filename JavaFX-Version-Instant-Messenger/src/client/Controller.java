package client;

import java.io.EOFException;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {
	private String message;
	private Socket connection;
	private String serverIP;
	private String userName;

	@FXML
	private TextField messageTextField;
	
	@FXML
	private Button sendButton;
	
	@FXML
	private Button connectButton;
	
	@FXML 
	private TextField userNameField;
	
	
	@FXML
	public void onButtonClicked(ActionEvent e) {
		if(e.getSource().equals(sendButton)) {
			message = messageTextField.getText();
			System.out.println(message);
		}
		if(e.getSource().equals(connectButton)) {
			
		}
	}
	
	@FXML
	public void onConnectButtonClicked(ActionEvent event) {
		if(event.getSource().equals(connectButton)) {
			userName = userNameField.getText();
			System.out.println("Connected as: " + userName);
			Client newClient;
			Server newServer;
			newClient = new Client("127.0.0.1");
			newClient.testMethod();
			newServer = new Server("127.0.0.1");
			try {
				newServer.startServer();
			} catch (EOFException e1) {
				System.out.println("Client terminated the connection :(");
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			try {
				newClient.startApp();
			} catch (IOException e) {
				System.out.println("Could not connect :(");
				e.printStackTrace();
			}
			
		}
	}
	
	@FXML
	private void allowedToType(final boolean tof) throws InterruptedException{
		Runnable task = new Runnable() {
			@Override
			public void run() {
				Platform.runLater(new Runnable() {
					@Override
					public void run() {
					messageTextField.setEditable(tof);

					}
				});
				
			}
		};
	}
	
}