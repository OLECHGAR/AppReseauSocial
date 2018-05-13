package framework.transferable;

import framework.exception.NotNullException;
import framework.zonesPartages.ZonePartageSimple;

/**
 * Description of Fichier.
 * 
 * @author monbeigj
 */
public abstract class $Fichier<T> extends $Transferable<T> {

    /**
     * The constructor.
     * 
     * @throws NotNullException
     */
    public $Fichier(ZonePartageSimple zone) throws NotNullException {
	super(zone);
    }
}
