package application.controllers;

import java.io.IOException;
import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import application.serveur.ReseauSocial;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;

public class UserCreationController implements Initializable {

    @FXML
    private JFXTextField hostname;
    @FXML
    private JFXTextField port;
    @FXML
    private JFXButton btn_create;
    @FXML
    private FontAwesomeIconView btn_close;
    @FXML
    private JFXTextField firstname_u;
    @FXML
    private JFXTextField name_u;
    @FXML
    private JFXTextField address_u;
    @FXML
    private JFXTextField birthdate_u;
    @FXML
    private JFXTextField mail_u;
    @FXML
    private JFXTextField login_u;
    @FXML
    private JFXPasswordField password_u;

    public ReseauSocial reseauSocial = null; // REPRESENTE L'OBJET QU'ON VA
					     // RECUPERER DU SERVEUR

    @FXML
    void create(ActionEvent event) throws IOException, SQLException {

	try {
	    Registry rmi = LocateRegistry.getRegistry(this.hostname.getText(),
		    Integer.parseInt(this.port.getText()));
	    this.reseauSocial = (ReseauSocial) rmi.lookup("reseau");
	} catch (NotBoundException e) {
	    System.err.println("NotBoundException");
	} catch (RemoteException e) {
	    System.err.println("RemoteException");
	}
	System.out.println("coucou");

	this.reseauSocial.openConnection();
	this.reseauSocial.ajoutUtilisateur(this.login_u.getText(),
		this.password_u.getText(), this.name_u.getText(),
		this.firstname_u.getText(), this.address_u.getText(),
		this.mail_u.getText(), this.birthdate_u.getText());
	this.reseauSocial.closeConnection();

	this.changeView((Stage) ((Node) event.getSource()).getScene()
		.getWindow(), "/application/views/Login.fxml");
    }

    @FXML
    void close(MouseEvent event) {
	Node node = (Node) event.getSource();
	Stage stage = (Stage) node.getScene().getWindow();
	stage.close();
    }

    @FXML
    void back(MouseEvent event) throws IOException {
	this.changeView((Stage) ((Node) event.getSource()).getScene()
		.getWindow(), "/application/views/Login.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
	// initialize
    }

    private void changeView(Stage app_stage, String path) throws IOException {
	Parent home_page_parent = FXMLLoader.load(this.getClass().getResource(
		path));
	Scene home_page_scene = new Scene(home_page_parent);
	app_stage.setScene(home_page_scene);
	app_stage.show();
    }

}