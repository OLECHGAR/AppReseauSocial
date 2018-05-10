package application.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import de.jensd.fx.glyphs.fontawesome.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;


public class LoginController implements Initializable {

	@FXML
	private JFXTextField adresseIP;
	@FXML
	private JFXTextField port;
	@FXML 
	private JFXButton btn_connect;
	@FXML 
	private JFXButton btn_create;
	@FXML 
	private ChoiceBox list_users;
	@FXML 
	private FontAwesomeIconView btn_close;
	
 
	@FXML
	void createUser(ActionEvent evt) throws IOException  {
		Parent userCreation = FXMLLoader.load(getClass().getResource("/application/views/UserCreation.fxml"));
        Scene scene = new Scene(userCreation);
        Stage stage = (Stage) ((Node) evt.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show(); 
	}
	
	@FXML
	void close(MouseEvent event) {
		Node node = (Node) event.getSource();
		Stage stage = (Stage) node.getScene().getWindow();
		stage.close();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		System.out.println(this.adresseIP.getText());
	}
	
	public void submitPressed (MouseEvent event)
    {
		System.out.println(this.adresseIP.getText());
 
    }
}
