package application.serveur;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

import application.Utilisateur;

public interface ReseauSocial extends Remote {
	
	public Utilisateur login(String login, String motdepasse) throws SQLException, RemoteException;
	
	public boolean ajoutUtilisateur(String login, String mdp, String nom, String prenom, String adresse, String mail,String dateNaissance) throws SQLException, RemoteException;
	
	public void closeConnection() throws SQLException, RemoteException;
	
	public void openConnection() throws SQLException, RemoteException;
	
	public Utilisateur getUser(String login) throws SQLException, RemoteException;
	
	public boolean ajoutSalonDiscussion(String nom, boolean privacy, ArrayList<Utilisateur> utilisateurs,Utilisateur proprietaire) throws SQLException, RemoteException;
	
	
}
