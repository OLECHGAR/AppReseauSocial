package application.serveur;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import application.Utilisateur;

public class ReseauSocialImplementation extends UnicastRemoteObject implements
	ReseauSocial {

    private static final long serialVersionUID = 1L;

    private final String PATH_BASE_DE_DONNEES;

    private Connection connection;

    // Liste des utilisateurs du réseau social
    private ArrayList<Utilisateur> listeUtilisateurs;

    protected ReseauSocialImplementation(String args) throws RemoteException {
	this.PATH_BASE_DE_DONNEES = "jdbc:sqlite:" + args;
	this.listeUtilisateurs = new ArrayList<Utilisateur>();

	try {
	    this.connection = DriverManager
		    .getConnection(this.PATH_BASE_DE_DONNEES);
	    try {
		Class.forName("org.sqlite.JDBC");
	    } catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }
	    String sql4 = "SELECT * FROM utilisateur";
	    PreparedStatement statement4 = this.connection
		    .prepareStatement(sql4);
	    ResultSet res4 = statement4.executeQuery();

	    while (res4.next()) {
		this.listeUtilisateurs.add(new Utilisateur(res4.getString(1),
			res4.getString(2), res4.getString(3),
			res4.getString(4), res4.getString(5),
			res4.getString(6), res4.getString(7), this.connection));
	    }
	    this.connection.close();
	} catch (SQLException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

	Iterator<Utilisateur> it = this.listeUtilisateurs.iterator();
	while (it.hasNext()) {
	    Utilisateur u = it.next();
	    System.out.println("Login : " + u.getLogin() + " ; " + " Nom : "
		    + u.getNom() + " ; " + " Prenom : " + u.getPrenom() + " ; "
		    + " Adresse : " + u.getAdresse() + " ; "
		    + " DateNaissance : " + u.getDateNaissance() + " ; "
		    + " Mail : " + u.getMail());
	}
	try {
	    this.connection.close();
	} catch (SQLException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

    }

    @Override
    public boolean ajoutUtilisateur(String login, String mdp, String nom,
	    String prenom, String adresse, String mail, String dateNaissance)
	    throws SQLException {
	// TODO change date String to Date

	try {
	    Class.forName("org.sqlite.JDBC");
	} catch (ClassNotFoundException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	PreparedStatement statement1 = this.connection
		.prepareStatement("select * from utilisateur where login= ?");
	statement1.setString(1, login);
	ResultSet result = statement1.executeQuery();
	if (result.next()) {
	    /* TODO ajouter un message box : compte deja pri */
	    return false;
	} else {
	    String sql = "INSERT INTO utilisateur (login,motDePasse,nom,prenom,adresse,mail,dateNaissance)"
		    + "VALUES (?,?,?,?,?,?,?)";
	    PreparedStatement statement = this.connection.prepareStatement(sql);
	    statement.setString(1, login);
	    statement.setString(2, mdp);
	    statement.setString(3, nom);
	    statement.setString(4, prenom);
	    statement.setString(5, adresse);
	    statement.setString(6, mail);
	    statement.setString(7, dateNaissance.toString());
	    statement.executeUpdate();

	    /* TODO ajouter un message box : inscription ok */
	    return true;
	}
    }

    @Override
    public Utilisateur login(String login, String motdepasse)
	    throws SQLException {
	try {
	    Class.forName("org.sqlite.JDBC");
	} catch (ClassNotFoundException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

	PreparedStatement statement = this.connection
		.prepareStatement("select * from utilisateur where login = '"
			+ login + "'" + " and motDePasse= '" + motdepasse + "'");
	ResultSet res = statement.executeQuery();

	if (res.next()) {
	    return new Utilisateur(res.getString(1), res.getString(2),
		    res.getString(3), res.getString(4), res.getString(5),
		    res.getString(6), res.getString(7));
	} else {
	    return null;
	}
    }

    @Override
    public void closeConnection() throws SQLException {
	this.connection.close();
    }

    @Override
    public void openConnection() throws SQLException {
	this.connection = DriverManager
		.getConnection(this.PATH_BASE_DE_DONNEES);

    }

}