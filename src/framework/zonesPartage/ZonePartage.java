/*******************************************************************************
 * 2018, All rights reserved.
 *******************************************************************************/
package framework.zonesPartage;
// Start of user code (user defined imports)

import java.util.ArrayList;
import framework.utilisateur.*;
import framework.transferable.*;

// End of user code

/**
 * Description of ZonePartage.
 * 
 * @author monbeigj
 */
public class ZonePartage {
	

	/**
	 * Description of the property messages.
	 */
	private ArrayList<Utilisateur> utilisateursAutorises = new ArrayList<Utilisateur>();
	private ArrayList<$Transferable> transferables = new ArrayList<$Transferable>();
	private Utilisateur proprietaire;
	private boolean estPrivee;
	// Start of user code (user defined attributes for ZonePartage)

	// End of user code

	/**
	 * The constructor.
	 */
	public ZonePartage() {
	}
	
	public ZonePartage(Utilisateur proprietaire){
		super();
		this.proprietaire = proprietaire;
		this.estPrivee = false;
	}
	
	public ZonePartage(Utilisateur proprietaire, ArrayList<Utilisateur> utilisateursAutorises){
		this.proprietaire = proprietaire;
		this.estPrivee = true;
		this.utilisateursAutorises = utilisateursAutorises;
	}

	/**
	 * Returns messages.
	 * @return messages 
	 */
	public ArrayList<$Transferable> getTransferables() {
		return this.transferables;
	}
	
	/**
	 * @return prorietaire
	 */
	public Utilisateur getProprietaire(){
		return this.proprietaire;
	}
	
	public void setProprietaire(Utilisateur proprietaire){
		this.proprietaire = proprietaire;
	}
	
	public boolean setPublique(){
		if(this.estPrivee != true)
			return false;
		this.estPrivee = false;
		return true;
	}
	
	public boolean setPrivee(){
		if(this.estPrivee != false)
			return false;
		this.estPrivee = true;
		return true;
	}
	
	public void addTransferable($Transferable transferable){
		this.transferables.add(transferable);
	}
	
	

}
