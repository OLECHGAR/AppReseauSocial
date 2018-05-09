package framework.rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;

public class Serveur {

	public static void main(String[] args) throws RemoteException, MalformedURLException {
		
		ReseauSocialImplementation reseau = new ReseauSocialImplementation();
		
		// FAIRE LA CONNEXION A LA BASE DE DONNÉES ICI
		// REMPLIR L'OBJET "reseau"
		
		Naming.rebind("reseau", reseau); // ON MET A DISPOSITION CET OBJET A DISTANCE VIA RMI
	}

}