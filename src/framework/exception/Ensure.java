package framework.exception;

/**
 * Description of Invariant.
 * 
 * @author monbeigj
 *
 */
public class Ensure extends RuntimeException {

    private static final long serialVersionUID = 1L;

    /**
     * 
     * @param message
     * @param methode
     */
    public Ensure(String message, String methode) {
	super("\nEnsure : " + message + "\nMéthode : " + methode);
    }

}