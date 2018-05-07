/*******************************************************************************
 * 2018, All rights reserved.
 *******************************************************************************/
package framework.zonesPartage;
// Start of user code (user defined imports)

import java.util.ArrayList;
import java.util.Iterator;

import framework.utilisateur.*;
import framework.exception.NotNullException;

// End of user code

/**
 * Description of ZonePartage.
 * 
 * @author monbeigj
 */
public class ZonePartage extends ZonePartageSimple {
	// Start of user code (user defined attributes for ZonePartage)
	/**
	 * Description of the property messages.
	 */
	protected ArrayList<? extends $Utilisateur> utilisateursAutorises;
	protected $Utilisateur proprietaire;
	protected boolean estPrivee;
	protected String nom;

	// End of user code
	/**
	 * The constructor of ZonePartage without owner
	 * 
	 * @param utilisateursAutorises
	 * @throws NotNullException
	 */
	public ZonePartage(ArrayList<? extends $Utilisateur> utilisateursAutorises) throws NotNullException {
		super();
		this.proprietaire = null;
		this.estPrivee = true;
		this.utilisateursAutorises = utilisateursAutorises;
		ajouterUtilisateurs(utilisateursAutorises);
	}

	/**
	 * The constructor of ZonePartage is zone privacy is set on public.
	 * 
	 * @param proprietaire
	 * @throws NotNullException
	 */
	public ZonePartage($Utilisateur proprietaire, String nom) throws NotNullException {
		super();
		if (proprietaire == null)
			throw new NotNullException("$Utilisateur proprietaire", "ZonePartage");
		this.proprietaire = proprietaire;
		this.estPrivee = false;
		if (nom == null)
			this.nom = "";
		else
			this.nom = nom;
	}

	/**
	 * The constructor of ZonePartage is zone privacy is set on private.
	 * 
	 * @param proprietaire
	 * @param utilisateursAutorises
	 * @throws NotNullException
	 */
	public ZonePartage($Utilisateur proprietaire, ArrayList<? extends $Utilisateur> utilisateursAutorises) throws NotNullException {
		super();
		if (proprietaire == null)
			throw new NotNullException("$Utilisateur proprietaire", "ZonePartage");
		this.proprietaire = proprietaire;
		this.estPrivee = true;
		this.utilisateursAutorises = utilisateursAutorises;
		ajouterUtilisateurs(utilisateursAutorises);
	}

	/**
	 * The constructor of ZonePartage is zone privacy is set on private.
	 * 
	 * @param proprietaire
	 * @param utilisateursAutorises
	 * @param nom
	 * @throws NotNullException
	 */
	public ZonePartage($Utilisateur proprietaire, ArrayList<? extends $Utilisateur> utilisateursAutorises, String nom)
			throws NotNullException {
		super();
		if (proprietaire == null)
			throw new NotNullException("$Utilisateur proprietaire", "ZonePartage");
		this.proprietaire = proprietaire;
		this.estPrivee = true;
		this.utilisateursAutorises = utilisateursAutorises;
		this.nom = nom;
		ajouterUtilisateurs(utilisateursAutorises);
	}

	// Start of user code (user defined methods for ZonePartage)
	/**
	 * @return prorietaire
	 */
	public $Utilisateur getProprietaire() {
		return this.proprietaire;
	}

	/**
	 * 
	 * @param proprietaire
	 * @throws NotNullException
	 */
	public void setProprietaire($Utilisateur proprietaire) throws NotNullException {
		if (proprietaire == null)
			throw new NotNullException("$Utilisateur propriétaire", "setProprietaire");
		this.proprietaire = proprietaire;
	}

	public void ajouterUtilisateurs(ArrayList<? extends $Utilisateur> $Utilisateurs) {
		Iterator<? extends $Utilisateur> it = $Utilisateurs.iterator();
		while (it.hasNext()) {
			it.next().rejoindreZone(this);
		}
	}

	/**
	 * 
	 * @return
	 */
	public boolean setPublique() {
		if (this.estPrivee == false)
			return false;
		this.utilisateursAutorises = new ArrayList<$Utilisateur>(); //TODO check is OK
		this.estPrivee = false;
		return true;
	}

	/**
	 * 
	 * @return
	 */
	public boolean setPrivee(ArrayList<? extends $Utilisateur> utilisateursAutorises) {
		if (this.estPrivee == true)
			return false;
		this.utilisateursAutorises = utilisateursAutorises;
		this.ajouterUtilisateurs(utilisateursAutorises);
		this.estPrivee = true;
		return true;
	}

	/**
	 * 
	 * @return
	 */
	public String getNom() {
		return this.nom;
	}

	/**
	 * 
	 * @param nom
	 * @throws NotNullException
	 */
	public void setNom(String nom) throws NotNullException {
		this.nom = nom;
	}

	/**
	 * 
	 * @return
	 */
	public boolean getPrivacy() {
		return this.estPrivee;
	}

	// End of user code

}
