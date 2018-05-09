package application;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import framework.rmi.ReseauSocial;

public class demo9Share {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ReseauSocial reseauSocial = null; //REPRESENTE L'OBJET QU'ON VA RECUPERER DU SERVEUR
		try {
			reseauSocial = (ReseauSocial) Naming.lookup("reseau");
		} catch (NotBoundException e) {
			System.err.println("NotBoundException");
		} catch (MalformedURLException e) {
			System.err.println("MalformedURLException");
		} catch (RemoteException e) {
			System.err.println("RemoteException");
		}
		
		//LANCER L'IHM
		
		// CONNEXION
		//
		

	}

}