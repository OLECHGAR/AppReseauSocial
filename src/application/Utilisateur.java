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
public class Utilisateur extends $Utilisateur<SalonDiscussion> implements java.io.Serializable{

	/**
	 * 
	 */
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
	public Utilisateur(String login, String mdp, String nom, String prenom, String adresse, String mail,
			String dateNaissance, Connection con) throws SQLException {
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
		PreparedStatement statement1 = con.prepareStatement("select * from utilisateur where login= ?");
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

	public Utilisateur(String login, String mdp, String nom, String prenom, String adresse, String mail,
			String dateNaissance) {
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
	 * 
	 * @param refZone
	 * @return
	 * @throws NotNullException
	 */
	public boolean abonner(SalonDiscussion refZone) throws NotNullException {
		// Use SalonDiscussion to be more safe.
		if (refZone == null)
			throw new NotNullException("SalonDiscussion refZone", "application.Utilisateur");
		return this.zonesAbonement.add(refZone.getReferences());
	}

	/**
	 * 
	 * @param u
	 * @throws SQLException
	 */
	public void ajouterRelation(Utilisateur u) throws SQLException {
		// TODO ajouter relation via liste?
		// TODO NotNull/Ensure
		this.relations.add(u);
		Connection con = DriverManager.getConnection("jdbc:sqlite:lib/nineshare.db");
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
	 * 
	 * @param u
	 * @throws SQLException
	 */
	public void supprimerRelation(Utilisateur u) throws SQLException {
		// TODO NotNull/ENsure
		this.relations.remove(u);
		Connection con = DriverManager.getConnection("jdbc:sqlite:lib/nineshare.db");
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
	 * 
	 * @param nom
	 * @param prenom
	 * @param adresse
	 * @param mail
	 * @param dateNaissance
	 * @throws SQLException
	 */
	public void modifierInformations(String nom, String prenom, String adresse, String mail, String dateNaissance)
			throws SQLException {
		// TODO change date String to Date
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.mail = mail;
		this.dateNaissance = dateNaissance;
		Connection con = DriverManager.getConnection("jdbc:sqlite:lib/nineshare.db");
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
	 * 
	 * @param newMDP
	 */
	public void modifierMotDePasse(String newMDP) {
		this.motDePasse = newMDP;
	}

	public String getLogin() {
		return this.login;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public String getAdresse() {
		return this.adresse;
	}

	public String getMail() {
		return this.mail;
	}

	public String getNom() {
		return this.nom;
	}

	public String getDateNaissance() {
		// TODO change date String to Date
		return this.dateNaissance;
	}

	public ArrayList<Utilisateur> getRelations() {
		return this.relations;
	}

	@Override
	public String toString() {
		return "Utilisateur [login=" + login + ", motDePasse=" + motDePasse + ", nom=" + nom + ", prenom=" + prenom
				+ ", adresse=" + adresse + ", mail=" + mail + ", dateNaissance=" + dateNaissance + "]";
	}

}