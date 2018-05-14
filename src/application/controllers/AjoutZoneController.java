package application.controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ListView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import application.Utilisateur;
import application.serveur.ReseauSocial;

import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;

/**
 * 
 * @author monbeigj
 *
 */
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
    private ObservableList<String> listUsersTemp = FXCollections
	    .observableArrayList();
    final ToggleGroup radioGroup = new ToggleGroup();

    /**
     * Permet à l'utilisateur d'ajouter une zone.
     * 
     * @param event
     * @throws IOException
     * @throws SQLException
     */
    @FXML
    void AjouterZone(MouseEvent event) throws IOException, SQLException {

	JFXRadioButton selected = (JFXRadioButton) this.radioGroup
		.getSelectedToggle();
	
	this.Users = new ArrayList<Utilisateur>();
	boolean privacy = false;
	if (selected.getText().equals("Public"))
	    privacy = true;

	this.reseauSocial.openConnection();
	for (int index = 0; index < this.listUsers.getItems().size(); index++) {
	    this.Users.add(this.reseauSocial.getUser(this.listUsers.getItems()
		    .get(index)));
	}

	if (!(this.reseauSocial.ajoutSalonDiscussion(this.namezone.getText(),
		privacy, this.Users, this.user)))
	    System.out.println("RATÉ");
	this.reseauSocial.closeConnection();

	Alert alert = new Alert(AlertType.INFORMATION);
	alert.setTitle("Validation");
	alert.setHeaderText("Room successfully created");
	alert.showAndWait();

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
     * Permet à l'utilisateur d'ajouter un utilisateur à la zone.
     * 
     * @param event
     */
    @FXML
    void AjouterUtilisateur(MouseEvent event) {
	// System.out.println(search_user.getText());
	this.listUsersTemp.add(this.search_user.getText());
	this.listUsers.setItems(this.listUsersTemp);
	this.search_user.setText("");
    }

    /**
     * Permet à l'utilisateur de fermer la vue.
     * 
     * @param event
     */
    @FXML
    void close(MouseEvent event) throws IOException, SQLException {
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
     * Permet d'initialiser la vue.
     * 
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
	// TODO Auto-generated method stub
	this.private_zone.setToggleGroup(this.radioGroup);
	this.public_zone.setToggleGroup(this.radioGroup);

    }

    /**
     * Permet à l'utilisateur de modifier la vue.
     * 
     * @param reseauSocial
     * @param user
     */
    public void setObjects(ReseauSocial reseauSocial, Utilisateur user) {
	this.reseauSocial = reseauSocial;
	this.user = user;
    }

}