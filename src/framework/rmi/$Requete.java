package framework.rmi;

/*******************************************************************************
 * 2018, All rights reserved.
 *******************************************************************************/
import framework.utilisateur.*;
import framework.zonesPartages.ZonePartageSimple;
import framework.exception.NotNullException;
import framework.transferable.*;
// Start of user code (user defined imports)

// End of user code

/**
 * Description of Requete.
 * 
 * @author monbeigj
 */
public abstract class $Requete<T extends $Utilisateur> {
	/**
	 * Description of the property $Utilisateur.
	 */
	protected T utilisateur;

	/**
	 * Description of the property transferable.
	 */
	protected $Transferable<?> transferable;
	// Le type d'envoi : texte/audio/document/image... afin d'effectuer le bon
	// traitement
	protected String type;
	// Start of user code (user defined attributes for Requete)

	// End of user code

	/**
	 * The constructor.
	 */
	public $Requete(T u, String type) {
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
	 * Returns $Utilisateur.
	 * 
	 * @return $Utilisateur
	 */
	public T getUtilisateur() {
		return this.utilisateur;
	}

	/**
	 * Sets a value to attribute $Utilisateur.
	 * 
	 * @param newUtilisateur
	 */
	public void setUtilisateur(T newUtilisateur) throws NotNullException {
		if (newUtilisateur == null)
			throw new NotNullException("$Utilisateur", "setUtilisateur");
		this.utilisateur = newUtilisateur;
	}

	/**
	 * Returns transferable.
	 * 
	 * @return transferable
	 */
	protected $Transferable<?> getTransferable() {
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
	protected void setTransferable(Object contenu, ZonePartageSimple zone) throws NotNullException {
		//TODO changer type object en plus générique
		if (this.type == "texte") {
			this.transferable = new Texte<Object>(zone);
		}
		this.transferable.setContenu(contenu);
	}

}
