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
 * Description of $ZonePartage.
 * 
 * @author monbeigj
 */
public abstract class $ZonePartage {
	/**
	 * Description of the property utilisateurs.
	 */
	private ArrayList<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();

	/**
	 * Description of the property messages.
	 */
	private ArrayList<_Transferable> messages = new ArrayList<_Transferable>();
	private Utilisateur proprietaire;
	// Start of user code (user defined attributes for $ZonePartage)

	// End of user code

	/**
	 * The constructor.
	 */
	public $ZonePartage() {
		// Start of user code constructor for $ZonePartage)
		super();
		// End of user code
	}
	
	public $ZonePartage(Utilisateur proprietaire){
		super();
		this.proprietaire = proprietaire;
	}

	// Start of user code (user defined methods for $ZonePartage)

	// End of user code
	/**
	 * Returns utilisateurs.
	 * @return utilisateurs 
	 */
	public ArrayList<Utilisateur> getUtilisateurs() {
		return this.utilisateurs;
	}

	/**
	 * Returns messages.
	 * @return messages 
	 */
	public ArrayList<_Transferable> getMessages() {
		return this.messages;
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

}
