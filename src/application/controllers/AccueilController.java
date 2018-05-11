package application.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import com.jfoenix.controls.JFXTextField;

import application.Utilisateur;
import application.serveur.ReseauSocial;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

public class AccueilController implements Initializable{

	@FXML private JFXTextField rechercher_amis;
	@FXML private FontAwesomeIconView btn_close;
	@FXML
	private Label nom;
	@FXML
	private Label prenom;
	@FXML
	private Label mail;
	@FXML
	private Label adresse;
	@FXML
	private Label dateDeNaissance;
	
	private Utilisateur user;
	private ReseauSocial reseauSocial;
	
	@FXML 
	 void chat(MouseEvent event)throws IOException{
		
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
	 void deconnexion(MouseEvent event)throws IOException{
		
	Alert alert = new Alert(AlertType.CONFIRMATION);
	alert.setTitle("Deconnexion");
	alert.setContentText("Voulez-vous vraiment vous déconnecter ?");

	Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == ButtonType.OK)
		{
			 Parent home_page_parent = FXMLLoader.load(getClass().getResource("/application/views/Login.fxml"));
		     Scene home_page_scene = new Scene(home_page_parent);
		     Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		     app_stage.setScene(home_page_scene);
		     app_stage.show();
		}
	}
	
	@FXML 
	 void AjouterZone(MouseEvent event)throws IOException{
	 Parent home_page_parent = FXMLLoader.load(getClass().getResource("/application/views/AjoutZone.fxml"));
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
	public void initialize(URL arg0, ResourceBundle arg1) {
	
	}

	public void setObjects(ReseauSocial reseauSocial, Utilisateur user) {
		System.out.println("ACCUEILCONTROLLER : "+user.toString());
		this.user = user;
		this.reseauSocial = reseauSocial;
		
		nom.setText(user.getNom());
		prenom.setText(user.getPrenom());
		mail.setText(user.getMail());
		adresse.setText(user.getAdresse());
		dateDeNaissance.setText(user.getDateNaissance());
	}
	

}