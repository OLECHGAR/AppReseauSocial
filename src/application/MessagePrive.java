package application;

import java.util.ArrayList;

import framework.zonesPartages.ZonePartageSimple;

/**
 * Salon privé entre deux p
 * 
 * @author monbeigj
 *
 */
public class MessagePrive extends ZonePartageSimple {
    private ArrayList<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();

    /**
     * The constructor.
     * 
     * @param utilisateurs
     */
    public MessagePrive(ArrayList<Utilisateur> utilisateurs) {
	this.utilisateurs = utilisateurs;
    }

    /**
     * Permet de connaitre le destinataire.
     * 
     * @param u
     * @return
     */
    public Utilisateur getDestinataire(Utilisateur u) {
	if (this.utilisateurs.get(0) == u)
	    return this.utilisateurs.get(1);
	return this.utilisateurs.get(0);
    }
}
