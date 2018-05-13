package framework.transferable;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.MalformedURLException;
import java.net.URL;

import framework.exception.NotNullException;
import framework.zonesPartages.ZonePartageSimple;

/**
 * Description of Audio.
 * 
 * @author monbeigj
 */
public class Audio extends $Fichier<AudioClip> {
    private final String name;

    /**
     * The constructor.
     * 
     * @param zone
     * @param path
     * @throws NotNullException
     */
    public Audio(ZonePartageSimple zone, URL path) throws NotNullException {
	super(zone);
	this.contenu = Applet.newAudioClip(path);
	this.name = path.getFile();
    }

    /**
     * The constructor.
     * 
     * @param zone
     * @param path
     * @throws NotNullException
     * @throws MalformedURLException
     */
    public Audio(ZonePartageSimple zone, String path) throws NotNullException,
	    MalformedURLException {
	super(zone);
	URL url = new URL("ftp://" + path);
	this.contenu = Applet.newAudioClip(url);
	this.name = url.getFile();
    }

    /**
     * Permet de récupérer le nom du fichier audio.
     * 
     * @return this.name
     */
    public String getName() {
	return this.name;
    }
}
