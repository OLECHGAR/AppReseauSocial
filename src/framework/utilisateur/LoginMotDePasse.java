package framework.utilisateur;

import framework.exception.NotNullException;
import framework.zonesPartages.ZonePartageSimple;

/**
 * Description of LoginMotDePasse.
 * 
 * @author monbeigj
 */
public class LoginMotDePasse<T extends ZonePartageSimple> implements
	Authentification {
    /**
     * Description of the property user.
     */
    private $Utilisateur<T> user = null;

    /**
     * The constructor.
     */
    public LoginMotDePasse(String login, String mdp) {
	super();
    }

    /**
     * Returns user.
     * 
     * @return user
     */
    public $Utilisateur<T> getUser() {
	return this.user;
    }

    /**
     * Sets a value to attribute user.
     * 
     * @param newUser
     */
    public void setUser($Utilisateur<T> newUser) throws NotNullException {
	if (newUser == null)
	    throw new NotNullException("$Utilisateur newUser", "setUser");
	this.user = newUser;
    }
}
