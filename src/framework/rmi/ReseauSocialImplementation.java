package framework.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import framework.utilisateur.$Utilisateur;

public class ReseauSocialImplementation extends UnicastRemoteObject implements ReseauSocial {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ArrayList<? extends $Utilisateur> listeUtilisateurs; // Liste des utilisateurs du réseau social

	protected ReseauSocialImplementation() throws RemoteException {
		super();
		this.listeUtilisateurs = new ArrayList<$Utilisateur>();
	}

	

}