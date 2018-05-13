/*******************************************************************************
 * 2018, All rights reserved.
 *******************************************************************************/
package framework.transferable;
// Start of user code (user defined imports)

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

import framework.exception.NotNullException;
import framework.zonesPartages.ZonePartageSimple;

// End of user code

/**
 * Description of Video.
 * 
 * @author marvin
 */
public class Video extends $Fichier {
	/**
	 * The constructor.
	 * 
	 * @throws NotNullException
	 */
	public Video(ZonePartageSimple zone, URL path) throws NotNullException {
		// Start of user code constructor for Video)
		super(zone);
		path.getFile();
	}

	// Start of user code (user defined methods for Video)

	// End of user code
	
	/**
	 * Conversion d'un fichier video en ByteArrayOuputStream
	 * @param path: le chemin du fichier
	 * @return un tableau de byte
	 * @throws FileNotFoundException
	 */
	public static ByteArrayOutputStream GetVideoToByte(String path) throws FileNotFoundException{
		
		File file = new File(path);
		FileInputStream input = new FileInputStream(file);
		ByteArrayOutputStream output = new ByteArrayOutputStream();
	        
		byte[] buf = new byte[10000];
	        try {
	            for (int i; (i = input.read(buf)) != -1;) {
	                output.write(buf, 0, i); 
	            }
		       input.close();
	        } catch (IOException ex) {
	        	// TODO Auto-generated catch block
		 		ex.printStackTrace();  
	        }
	        return output;
	}
	
	/**
	 * 
	 * Convertit un tableau de byte en fichier video
	 * @param byteFile : le ByteArrayOutputStream a convertir
	 * @param path : chemin du fichier video à créer
	 * @return video: le fichier video formé
	 * @throws FileNotFoundException
	 */
	public static File GetByteToVideo(ByteArrayOutputStream byteFile, String path) throws FileNotFoundException{
		 
		byte[] bytes = byteFile.toByteArray();
		 File video = new File(path);
	     FileOutputStream output = new FileOutputStream(video);
	     
	     try {
		     output.write(bytes);
		     output.flush();
		     output.close();
	     } catch (IOException e) {
	 		// TODO Auto-generated catch block
	 		e.printStackTrace();
	 	}
	     return video;
	}

}
