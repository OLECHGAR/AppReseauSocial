package application.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ListView;
import de.jensd.fx.glyphs.fontawesome.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.File;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.ResourceBundle;


public class ChatController implements Initializable {

	@FXML
	private FontAwesomeIconView btn_close;
	@FXML
	private FontAwesomeIconView btnjoindre;
	@FXML private ListView<String> list;

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
	
	/*
	@FXML
	public SalonDiscussion getSalon() {
        try {
            return null
        } catch (RemoteException ex) {
            close(null);
            return null;
        }
    }
	
	@FXML
	public MessagePrive getMsg() {
        try {
            return getMsg().getDestinataire(u)
        } catch (RemoteException ex) {
            close(null);
            return null;
        }
    }
	*/
	
	@FXML
	void close(MouseEvent event) {
		Node node = (Node) event.getSource();
		Stage stage = (Stage) node.getScene().getWindow();
		stage.close();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}
}
