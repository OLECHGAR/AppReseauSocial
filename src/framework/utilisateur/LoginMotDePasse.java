/*******************************************************************************
 * 2018, All rights reserved.
 *******************************************************************************/
package framework.utilisateur;
// Start of user code (user defined imports)

import framework.exception.NotNullException;

// End of user code

/**
 * Description of LoginMotDePasse.
 * 
 * @author monbeigj
 */
public class LoginMotDePasse implements Auhentification {
	/**
	 * Description of the property user.
	 */
	private Utilisateur user = null;

	// Start of user code (user defined attributes for LoginMotDePasse)

	// End of user code

	/**
	 * The constructor.
	 */
	public LoginMotDePasse(String login, String mdp) {
		// Start of user code constructor for LoginMotDePasse)
		super();

		// End of user code
	}

	// Start of user code (user defined methods for LoginMotDePasse)

	// End of user code
	/**
	 * Returns user.
	 * 
	 * @return user
	 */
	public Utilisateur getUser() {
		return this.user;
	}

	/**
	 * Sets a value to attribute user.
	 * 
	 * @param newUser
	 */
	public void setUser(Utilisateur newUser) throws NotNullException {
		if (newUser == null)
			throw new NotNullException("Utilisateur");
		this.user = newUser;
	}

}
