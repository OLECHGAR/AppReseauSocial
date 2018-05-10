package application.controllers;

import java.io.IOException;
import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import application.serveur.ReseauSocial;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

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
	
	public ReseauSocial reseauSocial = null; //REPRESENTE L'OBJET QU'ON VA RECUPERER DU SERVEUR
	
	@FXML
	void create(ActionEvent event) throws IOException, SQLException  {
		
		try {
			Registry rmi = LocateRegistry.getRegistry(hostname.getText(), Integer.parseInt(port.getText()));
			reseauSocial = (ReseauSocial) rmi.lookup("reseau");
		} catch (NotBoundException e) {
			System.err.println("NotBoundException");
		} catch (RemoteException e) {
			System.err.println("RemoteException");
		}
		System.out.println("coucou");
		
		reseauSocial.openConnection();
		reseauSocial.ajoutUtilisateur(login_u.getText(),  password_u.getText(),  name_u.getText(),  firstname_u.getText(),  address_u.getText(),  mail_u.getText(), birthdate_u.getText());
		reseauSocial.closeConnection();
		
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