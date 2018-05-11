/*******************************************************************************
 * 2018, All rights reserved.
 *******************************************************************************/
package framework.transferable;
// Start of user code (user defined imports)

import java.net.URL;

import framework.exception.NotNullException;
import framework.zonesPartages.ZonePartageSimple;

// End of user code

/**
 * Description of Video.
 * 
 * @author monbeigj
 */
public class Video extends $Fichier {
	// Start of user code (user defined attributes for Video)
	private final String name;
	// End of user code

	/**
	 * The constructor.
	 * 
	 * @throws NotNullException
	 */
	public Video(ZonePartageSimple zone, URL path) throws NotNullException {
		// Start of user code constructor for Video)
		super(zone);
		// End of user code
		this.name = path.getFile();
	}

	// Start of user code (user defined methods for Video)

	// End of user code

}
