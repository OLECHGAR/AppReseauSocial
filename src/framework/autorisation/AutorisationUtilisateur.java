package framework.autorisation;

//Start of user code (user defined imports)

//End of user code

/*******************************************************************************
* 2018, All rights reserved.
*******************************************************************************/

/**
 * Description of AutorisationZone.
 * 
 * @author pignardf
 */
public class AutorisationUtilisateur implements Autorisation {
	// Start of user code (user defined attributes for AutorisationUtilisateur)
	private boolean ecriture;
	private boolean lecture;

	// End of user code

	/**
	 * The constructor.
	 */
	public AutorisationUtilisateur() {
		// Start of user code constructor for AutorisationUtilisateur)
		super();
		setEcriture(false);
		setLecture(true);
		// End of user code
	}

	public boolean isEcriture() {
		return ecriture;
	}

	public void setEcriture(boolean ecriture) {
		this.ecriture = ecriture;
	}

	public boolean isLecture() {
		return lecture;
	}

	public void setLecture(boolean lecture) {
		this.lecture = lecture;
	}

	// Start of user code (user defined methods for AutorisationUtilisateur)

	// End of user code
}
