package application.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import de.jensd.fx.glyphs.fontawesome.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;


public class LoginController implements Initializable {

	@FXML
	private TextField adresseIP;
	@FXML
	private TextField port;
	
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
