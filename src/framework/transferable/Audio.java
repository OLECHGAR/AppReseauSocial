/*******************************************************************************
 * 2018, All rights reserved.
 *******************************************************************************/
package framework.transferable;

// Start of user code (user defined imports)

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.MalformedURLException;
import java.net.URL;

import framework.exception.NotNullException;
import framework.zonesPartages.ZonePartageSimple;

// End of user code

/**
 * Description of Audio.
 * 
 * @author monbeigj
 */
public class Audio extends $Fichier<AudioClip> {
    // Start of user code (user defined attributes for Audio)
    private final String name;

    // End of user code

    /**
     * The constructor.
     * 
     * @param zone
     * @param path
     * @throws NotNullException
     */
    public Audio(ZonePartageSimple zone, URL path) throws NotNullException {
	// Start of user code constructor for Audio)
	super(zone);
	this.contenu = Applet.newAudioClip(path);
	this.name = path.getFile();
	// End of user code
    }

    /**
     * 
     * @param zone
     * @param path
     * @throws NotNullException
     * @throws MalformedURLException
     */
    public Audio(ZonePartageSimple zone, String path) throws NotNullException,
	    MalformedURLException {
	// Start of user code constructor for Audio)
	super(zone);
	URL url = new URL("ftp://" + path);
	this.contenu = Applet.newAudioClip(url);
	this.name = url.getFile();
	// End of user code
    }

    // Start of user code (user defined methods for Audio)
    public String getName() {
	return this.name;
    }

    // End of user code
}
