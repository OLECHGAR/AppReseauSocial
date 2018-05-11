package application.controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;

import application.Utilisateur;
import application.serveur.ReseauSocial;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.*;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ListView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class AjoutZoneController implements Initializable {

	@FXML 
	private AnchorPane an_menu;
	@FXML
	private JFXTextField namezone;
	@FXML
	private JFXTextField search_user;
	@FXML
	private ListView<String> listUsers;
	@FXML
	private JFXRadioButton private_zone;
	@FXML
	private JFXRadioButton public_zone;
	@FXML
	private FontAwesomeIconView btn_close;
	
	private Utilisateur user;
	private ReseauSocial reseauSocial;
	private ArrayList<Utilisateur> Users;
	private ObservableList<String> items = FXCollections.observableArrayList();
	final ToggleGroup radioGroup = new ToggleGroup();
	
	@FXML
	void AjouterZone(MouseEvent event) throws IOException, SQLException  {
		
		JFXRadioButton selected = (JFXRadioButton) radioGroup.getSelectedToggle();
		System.out.println(selected.getText());
		
		Users = new ArrayList<Utilisateur>();
		boolean privacy = false;
		if (selected.getText().equals("Public")) privacy = true; 
		
		reseauSocial.openConnection();
		System.out.println("hello");
		for(int index=0 ; index < listUsers.getItems().size(); index++)
		{
			Users.add(reseauSocial.getUser(listUsers.getItems().get(index)));
		}
		
		System.out.println("hello");
		
		if(!(reseauSocial.ajoutSalonDiscussion(namezone.getText(), privacy, Users, user)))
				System.out.println("RATÉ");
		System.out.println("hello");
		reseauSocial.closeConnection();
		
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Validation");
		alert.setHeaderText("Room successfully created");
		alert.showAndWait();
		
        FXMLLoader Loader = new FXMLLoader();
		Loader.setLocation(getClass().getResource("/application/views/Chat.fxml"));
		Loader.load();
		
		ChatController controller = Loader.getController();
		controller.setObjects(reseauSocial, user);
		
		Parent home_page_parent = Loader.getRoot();
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home_page_scene);
        app_stage.show(); 
	}
	
	@FXML
	void AjouterUtilisateur(MouseEvent event) 
	{
		//System.out.println(search_user.getText());
		items.add(search_user.getText());
		listUsers.setItems(items);
		search_user.setText("");
	}
	
	@FXML
	void close(MouseEvent event) throws IOException, SQLException {
		Node node = (Node) event.getSource();
		Stage stage = (Stage) node.getScene().getWindow();
		stage.close();
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		private_zone.setToggleGroup(radioGroup);
        public_zone.setToggleGroup(radioGroup);
        
	}
	
	public void setObjects(ReseauSocial reseauSocial, Utilisateur user) {
		this.reseauSocial = reseauSocial;
		this.user = user;		
	}

}