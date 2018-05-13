package framework.transferable;

import java.io.File;
import java.net.URI;

import framework.exception.NotNullException;
import framework.zonesPartages.ZonePartageSimple;

/**
 * Description of Document.
 * 
 * @author monbeigj
 */
public class Document extends $Fichier<File> {

    /**
     * The constructor.
     * 
     * @param zone
     * @param path
     * @throws NotNullException
     */
    public Document(ZonePartageSimple zone, String path)
	    throws NotNullException {
	super(zone);
	this.contenu = new File(path);
    }

    /**
     * The constructor.
     * 
     * @param zone
     * @param path
     * @throws NotNullException
     */
    public Document(ZonePartageSimple zone, URI path) throws NotNullException {
	super(zone);
	this.contenu = new File(path);
    }
}
