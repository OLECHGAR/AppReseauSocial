package framework.transferable;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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
	protected ArrayList<$Requete> requetes = new ArrayList<$Requete>();

	protected T contenu;

	protected Date heure;

	/**
	 * The constructor.
	 * 
	 * @throws NotNullException
	 */
	public $Transferable(ZonePartageSimple zone) throws NotNullException {
		super();
		if (zone == null)
			throw new NotNullException("ZonePartageSimple zone", "$Transferable");
		this.heure = new Date();
		this.ZonePartage = zone;
		this.ZonePartage.addTransferable(this);
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
	 * @return
	 */
	public T getContenu() {
		return this.contenu;
	}

	/**
	 * Returns requetes.
	 * 
	 * @return requetes
	 */
	public ArrayList<$Requete> getRequetes() {
		return this.requetes;
	}

	/**
	 * 
	 * @param requete
	 */
	public void addRequete($Requete requete) throws NotNullException {
		if (requete == null)
			throw new NotNullException("$Requete requete", "addRequete");
		this.requetes.add(requete);
	}

	/**
	 * 
	 * @param contenu
	 * @throws NotNullException
	 */
	public void setContenu(T contenu) throws NotNullException {
		if (contenu == null)
			throw new NotNullException("contenu", "setContenu");
		this.contenu = contenu;
	}

	/**
	 * 
	 * @return
	 */
	public Utilisateur getProprietaire() {
		for (int i = 0; i < this.requetes.size(); i++) {
			if (this.requetes.get(i).getClass() == new Envoi().getClass())
				return this.requetes.get(i).getUtilisateur();
		}
		return null;
	}

	/**
	 * 
	 * @return
	 */
	public String timeMessage() {
		DateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		return sdf.format(this.heure);
	}

}
