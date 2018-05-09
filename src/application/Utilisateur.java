package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;

import framework.exception.NotNullException;
import framework.utilisateur.$Utilisateur;

/**
 * 
 * @author monbeigj
 *
 */
public class Utilisateur extends $Utilisateur {

	private String login;
	private String motDePasse;
	private String id;
	private String nom;
	private String prenom;
	private String adresse;
	private String mail;
	private Date dateNaissance;
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
	public Utilisateur(String id, String login, String mdp, String nom,
			String prenom, String adresse, String mail, Date dateNaissance)
			throws SQLException {
		super();
		this.id = id;
		this.login = login;
		this.motDePasse = mdp;
		this.prenom = prenom;
		this.nom = nom;
		this.adresse = adresse;
		this.mail = mail;
		this.dateNaissance = dateNaissance;
		
		Connection con = DriverManager
				.getConnection("jdbc:sqlite:/ext/monbeigj/git/9Share/lib/NineShare.db");
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PreparedStatement statement1 = con
				.prepareStatement("select * from utilisateur where id_u= ? or login= ?");
		statement1.setString(1, id);
		statement1.setString(2, login);
		ResultSet result = statement1.executeQuery();
		if (result.next()) {
			System.out.println("nom d'utilisateur ou login d�ja pris");
		} else {
			String sql = "INSERT INTO utilisateur (id_u,login,motDePasse,nom,prenom,adresse,mail,dateNaissance)"
					+ "VALUES (?,?,?,?,?,?,?,?)";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, id);
			statement.setString(2, login);
			statement.setString(3, this.motDePasse);
			statement.setString(4, nom);
			statement.setString(5, prenom);
			statement.setString(6, adresse);
			statement.setString(7, mail);
			statement.setString(8, dateNaissance.toString());
			statement.executeUpdate();

			System.out.println("inscription effectu�");
		}
		con.close();
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
			throw new NotNullException("SalonDiscussion refZone",
					"application.Utilisateur");
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
		statement.setString(1, this.id);
		statement.setString(2, u.id);
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
		statement.setString(1, u.id);
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
	public void modifierInformations(String nom, String prenom, String adresse,
			String mail, Date dateNaissance) throws SQLException {
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

	public Date getDateNaissance() {
		return this.dateNaissance;
	}

	public ArrayList<Utilisateur> getRelations() {
		return this.relations;
	}

}
