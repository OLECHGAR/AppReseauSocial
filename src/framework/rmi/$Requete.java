package framework.rmi;

/*******************************************************************************
 * 2018, All rights reserved.
 *******************************************************************************/
import framework.utilisateur.*;
import framework.zonesPartage.ZonePartageSimple;
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
	protected Utilisateur utilisateur;

	/**
	 * Description of the property transferable.
	 */
	protected $Transferable<Object> transferable;
	// Le type d'envoi : texte/audio/document/image... afin d'effectuer le bon
	// traitement
	protected String type;
	// Start of user code (user defined attributes for Requete)

	// End of user code

	/**
	 * The constructor.
	 */
	public $Requete(Utilisateur u, String type) {
		// Start of user code constructor for Requete)
		super();
		utilisateur = u;
		this.type = type;
		// End of user code
	}

	/**
	 * 
	 */
	public $Requete() {
		super();
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
			throw new NotNullException("Utilisateur", "setUtilisateur");
		this.utilisateur = newUtilisateur;
	}

	/**
	 * Returns transferable.
	 * 
	 * @return transferable
	 */
	protected $Transferable<Object> getTransferable() {
		return this.transferable;
	}

	/**
	 * Sets a value to attribute transferable.
	 * 
	 * @param <T>
	 * @param <T>
	 * 
	 * @param contenu
	 * @throws NotNullException
	 */
	protected <T> void setTransferable(T contenu, ZonePartageSimple zone) throws NotNullException {
		if (this.type == "texte") {
			this.transferable = new Texte<Object>(zone);
		}
		this.transferable.setContenu(contenu);
	}

}
