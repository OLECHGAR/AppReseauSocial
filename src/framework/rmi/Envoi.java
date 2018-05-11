package framework.rmi;

/*******************************************************************************
 * 2018, All rights reserved.
 *******************************************************************************/

// Start of user code (user defined imports)
import framework.exception.NotNullException;
import framework.utilisateur.$Utilisateur;
import framework.zonesPartages.ZonePartageSimple;

// End of user code

/**
 * Description of Envoie.
 * 
 * @author monbeigj
 */
public class Envoi<T extends $Utilisateur> extends $Requete<T> {
    // Start of user code (user defined attributes for Envoie)
    // End of user code

    /**
     * The constructor.
     * 
     * @throws NotNullException
     */
    public Envoi() {
	super();
    }

    /**
     * 
     * @param contenu
     * @param u
     * @param zoneDestination
     * @param type
     * @throws NotNullException
     */
    public <C> Envoi(C contenu, T u, ZonePartageSimple zoneDestination,
	    String type) throws NotNullException {
	// Start of user code constructor for Envoie)
	super(u, type);
	super.setTransferable(contenu, zoneDestination);
	super.transferable.addRequete(this);
	this.envoyer(zoneDestination);
	// End of user code
    }

    // Start of user code (user defined methods for Envoie)

    /**
     * 
     * @param zone
     */
    public void envoyer(ZonePartageSimple zone) {
	if (super.type == "texte") {
	    this.envoyerTexte(zone);
	}
	if (super.type == "image") {
	    this.envoyerImage(zone);
	}
	if (super.type == "document") {
	    this.envoyerTexte(zone);
	}
	if (super.type == "video") {
	    this.envoyerTexte(zone);
	}
	if (super.type == "plannig") {
	    this.envoyerTexte(zone);
	}
	if (super.type == "audio") {
	    this.envoyerTexte(zone);
	}
    }

    /**
     * 
     * @param zone
     */
    public void envoyerTexte(ZonePartageSimple zone) {
	// Code permettant de faire l'appel serveur suivi d'un enregistrement en
	// BDD
	try {
	    zone.addTransferable(super.transferable);
	} catch (NotNullException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
    }

    /**
     * 
     * @param zone
     */
    public void envoyerImage(ZonePartageSimple zone) {
	// Code permettant de faire l'appel serveur suivi d'un enregistrement en
	// BDD
	try {
	    zone.addTransferable(super.transferable);
	} catch (NotNullException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
    }

    /**
     * 
     * @param zone
     */
    public void envoyerDocument(ZonePartageSimple zone) {
	// Code permettant de faire l'appel serveur suivi d'un enregistrement en
	// BDD
	try {
	    zone.addTransferable(super.transferable);
	} catch (NotNullException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
    }

    /**
     * 
     * @param zone
     */
    public void envoyerVideo(ZonePartageSimple zone) {
	// Code permettant de faire l'appel serveur suivi d'un enregistrement en
	// BDD
	try {
	    zone.addTransferable(super.transferable);
	} catch (NotNullException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
    }

    /**
     * 
     * @param zone
     */
    public void envoyerPlanning(ZonePartageSimple zone) {
	// Code permettant de faire l'appel serveur suivi d'un enregistrement en
	// BDD
	try {
	    zone.addTransferable(super.transferable);
	} catch (NotNullException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
    }

    /**
     * 
     * @param zone
     */
    public void envoyerAudio(ZonePartageSimple zone) {
	// Code permettant de faire l'appel serveur suivi d'un enregistrement en
	// BDD
	try {
	    zone.addTransferable(super.transferable);
	} catch (NotNullException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
    }
    // End of user code

}
