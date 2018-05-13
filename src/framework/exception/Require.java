package framework.exception;

/**
 * Description of Invariant.
 * 
 * @author monbeigj
 *
 */
public class Require extends RuntimeException {

    private static final long serialVersionUID = 1L;

    /**
     * 
     * @param message
     * @param methode
     */
    public Require(String message, String methode) {
	super("\nRequire : " + message + "\nMéthode : " + methode);
    }

}