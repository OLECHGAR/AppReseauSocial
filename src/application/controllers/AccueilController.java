package application.controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import application.Utilisateur;
import application.serveur.ReseauSocial;

import com.jfoenix.controls.JFXTextField;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;

/**
 * 
 * @author monbeigj
 *
 */
public class AccueilController implements Initializable {

    @FXML
    private JFXTextField rechercher_amis;
    @FXML
    private FontAwesomeIconView btn_close;
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

    /**
     * Permet d'afficher la vue chat
     * 
     * @param event
     * @throws IOException
     * @throws SQLException
     */
    @FXML
    void chat(MouseEvent event) throws IOException, SQLException {

	FXMLLoader Loader = new FXMLLoader();
	Loader.setLocation(this.getClass().getResource(
		"/application/views/Chat.fxml"));
	Loader.load();

	ChatController controller = Loader.getController();
	controller.setObjects(this.reseauSocial, this.user);

	Parent home_page_parent = Loader.getRoot();
	Scene home_page_scene = new Scene(home_page_parent);
	Stage app_stage = (Stage) ((Node) event.getSource()).getScene()
		.getWindow();
	app_stage.setScene(home_page_scene);
	app_stage.show();
    }

    /**
     * Permet à l'utilisateur de se déconecter.
     * 
     * @param event
     * @throws IOException
     */
    @FXML
    void deconnexion(MouseEvent event) throws IOException {

	Alert alert = new Alert(AlertType.CONFIRMATION);
	alert.setTitle("Deconnexion");
	alert.setContentText("Voulez-vous vraiment vous déconnecter ?");

	Optional<ButtonType> result = alert.showAndWait();
	if (result.get() == ButtonType.OK) {
	    Parent home_page_parent = FXMLLoader.load(this.getClass()
		    .getResource("/application/views/Login.fxml"));
	    Scene home_page_scene = new Scene(home_page_parent);
	    Stage app_stage = (Stage) ((Node) event.getSource()).getScene()
		    .getWindow();
	    app_stage.setScene(home_page_scene);
	    app_stage.show();
	}
    }

    /**
     * Permet à l'utilisateur d'ajouter une zone de discution ou autre.
     * 
     * @param event
     * @throws IOException
     */
    @FXML
    void AjouterZone(MouseEvent event) throws IOException {

	FXMLLoader Loader = new FXMLLoader();
	Loader.setLocation(this.getClass().getResource(
		"/application/views/AjoutZone.fxml"));
	Loader.load();

	AjoutZoneController controller = Loader.getController();
	controller.setObjects(this.reseauSocial, this.user);

	Parent home_page_parent = Loader.getRoot();
	Scene home_page_scene = new Scene(home_page_parent);
	Stage app_stage = (Stage) ((Node) event.getSource()).getScene()
		.getWindow();
	app_stage.setScene(home_page_scene);
	app_stage.show();
    }

    /**
     * Permet à l'utilisateur de fermer la vue.
     * 
     * @param event
     */
    @FXML
    void close(MouseEvent event) {
	Node node = (Node) event.getSource();
	Stage stage = (Stage) node.getScene().getWindow();
	stage.close();
    }

    /**
     * Permet d'initialiser la vue.
     * 
     * @param arg0
     * @param arg1
     */
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

    }

    /**
     * Permet de modifier la vue.
     * 
     * @param reseauSocial
     * @param user
     */
    public void setObjects(ReseauSocial reseauSocial, Utilisateur user) {
	this.user = user;
	this.reseauSocial = reseauSocial;

	this.nom.setText(user.getNom());
	this.prenom.setText(user.getPrenom());
	this.mail.setText(user.getMail());
	this.adresse.setText(user.getAdresse());
	this.dateDeNaissance.setText(user.getDateNaissance());
    }

}