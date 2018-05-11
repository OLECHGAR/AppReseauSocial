/*******************************************************************************
 * 2018, All rights reserved.
 *******************************************************************************/
package framework.transferable;

// Start of user code (user defined imports)

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URI;

import javax.imageio.ImageIO;

import framework.exception.NotNullException;
import framework.zonesPartages.ZonePartageSimple;

// End of user code

/**
 * Description of Image.
 * 
 * @author monbeigj
 */
public class Image extends $Fichier<BufferedImage> {
    // Start of user code (user defined attributes for Image)
    private final String name;

    // End of user code

    /**
     * 
     * @param zone
     * @param pathImage
     * @throws NotNullException
     * @throws IOException
     */
    public Image(ZonePartageSimple zone, String pathImage)
	    throws NotNullException, IOException {
	// Start of user code constructor for Image)
	super(zone);
	File f = new File(pathImage);
	this.contenu = ImageIO.read(f);
	this.name = f.getName();
	// End of user code
    }

    /**
     * 
     * @param zone
     * @param pathImage
     * @throws NotNullException
     * @throws IOException
     */
    public Image(ZonePartageSimple zone, URI pathImage)
	    throws NotNullException, IOException {
	// Start of user code constructor for Image)
	super(zone);
	this.contenu = ImageIO.read((new File(pathImage)));
	this.name = pathImage.toURL().getFile();
	// End of user code
    }

    /**
     * 
     * @param zone
     * @param fichierImage
     * @throws NotNullException
     * @throws IOException
     */
    public Image(ZonePartageSimple zone, File fichierImage)
	    throws NotNullException, IOException {
	// Start of user code constructor for Image)
	super(zone);
	this.contenu = ImageIO.read(fichierImage);
	this.name = fichierImage.getName();
	// End of user code
    }

    // Start of user code (user defined methods for Image)
    public String[] getReaderFormatNames() {
	return ImageIO.getReaderFormatNames();
    }
    // End of user code

}
