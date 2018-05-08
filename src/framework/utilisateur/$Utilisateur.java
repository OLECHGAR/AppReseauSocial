/*******************************************************************************
 * 2018, All rights reserved.
 *******************************************************************************/
package framework.utilisateur;

import java.util.ArrayList;
import java.util.Iterator;

import framework.exception.Ensure;
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
	 * les zones dans lesquelles il peut int√©ragir dont il n'est pas le
	 * propri√©taire
	 */
	protected ArrayList<ZonePartageSimple> ZonesInteractions = new ArrayList<ZonePartageSimple>();

	/**
	 * Description of the property ZonesInteractions. ZonesInteractions toutes
	 * les zones dans lesquelles il peut int√©ragir dont il n'est pas le
	 * propri√©taire
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
	 * Permet d'ajouter une zone crÈÈe dans la liste de zones crÈÈes
	 * 
	 * @param nouvelleZone
	 * @throws NotNullException
	 * @ensure estCree(nouvelleZone) == true
	 */
	public void creerZone(ZonePartageSimple nouvelleZone) throws NotNullException {
		if (nouvelleZone == null)
			throw new NotNullException("ZonePartageSimple nouvelleZone", "ajouterZone");
		this.ZonesCrees.add(nouvelleZone);
		if(!(estCree(nouvelleZone)))throw new Ensure("estCree(nouvelleZone)) == true","$Utilisateur.creerZone");
		
	}

	/**
	 * Permet d'ajouter une zone dans la liste de zones interactions
	 * 
	 * @param zone
	 * @throws NotNullException
	 * @ensure aRejoint(zone) == true
	 */
	public void rejoindreZone(ZonePartageSimple zone) throws NotNullException {
		if (zone == null)
			throw new NotNullException("ZonePartageSimple zone", "rejoindreZone");
		this.ZonesInteractions.add(zone);
		if(!(aRejoint(zone)))throw new Ensure("aRejoint(zone)) == true","$Utilisateur.rejoindreZone");
	}
	
	
	private boolean estCree(ZonePartageSimple nouvelleZone) {
		Iterator<ZonePartageSimple> it = this.ZonesCrees.iterator();
		while(it.hasNext()) {
			if(it.next() == nouvelleZone)
				return true;
		}
		return false;
	}
	
	private boolean aRejoint(ZonePartageSimple nouvelleZone) {
		Iterator<ZonePartageSimple> it = this.ZonesInteractions.iterator();
		while(it.hasNext()) {
			if(it.next() == nouvelleZone)
				return true;
		}
		return false;
	}
}
