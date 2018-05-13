package framework.exception;

/**
 * Description of Invariant.
 * 
 * @author monbeigj
 *
 */
public class NotNullException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    /**
     * 
     * @param message
     * @param methode
     */
    public NotNullException(String message, String methode) {
	super("\nShould not be null : " + message + "\nMéthode : " + methode);
    }

}
