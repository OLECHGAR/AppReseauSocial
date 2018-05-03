/*******************************************************************************
 * 2018, All rights reserved.
 *******************************************************************************/
package framework.transferable;
// Start of user code (user defined imports)

import framework.exception.NotNullException;
import framework.zonesPartage.ZonePartage;

// End of user code

/**
 * Description of Texte.
 * 
 * @author monbeigj
 */
public class Texte extends $Transferable {
	// Start of user code (user defined attributes for Texte)

	// End of user code

	/**
	 * The constructor.
	 * @throws NotNullException 
	 */
	public Texte(ZonePartage zone) throws NotNullException {
		// Start of user code constructor for Texte)
		super(zone);
		// End of user code
	}
	
	public Texte(ZonePartage zone,String message) throws NotNullException{
		super(zone);
		super.contenu = message;
	}
	// Start of user code (user defined methods for Texte)

	// End of user code

}
