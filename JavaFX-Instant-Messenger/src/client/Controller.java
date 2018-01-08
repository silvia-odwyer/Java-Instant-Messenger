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
	public Label consoleText;
	
	private String su1;
	private String su2;
	private String su3;
	private String currentLabelText;
	public String currentStatus;
	private String errorSU1;
	private String errorSU2;
	private String su4;
	private String su5;
	private String su6;
	private String su7;
	private String su8;
	private String su9;
	private String su10;
	private String su11;
	
	@FXML
	public void onButtonClicked(ActionEvent e) {
		if(e.getSource().equals(sendButton)) {
			message = messageTextField.getText();
			System.out.println(message);
		}
	}
	
	@FXML
	public void onConnectButtonClicked(ActionEvent event) {
		if(event.getSource().equals(connectButton)) {
			userName = userNameField.getText();
			currentLabelText = consoleText.getText();
			su1 = "\nConnected as: " + userName;
			currentStatus = currentLabelText + su1;
			System.out.println(currentStatus);
			consoleText.setText(currentStatus);
			


			Client newClient;
			Server newServer;
			//newClient = new Client("127.0.0.1");
			su2 = "\nNew client created!";
			currentStatus = currentStatus + su2;
			consoleText.setText(currentStatus);
//			newServer = new Server("127.0.0.1");
//			try {
//				newServer.startServer();
//			} catch (EOFException e1) {
//				System.out.println("Client terminated the connection :(");
//				e1.printStackTrace();
//			} catch (IOException e1) {
//				e1.printStackTrace();
//			}
			try {
				startApp();
			} catch (IOException e) {
				errorSU1 = "\n Could not connect :(";
				currentStatus = currentStatus + errorSU1;
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
	
	public void startApp() throws IOException {
		try {
			su3 = "\nCLIENT: Starting the application now . . .";
			currentStatus = currentStatus + su3;
			consoleText.setText(currentStatus);
			connectToServer();
			streamsAlert();
			whileChattingAlert();
			
		}catch(EOFException eofException) {
			errorSU2 = "\nCLIENT: The client terminated the connection . . . :(";
			currentStatus = currentStatus + errorSU2;
			consoleText.setText(currentStatus);

		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			closeApp();
		}
		
	}
	
	
	public void testMethod() {
		su4 = "\nCLIENT: The Client class is fully functioning and working :)";
		currentStatus = currentStatus + su4;
		consoleText.setText(currentStatus);
	}
	
	public void connectToServer() throws IOException {
		su5 = "\nCLIENT: The connectToServer method is working :)";
		currentStatus = currentStatus + su5;
		consoleText.setText(currentStatus);
		Client.connectionRequest();
		Client.setUpStreams();
	}
	
	
	private void streamsAlert() throws IOException{
		su6 = "\nCLIENT: Streams have been set up successfully! :D";
		currentStatus = currentStatus + su6;
		consoleText.setText(currentStatus);
	}
	
	public void whileChattingAlert() throws IOException {
		su7 = "\nCLIENT: Executing the start of the whileChatting method . . .";
		currentStatus = currentStatus + su7;
		consoleText.setText(currentStatus);
		
		Client.whileChatting();
		
		su8 = "\nCLIENT: Reached the end of the whileChatting method . . .";
		currentStatus = currentStatus + su8;
		consoleText.setText(currentStatus);
		
	}
	
	public void showMessage() {
		
		
	}
	
	
	
	public void closeApp() {
		su9 = "\nCLIENT: Closing Client-side app now . . .";
		currentStatus = currentStatus + su9;
		consoleText.setText(currentStatus);
//		try {
//			//inputStream.close();
//		} catch (IOException e) {
//			System.out.println("Couldn't close the input stream . . .");
//			e.printStackTrace();
//		}
//		try {
//			//outputStream.close();
//		} catch (IOException e) {
//			System.out.println("Couldn't close the output stream . . .");
//			e.printStackTrace();
//		}
//		
//		try {
//			connection.close();
//		} catch (IOException e) {
//			System.out.println("Couldn't close the socket connection . . .");
//			e.printStackTrace();
//		}
	}


	
}