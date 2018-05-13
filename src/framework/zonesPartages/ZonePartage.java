package framework.zonesPartages;

// Start of user code (user defined imports)

import java.util.ArrayList;
import java.util.Iterator;

import framework.exception.Ensure;
import framework.exception.Invariant;
import framework.exception.NotNullException;
import framework.utilisateur.$Utilisateur;

// End of user code

/**
 * Description of ZonePartage.
 * 
 * @author monbeigj
 */
public class ZonePartage extends ZonePartageSimple {
    // Start of user code (user defined attributes for ZonePartage)
    /**
     * Description of the property messages.
     */
    protected ArrayList<? extends $Utilisateur<?>> utilisateursAutorises;
    protected $Utilisateur<?> proprietaire;
    protected boolean estPrivee;
    protected String nom;

    // End of user code
    /**
     * Constructeur d'une zone priv�e sans Propri�taire (pour un chat
     * priv� entre 2 personnes cr�� par d�faut par exemple)
     * 
     * @param utilisateursAutorises
     * @throws NotNullException
     */
    public ZonePartage(
	    ArrayList<? extends $Utilisateur<?>> utilisateursAutorises)
	    throws NotNullException {
	super();
	if (utilisateursAutorises == null)
	    throw new NotNullException("utilisateursAutorises",
		    "ZonePartage.ZonePartage");
	this.proprietaire = null;
	this.estPrivee = true;
	this.utilisateursAutorises = utilisateursAutorises;
	this.ajouterUtilisateurs(utilisateursAutorises);
    }

    /**
     * Constructeur d'une zone publique avec un nom
     * 
     * @param proprietaire
     * @throws NotNullException
     */
    public ZonePartage($Utilisateur<?> proprietaire, String nom)
	    throws NotNullException {
	super();
	if (proprietaire == null)
	    throw new NotNullException("$Utilisateur proprietaire",
		    "ZonePartage.ZonePartage");
	this.proprietaire = proprietaire;
	this.estPrivee = false;
	if (nom == null)
	    this.nom = "";
	else
	    this.nom = nom;
    }

    /**
     * Constructeur d'une zone priv�e avec une liste d'utilisateurs
     * autoris�s � la lire et �crire.
     * 
     * @param proprietaire
     * @param utilisateursAutorises
     * @throws NotNullException
     */
    public <U extends $Utilisateur<Z>, Z extends ZonePartageSimple> ZonePartage(
	    U proprietaire, ArrayList<U> utilisateursAutorises)
	    throws NotNullException {
	super();
	if (proprietaire == null)
	    throw new NotNullException("$Utilisateur proprietaire",
		    "ZonePartage.ZonePartage");
	this.proprietaire = proprietaire;
	this.estPrivee = true;
	this.utilisateursAutorises = utilisateursAutorises;
	this.ajouterUtilisateurs(utilisateursAutorises);
    }

    /**
     * Constructeur d'une zone priv�e avec une liste d'utilisateurs
     * autoris�s � la lire et �crire avec un nom.
     * 
     * @param proprietaire
     * @param utilisateursAutorises
     * @param nom
     * @throws NotNullException
     */
    public <U extends $Utilisateur<Z>, Z extends ZonePartageSimple> ZonePartage(
	    U proprietaire, ArrayList<U> utilisateursAutorises, String nom)
	    throws NotNullException {
	super();
	if (proprietaire == null)
	    throw new NotNullException("$Utilisateur proprietaire",
		    "ZonePartage.ZonePartage");
	this.proprietaire = proprietaire;
	this.estPrivee = true;
	this.utilisateursAutorises = utilisateursAutorises;
	this.nom = nom;
	this.ajouterUtilisateurs(utilisateursAutorises);
    }

    // Start of user code (user defined methods for ZonePartage)
    /**
     * Renvoie le propri�taire de la zone.
     * 
     * @return prorietaire
     */
    public $Utilisateur<?> getProprietaire() {
	return this.proprietaire;
    }

    /**
     * Modifie le propri�taire de la Zone
     * 
     * @param proprietaire
     * @throws NotNullException
     * @ensure this.proprietaire == proprietaire
     */
    public void setProprietaire($Utilisateur<?> proprietaire)
	    throws NotNullException {
	if (proprietaire == null)
	    throw new NotNullException("$Utilisateur propriétaire",
		    "ZonePartage.setProprietaire");
	this.proprietaire = proprietaire;
	if (this.proprietaire != proprietaire)
	    throw new Ensure("this.proprietaire == proprietaire",
		    "ZonePartage.setProprietaire");
    }

    /**
     * Ajoute une liste d'utilisateur � autoriser
     * 
     * @param $Utilisateurs
     * @throw NotNullException
     * @invariant estAjoute(it.next()) == true
     */
    public void ajouterUtilisateurs(
	    ArrayList<? extends $Utilisateur<?>> utililsateurs) {
	if (utililsateurs == null)
	    throw new NotNullException("utilisateurs",
		    "ZonePartage.ajouterUtilisateurs");
	Iterator<? extends $Utilisateur<?>> it = utililsateurs.iterator();
	while (it.hasNext()) {
	    if (!(this.estAjoute(it.next())))
		throw new Invariant("estAjoute(it.next()) == true",
			"ZonePartage.ajouterUtilisateur");
	}
    }

    /**
     * V�rifie si un utilisateur appartient � la liste des utilisateurs
     * autoris�s Ajoute et vérifie si utilisateur est bien ajouté à la
     * liste
     * 
     * @param utilisateur
     * @return boolean
     * @throw NotNullException
     */
    public <T extends ZonePartageSimple> boolean estAjoute(
	    $Utilisateur<T> utilisateur) {
	if (utilisateur == null)
	    throw new NotNullException("utilisateur", "ZonePartage.estAutorise");
	utilisateur.rejoindreZone((T) this);
	Iterator<? extends $Utilisateur<?>> it = this.utilisateursAutorises
		.iterator();
	while (it.hasNext()) {
	    if (it.next() == utilisateur)
		return true;
	}
	return false;
    }

    /**
     * Retourne la liste des utilisateurs autoris�s
     * 
     * @return ArrayList<? extends $Utilisateur>
     */
    public ArrayList<? extends $Utilisateur<?>> getUtilisateursAutorises() {
	return this.utilisateursAutorises;
    }

    /**
     * Modifie la visibilit� de la zone en publique
     * 
     * @return boolean
     * @ensure this.estPrivee == false
     */
    public boolean setPublique() {
	if (this.estPrivee == false)
	    return false;
	// TODO check is OK
	this.utilisateursAutorises = new ArrayList<$Utilisateur<?>>();
	this.estPrivee = false;
	if (this.estPrivee != false)
	    throw new Ensure("estPrivee == false", "ZonePartage.setPublique");
	return true;
    }

    /**
     * Modifie la visibilit� de la zone en priv�e
     * 
     * @return boolean
     * @ensure this.estPrivee == true
     */
    public boolean setPrivee(
	    ArrayList<? extends $Utilisateur<?>> utilisateursAutorises) {
	if (utilisateursAutorises == null)
	    throw new NotNullException("utilisateursAutorises",
		    "ZonePartage.setPrivee");
	if (this.estPrivee == true)
	    return false;
	this.utilisateursAutorises = utilisateursAutorises;
	this.ajouterUtilisateurs(utilisateursAutorises);
	this.estPrivee = true;
	if (this.estPrivee != true)
	    throw new Ensure("estPrivee == true", "ZonePartage.setPrivee");
	return true;
    }

    /**
     * Renvoie le nom de la zone.
     * 
     * @return
     */
    public String getNom() {
	return this.nom;
    }

    /**
     * Change le nom de la zone.
     * 
     * @param nom
     */
    public void setNom(String nom) {
	this.nom = nom;
    }

    /**
     * Renvoie la visibilit�e de la zone.
     * 
     * @return
     */
    public boolean getPrivacy() {
	return this.estPrivee;
    }

    // End of user code

}
