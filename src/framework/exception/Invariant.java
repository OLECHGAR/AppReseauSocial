package framework.exception;

/**
 * Description of Invariant.
 * 
 * @author monbeigj
 *
 */
public class Invariant extends RuntimeException {

    private static final long serialVersionUID = 1L;

    /**
     * 
     * @param message
     * @param methode
     */
    public Invariant(String message, String methode) {
	super("\nInvariant : " + message + "\nMéthode : " + methode);
    }

}