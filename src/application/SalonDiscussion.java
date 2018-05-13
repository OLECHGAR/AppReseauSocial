package application;

import java.util.ArrayList;

import framework.exception.NotNullException;
import framework.transferable.Texte;
import framework.utilisateur.$Utilisateur;
import framework.zonesPartages.ZonePartage;

public class SalonDiscussion extends ZonePartage<Utilisateur, SalonDiscussion> implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static int nbSalon;
	/**
	 * Permet de r�f�rencer un salon de mani�re unique
	 */
	private final int references;
	private ArrayList<Texte<String>> messages = new ArrayList<Texte<String>>();

	public SalonDiscussion(Utilisateur proprietaire,
			ArrayList<Utilisateur> utilisateursAutorises, int ref)
			throws NotNullException {
		super(proprietaire, utilisateursAutorises);
		nbSalon++;
		this.references = ref;
		// TODO Auto-generated constructor stub
	}

	public SalonDiscussion(Utilisateur proprietaire,
			ArrayList<Utilisateur> utilisateursAutorises, String nom, int ref)
			throws NotNullException {
		super(proprietaire, utilisateursAutorises, nom);
		nbSalon++;
		this.references = ref;
		// TODO Auto-generated constructor stub
	}

	public SalonDiscussion(Utilisateur proprietaire, String nom, int ref)
			throws NotNullException {
		super(proprietaire, nom);
		nbSalon++;
		this.references = ref;
		// TODO Auto-generated constructor stub
	}

	public SalonDiscussion(
			ArrayList<Utilisateur> utilisateursAutorises, int ref)
			throws NotNullException {
		super(utilisateursAutorises);
		nbSalon++;
		this.references = ref;
		// TODO Auto-generated constructor stub
	}

	public int getReferences() {
		return references;
	}

	@Override
	public String toString() {
		return "SalonDiscussion : " + this.nom;
	}
	
	public ArrayList<Texte<String>> getMessages(){
		return this.messages;
	}


}
