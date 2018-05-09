package application;

import java.util.ArrayList;

import framework.exception.NotNullException;
import framework.utilisateur.$Utilisateur;
import framework.zonesPartages.ZonePartage;

public class SalonDiscussion extends ZonePartage {

	private static int nbSalon;
	/**
	 * Permet de r�f�rencer un salon de mani�re unique
	 */
	private final int references;

	public SalonDiscussion($Utilisateur proprietaire,
			ArrayList<? extends $Utilisateur> utilisateursAutorises)
			throws NotNullException {
		super(proprietaire, utilisateursAutorises);
		nbSalon++;
		this.references = nbSalon;
		// TODO Auto-generated constructor stub
	}

	public SalonDiscussion($Utilisateur proprietaire,
			ArrayList<? extends $Utilisateur> utilisateursAutorises, String nom)
			throws NotNullException {
		super(proprietaire, utilisateursAutorises, nom);
		nbSalon++;
		this.references = nbSalon;
		// TODO Auto-generated constructor stub
	}

	public SalonDiscussion($Utilisateur proprietaire, String nom)
			throws NotNullException {
		super(proprietaire, nom);
		nbSalon++;
		this.references = nbSalon;
		// TODO Auto-generated constructor stub
	}

	public SalonDiscussion(
			ArrayList<? extends $Utilisateur> utilisateursAutorises)
			throws NotNullException {
		super(utilisateursAutorises);
		nbSalon++;
		this.references = nbSalon;
		// TODO Auto-generated constructor stub
	}

	public int getReferences() {
		return references;
	}

}
