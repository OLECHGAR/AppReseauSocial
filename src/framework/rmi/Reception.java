package framework.rmi;

import framework.utilisateur.$Utilisateur;

/**
 * Description of Reception.
 * 
 * @author monbeigj
 */
public class Reception<T extends $Utilisateur<?>> extends $Requete<T> {

    /**
     * The constructor.
     * 
     * @param u
     * @param type
     */
    public Reception(T u, String type) {
	super(u, type);
	super.getTransferable();
    }
}
