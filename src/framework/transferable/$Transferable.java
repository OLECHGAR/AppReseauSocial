package framework.transferable;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import framework.utilisateur.*;
import framework.zonesPartage.*;
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
	protected ArrayList<$Requete<? extends $Utilisateur>> requetes = new ArrayList<$Requete<? extends $Utilisateur>>();

	protected T contenu;

	protected Date heure;

	/**
	 * Constructeur de $Transferable
	 * 
	 * @param zone
	 *            (La zone où sera le $Transferable)
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
	public ArrayList<$Requete<?>> getRequetes() {
		return this.requetes;
	}

	/**
	 * Ajoute la $Requete passée en paramètre dans la liste de requetes
	 * 
	 * @param requete
	 * @throws NotNullException
	 * @ensure requeteAjoutee(requete) == true
	 */
	public void addRequete($Requete<?> requete) throws NotNullException {
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
		if (contenu == null)
			throw new NotNullException("contenu", "setContenu");
		this.contenu = (T) contenu;
		if (this.contenu != contenu)
			throw new Ensure("getContenu() == contenu", "seContenu");
	}

	/**
	 * Retourne l'utilisateur qui a envoyé le $Transferable (qui est donc le
	 * proprétaire)
	 * 
	 * @return ? extends $Utilisateur
	 * @throws NotNullException
	 * @require this.requetes.size()>0
	 */
	public <T extends $Utilisateur> T getProprietaire() {
		if (this.requetes == null)
			throw new NotNullException("$Transferable.requetes", "$Transferable.getProprietaire");
		if (this.requetes.size() == 0)
			throw new Require("requetes.size()>0 ", "$Transferable.getProprietaire");
		Iterator<$Requete<?>> it = this.requetes.iterator();
		while (it.hasNext()) {
			$Requete<?> requete = it.next();
			if (requete.getClass() == new Envoi().getClass()) {
				return (T) requete.getUtilisateur();
			}
		}
		return null;
	}

	/**
	 * Retourne l'heure à laquelle le message a été envoyé
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
	 * Vérifie si la requete passée en paramètre appartient à la liste de requete du
	 * $Transferable
	 * 
	 * @param requete
	 * @return boolean
	 */
	protected boolean requeteAjoutee($Requete<?> requete) {
		Iterator<$Requete<?>> it = this.requetes.iterator();
		while (it.hasNext()) {
			$Requete<?> r = it.next();
			if (requete == r)
				return true;
		}
		return false;
	}
}
