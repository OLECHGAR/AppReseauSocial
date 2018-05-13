package application;

import java.util.ArrayList;

import framework.exception.NotNullException;
import framework.transferable.Texte;
import framework.zonesPartages.ZonePartage;

/**
 * 
 * @author monbeigj
 *
 */
public class SalonDiscussion extends ZonePartage<Utilisateur, SalonDiscussion>
	implements java.io.Serializable {

    private static final long serialVersionUID = 1L;
    private static int nbSalon;
    /**
     * Permet de rï¿½fï¿½rencer un salon de maniï¿½re unique
     */
    private final int references;
    private ArrayList<Texte<String>> messages = new ArrayList<Texte<String>>();

    /**
     * The constructor.
     * 
     * @param proprietaire
     * @param utilisateursAutorises
     * @param ref
     * @throws NotNullException
     */
    public SalonDiscussion(Utilisateur proprietaire,
	    ArrayList<Utilisateur> utilisateursAutorises, int ref)
	    throws NotNullException {
	super(proprietaire, utilisateursAutorises);
	nbSalon++;
	this.references = ref;
	// TODO Auto-generated constructor stub
    }

    /**
     * The constructor.
     * 
     * @param proprietaire
     * @param utilisateursAutorises
     * @param nom
     * @param ref
     * @throws NotNullException
     */
    public SalonDiscussion(Utilisateur proprietaire,
	    ArrayList<Utilisateur> utilisateursAutorises, String nom, int ref)
	    throws NotNullException {
	super(proprietaire, utilisateursAutorises, nom);
	nbSalon++;
	this.references = ref;
	// TODO Auto-generated constructor stub
    }

    /**
     * The constructor.
     * 
     * @param proprietaire
     * @param nom
     * @param ref
     * @throws NotNullException
     */
    public SalonDiscussion(Utilisateur proprietaire, String nom, int ref)
	    throws NotNullException {
	super(proprietaire, nom);
	nbSalon++;
	this.references = ref;
	// TODO Auto-generated constructor stub
    }

    /**
     * The constructor.
     * 
     * @param utilisateursAutorises
     * @param ref
     * @throws NotNullException
     */
    public SalonDiscussion(ArrayList<Utilisateur> utilisateursAutorises, int ref)
	    throws NotNullException {
	super(utilisateursAutorises);
	nbSalon++;
	this.references = ref;
	// TODO Auto-generated constructor stub
    }

    /**
     * Permet de récupérer la référence du salon.
     * 
     * @return this.references;
     */
    public int getReferences() {
	return this.references;
    }

    @Override
    public String toString() {
	return "SalonDiscussion : " + this.nom;
    }

    /**
     * Permet de récupérer les messages du salon.
     * 
     * @return this.messages;
     */
    public ArrayList<Texte<String>> getMessages() {
	return this.messages;
    }

}
