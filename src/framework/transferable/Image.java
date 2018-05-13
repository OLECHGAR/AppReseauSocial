package framework.transferable;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URI;

import javax.imageio.ImageIO;

import framework.exception.NotNullException;
import framework.zonesPartages.ZonePartageSimple;

/**
 * Description of Image.
 * 
 * @author monbeigj
 */
public class Image extends $Fichier<BufferedImage> {

    /**
     * The constructor.
     * 
     * @param zone
     * @param pathImage
     * @throws NotNullException
     * @throws IOException
     */
    public Image(ZonePartageSimple zone, String path) throws NotNullException,
	    IOException {
	super(zone, path);
	File f = new File(path);
	this.contenu = ImageIO.read(f);
    }

    /**
     * The constructor.
     * 
     * @param zone
     * @param pathImage
     * @throws NotNullException
     * @throws IOException
     */
    public Image(ZonePartageSimple zone, URI path) throws NotNullException,
	    IOException {
	super(zone, path.toURL().getFile());
	this.contenu = ImageIO.read((new File(path)));
    }

    /**
     * The constructor.
     * 
     * @param zone
     * @param fichierImage
     * @throws NotNullException
     * @throws IOException
     */
    public Image(ZonePartageSimple zone, File fichierImage)
	    throws NotNullException, IOException {
	super(zone, fichierImage.getName());
	this.contenu = ImageIO.read(fichierImage);
    }

    /**
     * Peremet de récupérer les format pris en charge par notre framwork.
     * 
     * @return extention des fichiers sour un tableau de String
     */
    public String[] getReaderFormatNames() {
	return ImageIO.getReaderFormatNames();
    }
}
