package framework.transferable;

import java.util.ArrayList;
import framework.utilisateur.*;
import framework.zonesPartage.*;
import framework.rmi.*;
import framework.exception.*;
/*******************************************************************************
 * 2018, All rights reserved.
 *******************************************************************************/

// Start of user code (user defined imports)

// End of user code

/**
 * Description of $Transferable.
 * 
 * @author monbeigj
 */
public abstract class $Transferable<T> {
	/**
	 * Description of the property ZonesPartages.
	 */
	protected ZonePartage ZonePartage; // NOT NULL

	/**
	 * Description of the property requetes.
	 */
	protected ArrayList<$Requete> requetes = new ArrayList<$Requete>();
	
	protected T contenu;

	// Start of user code (user defined attributes for $Transferable)

	// End of user code

	/**
	 * The constructor.
	 * @throws NotNullException 
	 */
	public $Transferable(ZonePartage zone) throws NotNullException {
		// Start of user code constructor for $Transferable)
		super();
		if(zone == null)throw new NotNullException("transferable");
		this.ZonePartage = zone;
		// End of user code
	}

	// Start of user code (user defined methods for $Transferable)

	// End of user code
	/**
	 * Returns ZonesPartages.
	 * @return ZonesPartages 
	 */
	public ZonePartage getZonePartage() {
		return this.ZonePartage;
	}

	/**
	 * Returns requetes.
	 * @return requetes 
	 */
	public ArrayList<$Requete> getRequetes() {
		return this.requetes;
	}
	
	public void addRequete($Requete requete){
		this.requetes.add(requete);
	}

}
