package framework.autorisation;

/**
 * Description of AutorisationZone.
 * 
 * @author pignardf
 */
public class AutorisationUtilisateur implements Autorisation {
    private boolean ecriture;
    private boolean lecture;

    /**
     * The constructor.
     */
    public AutorisationUtilisateur() {
	super();
	this.setEcriture(false);
	this.setLecture(true);
    }

    /**
     * Autorisation en écriture.
     * 
     * @return true si on a le droit d'écrit sinon false.
     */
    public boolean isEcriture() {
	return this.ecriture;
    }

    /**
     * Change l'autorisation en écriture.
     * 
     * @param ecriture
     */
    public void setEcriture(boolean ecriture) {
	this.ecriture = ecriture;
    }

    /**
     * Autorisation en lecture.
     * 
     * @return true si on a le droit de lire sinon false.
     */
    public boolean isLecture() {
	return this.lecture;
    }

    /**
     * Change l'autorisation en lecture.
     * 
     * @param lecture
     */
    public void setLecture(boolean lecture) {
	this.lecture = lecture;
    }
}
