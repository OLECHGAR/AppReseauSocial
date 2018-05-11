package application.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ChoiceBox;
import de.jensd.fx.glyphs.fontawesome.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

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

import application.Utilisateur;
import application.serveur.ReseauSocial;

public class LoginController implements Initializable {

	@FXML
	private JFXTextField adresseIP;
	@FXML
	private JFXTextField port;
	@FXML
	private JFXTextField username;
	@FXML
	private JFXPasswordField password;
	@FXML
	private JFXButton btn_connect;
	@FXML
	private JFXButton btn_create;
	@FXML
	private ChoiceBox list_users;
	@FXML
	private FontAwesomeIconView btn_close;
	
	public ReseauSocial reseauSocial = null; //REPRESENTE L'OBJET QU'ON VA RECUPERER DU SERVEUR

	@FXML
	void userCreation(MouseEvent event) throws IOException {
		Parent home_page_parent = FXMLLoader.load(getClass().getResource("/application/views/UserCreation.fxml"));
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

	public void connectToServer(MouseEvent event) throws IOException, SQLException {
		
		try {
			Registry rmi = LocateRegistry.getRegistry(adresseIP.getText(), Integer.parseInt(port.getText()));
			reseauSocial = (ReseauSocial) rmi.lookup("reseau");
		} catch (NotBoundException e) {
			System.err.println("NotBoundException");
		} catch (RemoteException e) {
			System.err.println("RemoteException");
		}
		System.out.println("coucou");
		
		reseauSocial.openConnection();
		Utilisateur user = reseauSocial.login(this.username.getText(), this.password.getText());
		
		reseauSocial.closeConnection();
		
		if(user != null)
		{
			FXMLLoader Loader = new FXMLLoader();
			Loader.setLocation(getClass().getResource("/application/views/Chat.fxml"));
			Loader.load();
			
			System.out.println("LOGIN : "+user.toString());
			ChatController controller = Loader.getController();
			controller.setObjects(reseauSocial, user);
			
			Parent home_page_parent = Loader.getRoot();
			Scene home_page_scene = new Scene(home_page_parent);
			Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			app_stage.setScene(home_page_scene);
			app_stage.show();
		}
		else
		{
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Erreur de connexion");
			alert.setHeaderText("Combinaison login/mot de passe incorrecte");
			alert.showAndWait();
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		System.out.println(this.adresseIP.getText());
	}

}
