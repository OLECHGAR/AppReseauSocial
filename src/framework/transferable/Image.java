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

    private final String name;

    /**
     * The constructor.
     * 
     * @param zone
     * @param pathImage
     * @throws NotNullException
     * @throws IOException
     */
    public Image(ZonePartageSimple zone, String pathImage)
	    throws NotNullException, IOException {
	super(zone);
	File f = new File(pathImage);
	this.contenu = ImageIO.read(f);
	this.name = f.getName();
    }

    /**
     * The constructor.
     * 
     * @param zone
     * @param pathImage
     * @throws NotNullException
     * @throws IOException
     */
    public Image(ZonePartageSimple zone, URI pathImage)
	    throws NotNullException, IOException {
	super(zone);
	this.contenu = ImageIO.read((new File(pathImage)));
	this.name = pathImage.toURL().getFile();
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
	super(zone);
	this.contenu = ImageIO.read(fichierImage);
	this.name = fichierImage.getName();
    }

    /**
     * Peremet de récupérer les format pris en charge par notre framwork.
     * 
     * @return extention des fichiers sour un tableau de String
     */
    public String[] getReaderFormatNames() {
	return ImageIO.getReaderFormatNames();
    }

    /**
     * Permet de récupérer le nom du fichier image.
     * 
     * @return this.name;
     */
    public String getName() {
	return this.name;
    }

}
