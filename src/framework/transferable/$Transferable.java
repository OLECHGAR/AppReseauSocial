package framework.transferable;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import framework.exception.Ensure;
import framework.exception.NotNullException;
import framework.exception.Require;
import framework.rmi.$Requete;
import framework.rmi.Envoi;
import framework.utilisateur.$Utilisateur;
import framework.zonesPartages.ZonePartageSimple;

/**
 * Description of $Transferable.
 * 
 * @author monbeigj
 */
public abstract class $Transferable<T> implements java.io.Serializable {
    /**
     * Description of the property ZonesPartages.
     */
    protected final ZonePartageSimple ZonePartage; // TODO NOT NULL
    protected int id;
    /**
     * Description of the property requetes.
     */
    protected ArrayList<$Requete<? extends $Utilisateur<?>>> requetes = new ArrayList<$Requete<? extends $Utilisateur<?>>>();

    protected T contenu;

    protected Date heure;

    /**
     * Constructeur de $Transferable
     * 
     * @param zone
     *            (La zone oï¿½ sera le $Transferable)
     * @throws NotNullException
     */
    public $Transferable(ZonePartageSimple zone) throws NotNullException {
	super();
	if (zone == null)
	    throw new NotNullException("ZonePartageSimple zone",
		    "$Transferable");
	this.heure = new Date();
	this.ZonePartage = zone;
    }

    /**
     * Constructeur de $Transferable
     * 
     * @param id
     * @param zone
     * @param contenu
     * @param heure
     * @throws NotNullException
     */
    public <Z extends ZonePartageSimple> $Transferable(int id, Z zone,
	    T contenu, Date heure) throws NotNullException {
	super();
	this.heure = heure;
	this.id = id;
	this.contenu = contenu;
	this.ZonePartage = zone;
    }

    /**
     * Returns ZonesPartages.
     * 
     * @return ZonesPartages
     */
    public ZonePartageSimple getZonePartage() {
	return this.ZonePartage;
    }

    /**
     * Permet de récupérer le contenu.
     * 
     * @return T le contenu
     */
    public T getContenu() {
	return this.contenu;
    }

    /**
     * Returns requetes.
     * 
     * @return requetes
     */
    public ArrayList<$Requete<? extends $Utilisateur<?>>> getRequetes() {
	return this.requetes;
    }

    /**
     * Ajoute la $Requete passï¿½e en paramï¿½tre dans la liste de requetes
     * 
     * @param requete
     * @throws NotNullException
     * @ensure requeteAjoutee(requete) == true
     */
    public void addRequete($Requete<? extends $Utilisateur<?>> requete)
	    throws NotNullException {
	if (requete == null)
	    throw new NotNullException("$Requete requete", "addRequete");
	this.requetes.add(requete);
	if (!(this.requeteAjoutee(requete)))
	    throw new Ensure("requeteAjoutee(requete) == true", "addRequete");
    }

    /**
     * Modifie le contenu du transferable
     * 
     * @param contenu
     * @throws NotNullException
     * @ensure this.contenu == contenu
     */
    public void setContenu(Object contenu) throws NotNullException {
	// TODO changer type object en plus gÃ©nÃ©rique
	// if (contenu == null)
	// throw new NotNullException("contenu", "setContenu");
	this.contenu = (T) contenu;
	if (this.contenu != contenu)
	    throw new Ensure("getContenu() == contenu", "seContenu");
    }

    /**
     * Retourne l'utilisateur qui a envoyï¿½ le $Transferable (qui est donc le
     * proprï¿½taire)
     * 
     * @return ? extends $Utilisateur
     * @throws NotNullException
     * @require this.requetes.size()>0
     */
    public <U extends $Utilisateur<?>> U getProprietaire() {
	if (this.requetes == null)
	    throw new NotNullException("$Transferable.requetes",
		    "$Transferable.getProprietaire");
	if (this.requetes.size() == 0)
	    throw new Require("requetes.size()>0 ",
		    "$Transferable.getProprietaire");
	Iterator<$Requete<? extends $Utilisateur<?>>> it = this.requetes
		.iterator();
	while (it.hasNext()) {
	    $Requete<?> requete = it.next();
	    if (requete.getClass() == new Envoi<$Utilisateur<?>>().getClass()) {
		return (U) requete.getUtilisateur();
	    }
	}
	return null;
    }

    /**
     * Retourne l'heure ï¿½ laquelle le message a ï¿½tï¿½ envoyï¿½
     * 
     * @return String
     */
    public String timeMessage() {
	if (this.heure == null)
	    throw new NotNullException("$Transferable.heure",
		    "$Transferable.timeMessage");
	DateFormat sdf = new SimpleDateFormat("HH:mm:ss");
	return sdf.format(this.heure);
    }

    /**
     * Vï¿½rifie si la requete passï¿½e en paramï¿½tre appartient ï¿½ la liste
     * de requete du $Transferable
     * 
     * @param requete
     * @return boolean
     */
    protected boolean requeteAjoutee($Requete<? extends $Utilisateur<?>> requete) {
	Iterator<$Requete<? extends $Utilisateur<?>>> it = this.requetes
		.iterator();
	while (it.hasNext()) {
	    $Requete<?> r = it.next();
	    if (requete == r)
		return true;
	}
	return false;
    }

    @Override
    public String toString() {
	return "" + this.heure + " : " + this.contenu;
    }

    public int getId() {
	return this.id;
    }
}
