/*******************************************************************************
 * 2018, All rights reserved.
 *******************************************************************************/
package framework.transferable;

// Start of user code (user defined imports)

import java.io.File;
import java.net.URI;

import framework.exception.NotNullException;
import framework.zonesPartages.ZonePartageSimple;

// End of user code

/**
 * Description of Document.
 * 
 * @author monbeigj
 */
public class Document extends $Fichier<File> {
    // Start of user code (user defined attributes for Document)

    // End of user code

    /**
     * 
     * @param zone
     * @param path
     * @throws NotNullException
     */
    public Document(ZonePartageSimple zone, String path)
	    throws NotNullException {
	// Start of user code constructor for Document)
	super(zone);
	this.contenu = new File(path);
	// End of user code
    }

    /**
     * 
     * @param zone
     * @param path
     * @throws NotNullException
     */
    public Document(ZonePartageSimple zone, URI path) throws NotNullException {
	// Start of user code constructor for Document)
	super(zone);
	this.contenu = new File(path);
	// End of user code
    }

    // Start of user code (user defined methods for Document)

    // End of user code

}
