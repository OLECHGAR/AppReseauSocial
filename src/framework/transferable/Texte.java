package framework.transferable;

import java.util.Date;

import application.Utilisateur;
import framework.exception.NotNullException;
import framework.zonesPartages.ZonePartageSimple;

/**
 * Description of Texte.
 * 
 * @author monbeigj
 * @param <T>
 */
public class Texte<String> extends $Transferable<String> {

    /**
     * The constructor.
     * 
     * @throws NotNullException
     */
    private Utilisateur proprietaire;

    public Texte(ZonePartageSimple zone) throws NotNullException {
	super(zone);
    }

    /**
     * The constructor.
     * 
     * @param id
     * @param zone
     * @param contenu
     * @param heure
     */
    public <Z extends ZonePartageSimple> Texte(int id, Z zone, String contenu,
	    Date heure) {
	super(id, zone, contenu, heure);
    }

    /**
     * The constructor.
     * 
     * @param id
     * @param zone
     * @param contenu
     * @param heure
     * @param proprietaire
     */
    public <Z extends ZonePartageSimple> Texte(int id, Z zone, String contenu,
	    Date heure, Utilisateur proprietaire) {
	super(id, zone, contenu, heure);
	this.proprietaire = proprietaire;
    }

    /**
     * Permet de récupérer le propriétaire.
     * 
     * @return
     */
    @Override
    public Utilisateur getProprietaire() {
	return this.proprietaire;
    }

    @Override
    public java.lang.String toString() {
	System.out.println(super.contenu.toString());
	return "" + this.timeMessage() + " " + this.proprietaire.getLogin()
		+ " : " + this.contenu;
    }
}