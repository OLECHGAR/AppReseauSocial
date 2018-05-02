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
 * Description of _Transferable.
 * 
 * @author monbeigj
 */
public abstract class _Transferable {
	/**
	 * Description of the property ZonesPartages.
	 */
	private ArrayList<$ZonePartage> ZonesPartages = new ArrayList<$ZonePartage>();

	/**
	 * Description of the property requetes.
	 */
	private ArrayList<$Requete> requetes = new ArrayList<$Requete>();

	// Start of user code (user defined attributes for _Transferable)

	// End of user code

	/**
	 * The constructor.
	 */
	public _Transferable() {
		// Start of user code constructor for _Transferable)
		super();
		// End of user code
	}

	// Start of user code (user defined methods for _Transferable)

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
