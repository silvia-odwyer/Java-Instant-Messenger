package application;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {
	private String message;
	@FXML
	private TextField messageTextField;
	
	@FXML
	private Button sendButton;
	
	@FXML
	public void onButtonClicked(ActionEvent e) {
		if(e.getSource().equals(sendButton)) {
			message = messageTextField.getText();
			System.out.println(message);
		}
	}
	

	}