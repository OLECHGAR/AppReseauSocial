package framework.rmi;

import framework.exception.NotNullException;
import framework.utilisateur.$Utilisateur;
import framework.zonesPartages.ZonePartageSimple;

/**
 * Description of Envoie.
 * 
 * @author monbeigj
 */
public class Envoi<T extends $Utilisateur<?>> extends $Requete<T> {
    /**
     * The constructor.
     * 
     * @throws NotNullException
     */
    // TODO supp ?
    public Envoi() {
	super();
    }

    /**
     * The constructor.
     * 
     * @param contenu
     * @param u
     * @param zoneDestination
     * @param type
     * @throws NotNullException
     */
    public <C> Envoi(C contenu, T u, ZonePartageSimple zoneDestination,
	    String type) throws NotNullException {
	super(u, type);
	super.setTransferable(contenu, zoneDestination);
	super.transferable.addRequete(this);
	this.envoyer(zoneDestination);
    }

    /**
     * Permet d'envoyer le transferable vers la zone.
     * 
     * @param zone
     */
    // TODO change String constante to Enumération
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
     * Permet d'envoyer le texte vers la zone. Code permettant de faire l'appel
     * serveur suivi d'un enregistrement en BDD
     * 
     * @param zone
     */
    public void envoyerTexte(ZonePartageSimple zone) {
	try {
	    zone.addTransferable(super.transferable);
	} catch (NotNullException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
    }

    /**
     * Permet d'envoyer l'image vers la zone. Code permettant de faire l'appel
     * serveur suivi d'un enregistrement en BDD
     * 
     * @param zone
     */
    public void envoyerImage(ZonePartageSimple zone) {
	try {
	    zone.addTransferable(super.transferable);
	} catch (NotNullException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
    }

    /**
     * Permet d'envoyer le document vers la zone. Code permettant de faire
     * l'appel serveur suivi d'un enregistrement en BDD
     * 
     * @param zone
     */
    public void envoyerDocument(ZonePartageSimple zone) {
	try {
	    zone.addTransferable(super.transferable);
	} catch (NotNullException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
    }

    /**
     * Permet d'envoyer la vidéo vers la zone. Code permettant de faire l'appel
     * serveur suivi d'un enregistrement en BDD
     * 
     * @param zone
     */
    public void envoyerVideo(ZonePartageSimple zone) {
	try {
	    zone.addTransferable(super.transferable);
	} catch (NotNullException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
    }

    /**
     * Permet d'envoyer le planning vers la zone. Code permettant de faire
     * l'appel serveur suivi d'un enregistrement en BDD
     * 
     * @param zone
     */
    public void envoyerPlanning(ZonePartageSimple zone) {
	try {
	    zone.addTransferable(super.transferable);
	} catch (NotNullException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
    }

    /**
     * Permet d'envoyer le fichier audio vers la zone. Code permettant de faire
     * l'appel serveur suivi d'un enregistrement en BDD
     * 
     * @param zone
     */
    public void envoyerAudio(ZonePartageSimple zone) {
	try {
	    zone.addTransferable(super.transferable);
	} catch (NotNullException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
    }

}
