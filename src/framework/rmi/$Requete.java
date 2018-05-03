package framework.rmi;

/*******************************************************************************
 * 2018, All rights reserved.
 *******************************************************************************/
import framework.utilisateur.*;

import java.awt.datatransfer.Transferable;

import framework.exception.NotNullException;
import framework.transferable.*;
// Start of user code (user defined imports)

// End of user code

/**
 * Description of Requete.
 * 
 * @author monbeigj
 */
public abstract class $Requete {
	/**
	 * Description of the property utilisateur.
	 */
	private Utilisateur utilisateur = null;

	/**
	 * Description of the property transferable.
	 */
	private $Transferable<? extends Transferable> transferable = null;

	// Start of user code (user defined attributes for Requete)

	// End of user code

	/**
	 * The constructor.
	 */
	public $Requete() {
		// Start of user code constructor for Requete)
		super();
		// End of user code
	}

	// Start of user code (user defined methods for Requete)

	// End of user code

	/**
	 * 
	 */
	public void envoyer() {
		// -----------------------------------------TO DOOOOOOOOOOOOoooooo
	}

	/**
	 * 
	 */
	public void receptioner() {
		// -----------------------------------------TO DOOOOOOOOOOOOoooooo
	}

	/**
	 * Returns utilisateur.
	 * 
	 * @return utilisateur
	 */
	public Utilisateur getUtilisateur() {
		return this.utilisateur;
	}

	/**
	 * Sets a value to attribute utilisateur.
	 * 
	 * @param newUtilisateur
	 */
	public void setUtilisateur(Utilisateur newUtilisateur) throws NotNullException {
		if (newUtilisateur == null)
			throw new NotNullException("Utilisateur");
		this.utilisateur = newUtilisateur;
	}

	/**
	 * Returns transferable.
	 * 
	 * @return transferable
	 */
	protected $Transferable getTransferable() {
		return this.transferable;
	}

	/**
	 * Sets a value to attribute transferable.
	 * 
	 * @param contenu
	 */
	protected <T extends Transferable> void setTransferable(T contenu) throws NotNullException {
		if (contenu == null)
			throw new NotNullException("Transferable");
		this.transferable = (($Transferable<? extends Transferable>) contenu);
	}
}
