package application.serveur;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.sql.SQLException;

/**
 * Serveur
 * 
 * @author monbeigj
 *
 */
public class Serveur {

    public static void main(String[] args) throws RemoteException,
	    MalformedURLException, SQLException, UnknownHostException {

	int port = 1099;
	String localHost = InetAddress.getLocalHost().getHostAddress();
	System.setProperty("java.rmi.server.hostname", localHost);
	Registry rmi = LocateRegistry.createRegistry(port);
	/** args corespond au chemin d'acc�s de la base de donn�e **/
	ReseauSocialImplementation reseau = new ReseauSocialImplementation(
		args[0]);
	/** ON REND DISPONIBLE L'OBJET A DISTANCE **/
	rmi.rebind("reseau", reseau);
	System.out.println("Le serveur est lanc� sur l'adresse locale : "
		+ localHost);
	System.out.println("et sur le port : " + port);
    }
}