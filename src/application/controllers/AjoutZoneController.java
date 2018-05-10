package application.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXTextField;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class AjoutZoneController implements Initializable {

	@FXML private AnchorPane an_menu;
	
	private JFXTextField namezone;
	private JFXTextField listUsers;
	
	@FXML
	void AjouterZone(MouseEvent event) throws IOException  {
		
		//TODO Liste D'utilisateur
		//user.creerZone(new Zone());
		Parent home_page_parent = FXMLLoader.load(getClass().getResource("/application/views/Chat.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home_page_scene);
        app_stage.show(); 
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}