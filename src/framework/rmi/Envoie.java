package framework.rmi;

import java.awt.datatransfer.Transferable;

import framework.exception.NotNullException;

/*******************************************************************************
 * 2018, All rights reserved.
 *******************************************************************************/

// Start of user code (user defined imports)

// End of user code

/**
 * Description of Envoie.
 * 
 * @author monbeigj
 */
public class Envoie extends $Requete {
	// Start of user code (user defined attributes for Envoie)

	// End of user code

	/**
	 * The constructor.
	 * @throws NotNullException 
	 */
	public <T extends Transferable> Envoie(T contenu) throws NotNullException {
		// Start of user code constructor for Envoie)
		super();
		super.setTransferable(contenu);
		// End of user code
	}

	// Start of user code (user defined methods for Envoie)

	// End of user code

}
