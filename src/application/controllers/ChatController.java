package application.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import de.jensd.fx.glyphs.fontawesome.*;
import framework.zonesPartages.ZonePartageSimple;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ResourceBundle;

import application.SalonDiscussion;
import application.Utilisateur;
import application.serveur.ReseauSocial;


public class ChatController implements Initializable {

	@FXML
	private FontAwesomeIconView btn_close;
	@FXML
	private FontAwesomeIconView btnjoindre;
	@FXML
	private FontAwesomeIconView btn_add_room;
	@FXML 
	private ListView<String> list;
	@FXML
	private ListView<SalonDiscussion> chat_rooms;
	
	private Utilisateur user;
	private ObservableList<SalonDiscussion> allSalon = FXCollections.observableArrayList();
	private ReseauSocial reseauSocial;
	
	@FXML 
	private void multipleChooser(MouseEvent ae){
		FileChooser fc = new FileChooser();
	    File SelectedFile = fc.showOpenDialog(null);
	    
	    if(SelectedFile != null)
		    {
		    	list.getItems().add(SelectedFile.getName());
		    }
	    else 
		    {
		    	System.out.println("Fichier non valide");
		    }
  
	}
	
	@FXML
	void AjoutZone(MouseEvent event) throws IOException  {
        FXMLLoader Loader = new FXMLLoader();
		Loader.setLocation(getClass().getResource("/application/views/AjoutZone.fxml"));
		Loader.load();
		
		AjoutZoneController controller = Loader.getController();
		controller.setObjects(reseauSocial, user);
		
		Parent home_page_parent = Loader.getRoot();
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home_page_scene);
        app_stage.show(); 
	}
	
	@FXML
	void homepage(MouseEvent event) throws IOException  {
		FXMLLoader Loader = new FXMLLoader();
		Loader.setLocation(getClass().getResource("/application/views/Accueil.fxml"));
		Loader.load();
		
		AccueilController controller = Loader.getController();
		controller.setObjects(reseauSocial, user);
		
		Parent home_page_parent = Loader.getRoot();
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

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

	public void setObjects(ReseauSocial reseauSocial, Utilisateur user) throws RemoteException, SQLException {
		System.out.println("CHATCONTROLLER : "+user.toString());
		this.reseauSocial = reseauSocial;
		this.user = user;		
	}
	
	public void refreshRooms() throws RemoteException, SQLException
	{
		System.out.println("hello");
		reseauSocial.openConnection();
		reseauSocial.getAllUserSalonDiscussion(user);
		
		System.out.println((user.getZonesCrees().size()));
		allSalon.addAll(user.getZonesCrees());
		
		System.out.println(user.getZonesInteractions().size());
		allSalon.addAll(user.getZonesInteractions());
		
		System.out.println(allSalon.size());
		chat_rooms.setItems(allSalon);
		reseauSocial.closeConnection();
	}
}
