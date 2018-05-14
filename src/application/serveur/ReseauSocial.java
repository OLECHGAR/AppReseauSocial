package application.serveur;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

import application.SalonDiscussion;
import application.Utilisateur;
import framework.transferable.Texte;

/**
 * @author monbeigj
 */
public interface ReseauSocial extends Remote {

    /**
     * Permet de se connecter.
     * 
     * @param login
     * @param motdepasse
     * @return
     * @throws SQLException
     * @throws RemoteException
     */
    public Utilisateur login(String login, String motdepasse)
	    throws SQLException, RemoteException;

    /**
     * Permet d'ajouter un utilisateur.
     * 
     * @param login
     * @param mdp
     * @param nom
     * @param prenom
     * @param adresse
     * @param mail
     * @param dateNaissance
     * @return
     * @throws SQLException
     * @throws RemoteException
     */
    public boolean ajoutUtilisateur(String login, String mdp, String nom,
	    String prenom, String adresse, String mail, String dateNaissance)
	    throws SQLException, RemoteException;

    /**
     * Permet de fermer la connection au serveur.
     * 
     * @throws SQLException
     * @throws RemoteException
     */
    public void closeConnection() throws SQLException, RemoteException;

    /**
     * Permet d'ouvir la connection au serveur.
     * 
     * @throws SQLException
     * @throws RemoteException
     */
    public void openConnection() throws SQLException, RemoteException;

    /**
     * Permet de récupérer l'utlisateur courant.
     * 
     * @param login
     * @return
     * @throws SQLException
     * @throws RemoteException
     */
    public Utilisateur getUser(String login) throws SQLException,
	    RemoteException;

    /**
     * Permet de créer des salon de discution.
     * 
     * @param nom
     * @param privacy
     * @param utilisateurs
     * @param proprietaire
     * @return
     * @throws SQLException
     * @throws RemoteException
     */
    public boolean ajoutSalonDiscussion(String nom, boolean privacy,
	    ArrayList<Utilisateur> utilisateurs, Utilisateur proprietaire)
	    throws SQLException, RemoteException;

    /**
     * Permet de voir tous les utilisateur du salon.
     * 
     * @param utilisateur
     * @return
     * @throws SQLException
     * @throws RemoteException
     */
    public ArrayList<SalonDiscussion> getAllUserSalonDiscussion2(
	    Utilisateur utilisateur) throws SQLException, RemoteException;

    /**
     * Permet de récupérer les messages du salon.
     * 
     * @param salon
     * @param utilisateur
     * @return
     * @throws SQLException
     * @throws RemoteException
     */
    public ArrayList<Texte<String>> getMessagesSalon(SalonDiscussion salon,
	    Utilisateur utilisateur) throws SQLException, RemoteException;

    /**
     * Permet d'envoyer des messages textuel sur le salon.
     * 
     * @param utilisateur
     * @param salon
     * @param contenu
     * @return
     * @throws SQLException
     * @throws RemoteException
     */
    public boolean envoyerMessage(Utilisateur utilisateur,
	    SalonDiscussion salon, String contenu) throws SQLException,
	    RemoteException;
}
