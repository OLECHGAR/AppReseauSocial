/*******************************************************************************
 * 2018, All rights reserved.
 *******************************************************************************/
package framework.zonesPartage;
// Start of user code (user defined imports)

import java.util.ArrayList;
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
	protected ArrayList<Utilisateur> utilisateursAutorises = new ArrayList<Utilisateur>();
	protected Utilisateur proprietaire;
	protected boolean estPrivee;
	protected String nom;
	// End of user code

	/**
	 * The constructor.
	 * 
	 * @param proprietaire
	 * @throws NotNullException
	 */
	public ZonePartage(Utilisateur proprietaire) throws NotNullException {
		// Start of user code constructor for Reception)
		super();
		if (proprietaire == null)
			throw new NotNullException("la zone de partage doit-avoir un utilisateur");
		this.proprietaire = proprietaire;
		this.estPrivee = false;
		// End of user code
	}

	/**
	 * The constructor.
	 * 
	 * @param proprietaire
	 * @param utilisateursAutorises
	 * @throws NotNullException
	 */
	public ZonePartage(Utilisateur proprietaire, ArrayList<Utilisateur> utilisateursAutorises) throws NotNullException {
		// Start of user code constructor for Reception)
		super();
		if (proprietaire == null)
			throw new NotNullException("la zone de partage doit-avoir un utilisateur");
		this.proprietaire = proprietaire;
		this.estPrivee = true;
		this.utilisateursAutorises = utilisateursAutorises;
		// End of user code
	}

	// Start of user code (user defined methods for ZonePartage)
	/**
	 * @return prorietaire
	 */
	public Utilisateur getProprietaire() {
		return this.proprietaire;
	}

	/**
	 * 
	 * @param proprietaire
	 * @throws NotNullException
	 */
	public void setProprietaire(Utilisateur proprietaire) throws NotNullException {
		if (proprietaire == null)
			throw new NotNullException("Propriétaire");
		this.proprietaire = proprietaire;
	}

	/**
	 * 
	 * @return
	 */
	public boolean setPublique() {
		if (this.estPrivee != true)
			return false;
		this.estPrivee = false;
		return true;
	}

	/**
	 * 
	 * @return
	 */
	public boolean setPrivee() {
		if (this.estPrivee != false)
			return false;
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

	// End of user code

}
