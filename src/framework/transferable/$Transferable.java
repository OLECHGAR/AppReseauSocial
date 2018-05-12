package framework.transferable;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import framework.utilisateur.*;
import framework.zonesPartages.*;
import framework.rmi.*;
import framework.exception.*;
/*******************************************************************************
 * 2018, All rights reserved.
 *******************************************************************************/

// Start of user code (user defined imports)

// End of user code

/**
 * Description of $Transferable.
 * 
 * @author monbeigj
 */
public abstract class $Transferable<T> {
	/**
	 * Description of the property ZonesPartages.
	 */
	protected final ZonePartageSimple ZonePartage; // NOT NULL

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
	 *            (La zone o� sera le $Transferable)
	 * @throws NotNullException
	 */
	public $Transferable(ZonePartageSimple zone) throws NotNullException {
		super();
		if (zone == null)
			throw new NotNullException("ZonePartageSimple zone", "$Transferable");
		this.heure = new Date();
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
	 * 
	 * @return T
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
	 * Ajoute la $Requete pass�e en param�tre dans la liste de requetes
	 * 
	 * @param requete
	 * @throws NotNullException
	 * @ensure requeteAjoutee(requete) == true
	 */
	public void addRequete($Requete<? extends $Utilisateur<?>> requete) throws NotNullException {
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
		//TODO changer type object en plus générique
		if (contenu == null)
			throw new NotNullException("contenu", "setContenu");
		this.contenu = (T) contenu;
		if (this.contenu != contenu)
			throw new Ensure("getContenu() == contenu", "seContenu");
	}

	/**
	 * Retourne l'utilisateur qui a envoy� le $Transferable (qui est donc le
	 * propr�taire)
	 * 
	 * @return ? extends $Utilisateur
	 * @throws NotNullException
	 * @require this.requetes.size()>0
	 */
	public $Utilisateur<?> getProprietaire() {
		if (this.requetes == null)
			throw new NotNullException("$Transferable.requetes", "$Transferable.getProprietaire");
		if (this.requetes.size() == 0)
			throw new Require("requetes.size()>0 ", "$Transferable.getProprietaire");
		Iterator<$Requete<? extends $Utilisateur<?>>> it = this.requetes.iterator();
		while (it.hasNext()) {
			$Requete<?> requete = it.next();
			if (requete.getClass() == new Envoi<$Utilisateur<?>>().getClass()) {
				return requete.getUtilisateur();
			}
		}
		return null;
	}

	/**
	 * Retourne l'heure � laquelle le message a �t� envoy�
	 * 
	 * @return String
	 */
	public String timeMessage() {
		if (this.heure == null)
			throw new NotNullException("$Transferable.heure", "$Transferable.timeMessage");
		DateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		return sdf.format(this.heure);
	}

	/**
	 * V�rifie si la requete pass�e en param�tre appartient � la liste de requete du
	 * $Transferable
	 * 
	 * @param requete
	 * @return boolean
	 */
	protected boolean requeteAjoutee($Requete<? extends $Utilisateur<?>> requete) {
		Iterator<$Requete<? extends $Utilisateur<?>>> it = this.requetes.iterator();
		while (it.hasNext()) {
			$Requete<?> r = it.next();
			if (requete == r)
				return true;
		}
		return false;
	}
}
