package framework.transferable;

import java.net.URL;

import framework.exception.NotNullException;
import framework.zonesPartages.ZonePartageSimple;

/**
 * Description of Video.
 * 
 * @author monbeigj
 */
public class Video extends $Fichier {

    private final String name;

    /**
     * The constructor.
     * 
     * @throws NotNullException
     */
    public Video(ZonePartageSimple zone, URL path) throws NotNullException {
	super(zone);
	this.name = path.getFile();
    }
}
