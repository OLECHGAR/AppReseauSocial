package application;

import java.util.ArrayList;
import java.util.Date;

import framework.utilisateur.*;

/**
 * 
 * @author monbeigj
 *
 */
public class Utilisateur extends $Utilisateur {

	private String login;
	private String motDePasse;
	private String nom;
	private String prenom;
	private String adresse;
	private String mail;
	private Date dateNaissance;
	private ArrayList<Utilisateur> relations = new ArrayList<Utilisateur>();

	/**
	 * 
	 * @param login
	 * @param mdp
	 * @param nom
	 * @param prenom
	 * @param adresse
	 * @param mail
	 * @param dateNaissance
	 */
	public Utilisateur(String login, String mdp, String nom, String prenom, String adresse, String mail,
			Date dateNaissance) {
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
	 * @param u
	 */
	public void ajouterRelation(Utilisateur u) {
		// TODO ajouter relation via liste?
		// TODO NotNull/Ensure
		this.relations.add(u);
	}

	/**
	 * 
	 * @param u
	 */
	public void supprimerRelation(Utilisateur u) {
		// TODO NotNull/ENsure
		this.relations.remove(u);
	}

	/**
	 * 
	 * @param nom
	 * @param prenom
	 * @param adresse
	 * @param mail
	 * @param dateNaissance
	 */
	public void modifierInformations(String nom, String prenom, String adresse, String mail, Date dateNaissance) {
		this.prenom = prenom;
		this.adresse = adresse;
		this.mail = mail;
		this.dateNaissance = dateNaissance;
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
		return login;
	}
	
	public String getPrenom() {
		return prenom;
	}

	public String getAdresse() {
		return adresse;
	}

	public String getMail() {
		return mail;
	}
	
	public String getNom(){
		return this.nom;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public ArrayList<Utilisateur> getRelations() {
		return relations;
	}

}
