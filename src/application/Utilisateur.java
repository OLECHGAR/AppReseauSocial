package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;

import framework.exception.NotNullException;
import framework.utilisateur.$Utilisateur;

/**
 * 
 * @author monbeigj
 *
 */
public class Utilisateur extends $Utilisateur<SalonDiscussion> implements
	java.io.Serializable {

    private static final long serialVersionUID = 1L;
    private String login;
    private String motDePasse;
    private String nom;
    private String prenom;
    private String adresse;
    private String mail;
    // TODO change date String to Date
    private String dateNaissance;
    private ArrayList<Utilisateur> relations = new ArrayList<Utilisateur>();

    /**
     * Collection d'entier contenant les r�f�rences des zones abonn�es par
     * l'utilisateur
     */
    protected HashSet<Integer> zonesAbonement = new HashSet<Integer>();

    /**
     * The constructor.
     * 
     * @param login
     * @param mdp
     * @param nom
     * @param prenom
     * @param adresse
     * @param mail
     * @param dateNaissance
     * @throws SQLException
     */
    public Utilisateur(String login, String mdp, String nom, String prenom,
	    String adresse, String mail, String dateNaissance, Connection con)
	    throws SQLException {
	// TODO change date String to Date
	super();
	this.login = login;
	this.motDePasse = mdp;
	this.prenom = prenom;
	this.nom = nom;
	this.adresse = adresse;
	this.mail = mail;
	this.dateNaissance = dateNaissance;

	// Connection con = DriverManager
	// .getConnection("jdbc:sqlite:/ext/cluselm/git/9Share/src/libs/NineShare.db");

	try {
	    Class.forName("org.sqlite.JDBC");
	} catch (ClassNotFoundException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	PreparedStatement statement1 = con
		.prepareStatement("select * from utilisateur where login= ?");
	statement1.setString(1, login);
	ResultSet result = statement1.executeQuery();
	if (result.next()) {
	    /* TODO ajouter un message box : compte deja pri */
	} else {
	    String sql = "INSERT INTO utilisateur (login,motDePasse,nom,prenom,adresse,mail,dateNaissance)"
		    + "VALUES (?,?,?,?,?,?,?)";
	    PreparedStatement statement = con.prepareStatement(sql);
	    statement.setString(1, login);
	    statement.setString(2, mdp);
	    statement.setString(3, nom);
	    statement.setString(4, prenom);
	    statement.setString(5, adresse);
	    statement.setString(6, mail);
	    statement.setString(7, dateNaissance.toString());
	    statement.executeUpdate();

	    /* TODO ajouter un message box : inscription ok */
	}
    }

    /**
     * The constructor.
     * 
     * @param login
     * @param mdp
     * @param nom
     * @param prenom
     * @param adresse
     * @param mail
     * @param dateNaissance
     */
    public Utilisateur(String login, String mdp, String nom, String prenom,
	    String adresse, String mail, String dateNaissance) {
	// TODO change date String to Date
	super();
	this.login = login;
	this.motDePasse = mdp;
	this.prenom = prenom;
	this.nom = nom;
	this.adresse = adresse;
	this.mail = mail;
	this.dateNaissance = dateNaissance;
    }

    /**
     * Permet de s'aboner � un salon de discution.
     * 
     * @param refZone
     * @return
     * @throws NotNullException
     */
    public boolean abonner(SalonDiscussion refZone) throws NotNullException {
	// TODO Use SalonDiscussion to be more safe.
	if (refZone == null)
	    throw new NotNullException("SalonDiscussion refZone",
		    "application.Utilisateur");
	return this.zonesAbonement.add(refZone.getReferences());
    }

    /**
     * Permet d'ajouter une relation.
     * 
     * @param u
     * @throws SQLException
     */
    public void ajouterRelation(Utilisateur u) throws SQLException {
	// TODO ajouter relation via liste?
	// TODO NotNull/Ensure
	this.relations.add(u);
	Connection con = DriverManager
		.getConnection("jdbc:sqlite:lib/nineshare.db");
	try {
	    Class.forName("org.sqlite.JDBC");
	} catch (ClassNotFoundException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	String sql = "INSERT INTO relation (utilisateur_1,utilisateur_2) VALUES(? ,?)";
	PreparedStatement statement = con.prepareStatement(sql);
	statement.setString(1, this.login);
	statement.setString(2, u.getLogin());
	statement.executeUpdate();
    }

    /**
     * Permet de supprimer une relation.
     * 
     * @param u
     * @throws SQLException
     */
    public void supprimerRelation(Utilisateur u) throws SQLException {
	// TODO NotNull/ENsure
	this.relations.remove(u);
	Connection con = DriverManager
		.getConnection("jdbc:sqlite:lib/nineshare.db");
	try {
	    Class.forName("org.sqlite.JDBC");
	} catch (ClassNotFoundException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	String sql = "DELETE FROM relation WHERE utilisateur_2 = ?";
	PreparedStatement statement = con.prepareStatement(sql);
	statement.setString(1, u.getLogin());
	statement.executeUpdate();
    }

    /**
     * Permete ed modifier les informations de l'utilisateur.
     * 
     * @param nom
     * @param prenom
     * @param adresse
     * @param mail
     * @param dateNaissance
     * @throws SQLException
     */
    public void modifierInformations(String nom, String prenom, String adresse,
	    String mail, String dateNaissance) throws SQLException {
	// TODO change date String to Date
	this.nom = nom;
	this.prenom = prenom;
	this.adresse = adresse;
	this.mail = mail;
	this.dateNaissance = dateNaissance;
	Connection con = DriverManager
		.getConnection("jdbc:sqlite:lib/nineshare.db");
	try {
	    Class.forName("org.sqlite.JDBC");
	} catch (ClassNotFoundException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	String sql = "UPDATE utilisateur SET nom = ?, prenom = ? ,adresse = ? ,mail = ? ,dateNaissance = ? WHERE login = '"
		+ this.getLogin() + "'";
	PreparedStatement statement = con.prepareStatement(sql);
	statement.setString(1, nom);
	statement.setString(2, prenom);
	statement.setString(3, adresse);
	statement.setString(4, mail);
	statement.setString(5, dateNaissance.toString());
	statement.executeUpdate();
    }

    // TODO set photo de profile

    /**
     * Permet de modifier le mot de passe de l'utilisateur.
     * 
     * @param newMDP
     */
    public void modifierMotDePasse(String newMDP) {
	this.motDePasse = newMDP;
    }

    /**
     * Permet de modifier le login de l'utilisateur.
     * 
     * @return
     */
    public String getLogin() {
	return this.login;
    }

    /**
     * Permet de modifier le pr�nom de l'utilisateur.
     * 
     * @return
     */
    public String getPrenom() {
	return this.prenom;
    }

    /**
     * Permet de modifier l'adresse de l'utilisateur.
     * 
     * @return
     */
    public String getAdresse() {
	return this.adresse;
    }

    /**
     * Permet de modifier le mail de l'utilisateur.
     * 
     * @return
     */
    public String getMail() {
	return this.mail;
    }

    /**
     * Permet de modifier le nom de l'utilisateur.
     * 
     * @return
     */
    public String getNom() {
	return this.nom;
    }

    /**
     * Permet de modifier la date de naissance de l'utilisateur.
     * 
     * @return
     */
    public String getDateNaissance() {
	// TODO change date String to Date
	return this.dateNaissance;
    }

    /**
     * Permet de r�cup�rer les relations de l'utilisateur.
     * 
     * @return
     */
    public ArrayList<Utilisateur> getRelations() {
	return this.relations;
    }

    @Override
    public String toString() {
	return "" + this.nom + ", " + this.prenom;
    }
}