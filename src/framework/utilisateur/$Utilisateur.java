package framework.utilisateur;

import java.util.ArrayList;
import java.util.Iterator;

import framework.exception.Ensure;
import framework.exception.NotNullException;
// Start of user code (user defined imports)
import framework.rmi.*;
import framework.zonesPartages.*;
// End of user code

/**
 * Description of $Utilisateur.
 * 
 * @author monbeigj
 */
public abstract class $Utilisateur<T extends ZonePartageSimple>{

	
	protected ArrayList<$Requete<? extends $Utilisateur<T>>> requetes = new ArrayList<$Requete<? extends $Utilisateur<T>>>();

	protected Authentification connecter = null;

	/**
	 * Description of the property ZonesInteractions. ZonesInteractions toutes
	 * les zones dans lesquelles il peut intéragir dont il n'est pas le
	 * propriétaire
	 */
	protected ArrayList<T> ZonesInteractions = new ArrayList<T>();

	/**
	 * Description of the property ZonesInteractions. ZonesInteractions toutes
	 * les zones dans lesquelles il peut intéragir dont il n'est pas le
	 * propriétaire
	 */
	// TODO voir pour mettre null?
	protected ArrayList<T> ZonesCrees = new ArrayList<T>(); 

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
	public ArrayList<$Requete<? extends $Utilisateur<T>>> getRequetes() {
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
	public ArrayList<T> getZonesInteractions() {
		return this.ZonesInteractions;
	}

	/**
	 * Returns ZonesCrees
	 * 
	 * @return ZonesCrees
	 */
	public ArrayList<T> getZonesCrees() {
		return this.ZonesCrees;
	}

	/**
	 * Permet d'ajouter une zone cr��e dans la liste de zones cr��es
	 * 
	 * @param nouvelleZone
	 * @throws NotNullException
	 * @ensure estCree(nouvelleZone) == true
	 */
	public void creerZone(T nouvelleZone) throws NotNullException {
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
	public  void rejoindreZone(T zone) throws NotNullException {
		if (zone == null)
			throw new NotNullException("ZonePartageSimple zone", "rejoindreZone");
		this.ZonesInteractions.add(zone);
		if(!(aRejoint(zone)))throw new Ensure("aRejoint(zone)) == true","$Utilisateur.rejoindreZone");
	}
	
	
	private boolean estCree(T nouvelleZone) {
		Iterator<T> it = this.ZonesCrees.iterator();
		while(it.hasNext()) {
			if(it.next() == nouvelleZone)
				return true;
		}
		return false;
	}
	
	private boolean aRejoint(T nouvelleZone) {
		Iterator<T> it = this.ZonesInteractions.iterator();
		while(it.hasNext()) {
			if(it.next() == nouvelleZone)
				return true;
		}
		return false;
	}
}
