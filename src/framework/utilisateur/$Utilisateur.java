/*******************************************************************************
 * 2018, All rights reserved.
 *******************************************************************************/
package framework.utilisateur;

import java.util.ArrayList;

import framework.exception.NotNullException;
// Start of user code (user defined imports)
import framework.rmi.*;
import framework.zonesPartage.*;
// End of user code

/**
 * Description of $Utilisateur.
 * 
 * @author monbeigj
 */
public abstract class $Utilisateur{

	
	protected ArrayList<$Requete<? extends $Utilisateur>> requetes = new ArrayList<$Requete<? extends $Utilisateur>>();

	protected Authentification connecter = null;

	/**
	 * Description of the property ZonesInteractions. ZonesInteractions toutes
	 * les zones dans lesquelles il peut intéragir dont il n'est pas le
	 * propriétaire
	 */
	protected ArrayList<ZonePartageSimple> ZonesInteractions = new ArrayList<ZonePartageSimple>();

	/**
	 * Description of the property ZonesInteractions. ZonesInteractions toutes
	 * les zones dans lesquelles il peut intéragir dont il n'est pas le
	 * propriétaire
	 */
	// TODO voir pour mettre null?
	protected ArrayList<ZonePartageSimple> ZonesCrees = new ArrayList<ZonePartageSimple>(); 

	// Start of user code (user defined attributes for $Utilisateur)

	// End of user code

	/**
	 * The constructor.
	 */
	public $Utilisateur() {
		// Start of user code constructor for $Utilisateur)
		super();
		// End of user code
	}

	/**
	 * Returns requetes.
	 * 
	 * @return requetes
	 */
	public ArrayList<$Requete<? extends $Utilisateur>> getRequetes() {
		return this.requetes;
	}

	/**
	 * Returns connecter.
	 * 
	 * @return connecter
	 */
	public Authentification getConnecter() {
		return this.connecter;
	}

	/**
	 * Sets a value to attribute connecter.
	 * 
	 * @param newConnecter
	 */
	public void setConnecter(LoginMotDePasse newConnecter) throws NotNullException {
		if (newConnecter == null)
			throw new NotNullException("LoginMotDePasse newConnecter", "setConnecter");
		this.connecter = newConnecter;
	}

	/**
	 * Returns ZonesInteractions.
	 * 
	 * @return ZonesInteractions
	 */
	public ArrayList<ZonePartageSimple> getZonesInteractions() {
		return this.ZonesInteractions;
	}

	/**
	 * Returns ZonesCrees
	 * 
	 * @return ZonesCrees
	 */
	public ArrayList<ZonePartageSimple> getZonesCrees() {
		return this.ZonesCrees;
	}

	/**
	 * 
	 * @param nouvelleZone
	 * @throws NotNullException
	 */
	public void creerZone(ZonePartageSimple nouvelleZone) throws NotNullException {
		if (nouvelleZone == null)
			throw new NotNullException("ZonePartageSimple nouvelleZone", "ajouterZone");
		this.ZonesCrees.add(nouvelleZone);
	}

	/**
	 * 
	 * @param zone
	 * @throws NotNullException
	 */
	public void rejoindreZone(ZonePartageSimple zone) throws NotNullException {
		if (zone == null)
			throw new NotNullException("ZonePartageSimple zone", "rejoindreZone");
		this.ZonesInteractions.add(zone);
	}

}
