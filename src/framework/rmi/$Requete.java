package framework.rmi;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import framework.exception.NotNullException;
import framework.transferable.$Transferable;
import framework.transferable.Audio;
import framework.transferable.Document;
import framework.transferable.Image;
import framework.transferable.Texte;
import framework.transferable.Video;
import framework.utilisateur.$Utilisateur;
import framework.zonesPartages.ZonePartageSimple;

/**
 * Description of Requete.
 * 
 * @author monbeigj
 */
public abstract class $Requete<T extends $Utilisateur<?>> {
    /**
     * Description of the property $Utilisateur.
     */
    protected T utilisateur;

    /**
     * Description of the property transferable.
     */
    protected $Transferable<?> transferable;
    /**
     * Le type d'envoi : texte/audio/document/image... afin d'effectuer le bon
     * traitement
     */
    // TODO change to Enumeration
    protected String type;

    /**
     * The constructor.
     */
    public $Requete(T u, String type) {
	super();
	this.utilisateur = u;
	this.type = type;
    }

    /**
     * The constructor.
     */
    // TODO supp ?
    public $Requete() {
	super();
    }

    /**
     * Returns $Utilisateur.
     * 
     * @return $Utilisateur
     */
    public T getUtilisateur() {
	return this.utilisateur;
    }

    /**
     * Sets a value to attribute $Utilisateur.
     * 
     * @param newUtilisateur
     */
    public void setUtilisateur(T newUtilisateur) throws NotNullException {
	if (newUtilisateur == null)
	    throw new NotNullException("$Utilisateur", "setUtilisateur");
	this.utilisateur = newUtilisateur;
    }

    /**
     * Returns transferable.
     * 
     * @return transferable
     */
    protected $Transferable<?> getTransferable() {
	return this.transferable;
    }

    /**
     * Sets a value to attribute transferable.
     * 
     * @param <T>
     * @param <T>
     * 
     * @param contenu
     * @throws NotNullException
     */
    protected void setTransferable(Object contenu, ZonePartageSimple zone)
	    throws NotNullException {
	// TODO changer type object en plus générique
	if (this.type == "texte") {
	    this.transferable = new Texte<Object>(zone);
	}
	if (this.type == "image") {
	    try {
		this.transferable = new Image(zone, (String) contenu);
	    } catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }
	}
	if (this.type == "document") {
	    this.transferable = new Document(zone, (String) contenu);
	}
	if (this.type == "video") {
	    this.transferable = new Video(zone, (URL) contenu);
	}
	if (this.type == "plannig") {
	    return;
	}
	if (this.type == "audio") {
	    try {
		this.transferable = new Audio(zone, (String) contenu);
	    } catch (MalformedURLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }
	}
	this.transferable.setContenu(contenu);
    }

}
