package application.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class UserCreationController implements Initializable {

	@FXML 
	private JFXButton btn_connect;
	@FXML 
	private FontAwesomeIconView btn_close;
	@FXML
	void create(ActionEvent event) throws IOException  {
		Parent home_page_parent = FXMLLoader.load(getClass().getResource("/application/views/Login.fxml"));
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
	
	@Override public void initialize(URL url, ResourceBundle rb) {
		// initialize
	}
	
}