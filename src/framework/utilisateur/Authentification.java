/*******************************************************************************
 * 2018, All rights reserved.
 *******************************************************************************/
package framework.utilisateur;
// Start of user code (user defined imports)

// End of user code

/**
 * Description of Authentification.
 * 
 * @author monbeigj
 */
public class Authentification {
	/**
	 * Description of the property user.
	 */
	private Utilisateur user = null;

	// Start of user code (user defined attributes for Authentification)

	// End of user code

	/**
	 * The constructor.
	 */
	public Authentification() {
		// Start of user code constructor for Authentification)
		super();
		// End of user code
	}

	// Start of user code (user defined methods for Authentification)

	// End of user code
	/**
	 * Returns user.
	 * @return user 
	 */
	public Utilisateur getUser() {
		return this.user;
	}

	/**
	 * Sets a value to attribute user. 
	 * @param newUser 
	 */
	public void setUser(Utilisateur newUser) {
		if (this.user != null) {
			this.user = null;
		}
		this.user = newUser;
	}

}
