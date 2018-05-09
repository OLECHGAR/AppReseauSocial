package application;

import java.util.ArrayList;

import framework.zonesPartages.ZonePartageSimple;

/**
 * Salon privé entre deux p
 * @author monbeigj
 *
 */
public class MessagePrive extends ZonePartageSimple{
	private ArrayList<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();
	
	public MessagePrive(ArrayList<Utilisateur> utilisateurs){
		this.utilisateurs = utilisateurs;
	}
	
	public Utilisateur getDestinataire(Utilisateur u){
		if(utilisateurs.get(0) == u)
			return utilisateurs.get(1);
		return utilisateurs.get(0);
	}
}




