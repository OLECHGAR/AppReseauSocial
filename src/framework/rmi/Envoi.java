package framework.rmi;

import framework.utilisateur.*;
import framework.zonesPartage.*;

import framework.exception.NotNullException;

/*******************************************************************************
 * 2018, All rights reserved.
 *******************************************************************************/

// Start of user code (user defined imports)

// End of user code

/**
 * Description of Envoie.
 * 
 * @author monbeigj
 */
public class Envoi extends $Requete {
	// Start of user code (user defined attributes for Envoie)
	// End of user code

	/**
	 * The constructor.
	 * @throws NotNullException 
	 */
	public Envoi(){
		super();
	}
	public <T> Envoi(T contenu, Utilisateur u, ZonePartageSimple zoneDestination, String type) throws NotNullException {
		// Start of user code constructor for Envoie)
		super(u, type);
		super.setTransferable(contenu, zoneDestination);
		super.transferable.addRequete(this);
		this.envoyer(zoneDestination);
		// End of user code
	}
	
	public void envoyer(ZonePartageSimple zone){
		if(super.type == "texte"){
			//this.envoyerTexte(zone);
		}
	}
	
	public void envoyerTexte(ZonePartageSimple zone){
		// Code permettant de faire l'appel serveur suivi d'un enregistrement en BDD
		try {
			zone.addTransferable(super.transferable);
		} catch (NotNullException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	// Start of user code (user defined methods for Envoie)

	// End of user code

}
