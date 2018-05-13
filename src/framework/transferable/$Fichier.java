package framework.transferable;

import framework.exception.NotNullException;
import framework.zonesPartages.ZonePartageSimple;

/**
 * Description of Fichier.
 * 
 * @author monbeigj
 */
public abstract class $Fichier<T> extends $Transferable<T> {

    private final String name;

    /**
     * The constructor.
     * 
     * @param zone
     * @param path
     * @throws NotNullException
     */
    public $Fichier(ZonePartageSimple zone, String path)
	    throws NotNullException {
	super(zone);
	this.name = path; // TODO change to have name only
    }

    /**
     * Permet de récupérer le nom du fichier.
     * 
     * @return
     */
    public String getName() {
	return this.name;
    }
}
