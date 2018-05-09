package application;
	
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import application.serveur.ReseauSocial;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;


public class demo9share extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/application/views/Login.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.initStyle(StageStyle.TRANSPARENT);
			primaryStage.initStyle(StageStyle.UNDECORATED);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		launch(args);
			
		ReseauSocial reseauSocial = null; //REPRESENTE L'OBJET QU'ON VA RECUPERER DU SERVEUR
		try {
			Registry rmi = LocateRegistry.getRegistry("129.88.153.41", 1099);
			reseauSocial = (ReseauSocial) rmi.lookup("reseau");
		} catch (NotBoundException e) {
			System.err.println("NotBoundException");
		} catch (RemoteException e) {
			System.err.println("RemoteException");
		}
		
		
		
		//LANCER L'IHM
		
		// CONNEXION
		//
	}
}
