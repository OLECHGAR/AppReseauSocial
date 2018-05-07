package application;

import java.util.ArrayList;

import framework.exception.NotNullException;
import framework.utilisateur.$Utilisateur;
import framework.zonesPartage.ZonePartage;

public class SalonDiscussion extends ZonePartage{

	public SalonDiscussion($Utilisateur proprietaire, ArrayList<? extends $Utilisateur> utilisateursAutorises)
			throws NotNullException {
		super(proprietaire, utilisateursAutorises);
		// TODO Auto-generated constructor stub
	}
	public SalonDiscussion($Utilisateur proprietaire, ArrayList<? extends $Utilisateur> utilisateursAutorises,
			String nom) throws NotNullException {
		super(proprietaire, utilisateursAutorises, nom);
		// TODO Auto-generated constructor stub
	}

	public SalonDiscussion($Utilisateur proprietaire, String nom) throws NotNullException {
		super(proprietaire, nom);
		// TODO Auto-generated constructor stub
	}


	public SalonDiscussion(ArrayList<? extends $Utilisateur> utilisateursAutorises) throws NotNullException {
		super(utilisateursAutorises);
		// TODO Auto-generated constructor stub
	}

}
