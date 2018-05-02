package framework.transferable;

import java.util.ArrayList;
import framework.zonesPartage.*;
import framework.rmi.*;
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
	protected ArrayList<$ZonePartage> ZonesPartages = new ArrayList<$ZonePartage>();

	/**
	 * Description of the property requetes.
	 */
	protected ArrayList<$Requete> requetes = new ArrayList<$Requete>();
	
	protected T contenu;

	// Start of user code (user defined attributes for $Transferable)

	// End of user code

	/**
	 * The constructor.
	 */
	public $Transferable() {
		// Start of user code constructor for $Transferable)
		super();
		// End of user code
	}

	// Start of user code (user defined methods for $Transferable)

	// End of user code
	/**
	 * Returns ZonesPartages.
	 * @return ZonesPartages 
	 */
	public ArrayList<$ZonePartage> getZonesPartages() {
		return this.ZonesPartages;
	}

	/**
	 * Returns requetes.
	 * @return requetes 
	 */
	public ArrayList<$Requete> getRequetes() {
		return this.requetes;
	}

}
