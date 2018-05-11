package application.serveur;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.sql.SQLException;

public class Serveur {

    public static void main(String[] args) throws RemoteException,
	    MalformedURLException, SQLException, UnknownHostException {

	int port = 1099;
	String localHost = InetAddress.getLocalHost().getHostAddress();
	System.setProperty("java.rmi.server.hostname", localHost);
	Registry rmi = LocateRegistry.createRegistry(port);
	// args corespond au chemin d'accès de la base de donnée
	ReseauSocialImplementation reseau = new ReseauSocialImplementation(
		args[1]);
	rmi.rebind("reseau", reseau); // ON REND DISPONIBLE L'OBJET A DISTANCE
	System.out.println("Le serveur est lancï¿½ sur l'adresse locale : "
		+ localHost);
	System.out.println("et sur le port : " + port);
    }
}