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

import application.Utilisateur;


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
	void userCreation(MouseEvent event) throws IOException  {
		Parent home_page_parent = FXMLLoader.load(getClass().getResource("/application/views/UserCreation.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home_page_scene);
        app_stage.show(); 
	}
	
	@FXML
	void connect(MouseEvent event) throws IOException{
		Parent home_page_parent = FXMLLoader.load(getClass().getResource("/application/views/Chat.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home_page_scene);
        app_stage.show(); 
	}
	
	@FXML
	void close(MouseEvent event) {
		Node node = (Node) event.getSource();
		Stage stage = (Stage) node.getScene().getWindow();
		stage.close();
	}
	
	public void submitPressed (MouseEvent event)
    {
		System.out.println(this.adresseIP.getText());
 
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		System.out.println(this.adresseIP.getText());
	}
	
}
