/*******************************************************************************
 * 2018, All rights reserved.
 *******************************************************************************/
package framework.utilisateur;
import java.util.ArrayList;

// Start of user code (user defined imports)
import framework.rmi.*;
import framework.zonesPartage.*;
// End of user code

/**
 * Description of Utilisateur.
 * 
 * @author monbeigj
 */
public class Utilisateur {
	/**
	 * Description of the property requetes.
	 */
	private ArrayList<$Requete> requetes = new ArrayList<$Requete>();

	/**
	 * Description of the property connecter.
	 */
	private Authentification connecter = null;

	/**
	 * Description of the property ZonesInteractions.
	 */
	private ArrayList<ZonePartage> ZonesInteractions = new ArrayList<ZonePartage>();
	
	private ArrayList<ZonePartage> ZonesCrees = new ArrayList<ZonePartage>();

	// Start of user code (user defined attributes for Utilisateur)

	// End of user code

	/**
	 * The constructor.
	 */
	public Utilisateur() {
		// Start of user code constructor for Utilisateur)
		super();
		// End of user code
	}

	// Start of user code (user defined methods for Utilisateur)

	// End of user code
	/**
	 * Returns requetes.
	 * @return requetes 
	 */
	public ArrayList<$Requete> getRequetes() {
		return this.requetes;
	}

	/**
	 * Returns connecter.
	 * @return connecter 
	 */
	public Authentification getConnecter() {
		return this.connecter;
	}

	/**
	 * Sets a value to attribute connecter. 
	 * @param newConnecter 
	 */
	public void setConnecter(Authentification newConnecter) {
		if (this.connecter != null) {
			this.connecter = null;
		}
		this.connecter = newConnecter;
	}

	/**
	 * Returns ZonesInteractions.
	 * @return ZonesInteractions 
	 */
	public ArrayList<ZonePartage> getZonesInteractions() {
		return this.ZonesInteractions;
	}
	
	/**
	 * Returns ZonesCrees
	 * @return ZonesCrees 
	 */
	public ArrayList<ZonePartage> getZonesCrees() {
		return this.ZonesCrees;
	}
	
	public void ajouterZone(ZonePartage nouvelleZone){
		this.ZonesCrees.add(nouvelleZone);
	}

}
