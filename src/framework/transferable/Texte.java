package framework.transferable;

import framework.exception.NotNullException;
import framework.zonesPartages.ZonePartageSimple;

/**
 * Description of Texte.
 * 
 * @author monbeigj
 * @param <T>
 */
public class Texte<T> extends $Transferable<T> {

    /**
     * The constructor.
     * 
     * @throws NotNullException
     */
    public Texte(ZonePartageSimple zone) throws NotNullException {
	super(zone);
    }
}
