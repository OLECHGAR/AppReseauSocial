package framework.zonesPartages;

//Start of user code (user defined imports)
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;

import framework.exception.Ensure;
import framework.exception.NotNullException;
import framework.exception.Require;
import framework.transferable.$Transferable;

//End of user code

/**
 * Description of ZonePartageSimple.
 * 
 * @author pignardf
 */
public class ZonePartageSimple {
    // Start of user code (user defined attributes for ZonePartage)
    private static final long serialVersionUID = 1L;
    protected ArrayList<$Transferable<?>> transferables = new ArrayList<$Transferable<?>>();

    // End of user code

    /**
     * The constructor.
     * 
     * @throws RemoteException
     */
    public ZonePartageSimple() {
	// Start of user code constructor for Reception)
	super();
	// End of user code
    }

    // Start of user code (user defined methods for ZonePartageSimple)
    /**
     * Returns tous les transferable de la zone.
     * 
     * @return transferables
     */
    public <T> ArrayList<$Transferable<?>> getTransferables() {
	return this.transferables;
    }

    /**
     * Ajoute le transferable a la zone.
     * 
     * @param transferable
     * @throws NotNullException
     */
    public void addTransferable($Transferable<?> transferable)
	    throws NotNullException {
	if (transferable == null)
	    throw new NotNullException("$Transferable transferable",
		    "addTransferable");
	this.transferables.add(transferable);
	if (!(this.trouverTransferable(transferable)))
	    throw new Ensure("trouverTransferabke(transferable) == true",
		    "addTransferable");

    }

    /**
     * 
     * @param index
     * @return
     * @throws Require
     */
    public <T> T afficherMessageIndex(int index) throws Require {
	if (index >= this.transferables.size())
	    throw new Require("index < transferable.size()",
		    "afficherMessageIndex");
	return (T) this.transferables.get(index).getContenu();
    }

    /**
     * Cherche si un transferable est dans la zone.
     * 
     * @param transferable
     * @return true si le transferable existe dans la zone, false sinon.
     */
    private boolean trouverTransferable($Transferable<?> transferable) {
	Iterator<$Transferable<?>> it = this.getTransferables().iterator();
	while (it.hasNext()) {
	    if (it.next().equals(transferable)) {
		return true;
	    }
	}
	return false;
    }

    /**
     * Cherche si un transferable est dans la zone.
     * 
     * @param nom
     * @return le transferable trouvé ou null sinon.
     */
    public $Transferable<?> trouverTransferable(String nom) {
	Iterator<$Transferable<?>> it = this.getTransferables().iterator();
	$Transferable<?> result = null;
	while (it.hasNext()) {
	    result = it.next();
	    // TODO change to don't need exactly the same name
	    // TODO change to use contenu name and not toString
	    if (result.getContenu().toString().equals(nom)) {
		return result;
	    }
	}
	return result;
    }

    /**
     * Permet de connaitre la taille de la zone, sont nombre de transférable.
     * 
     * @return sont nombre de transférable.
     */
    public int size() {
	if (this.transferables == null)
	    return 0;
	return this.transferables.size();
    }

    /**
     * Permet de supprimer un transferable sur la zone.
     * 
     * @param t
     */
    public void supprimer($Transferable<?> t) {
	this.transferables.remove(this.transferables.indexOf(t));
	/*
	 * ?Ã  dÃ©cider : Requete de supression du transferable et de toutes les
	 * requetes en rapport Ou alors juste ne pas attribuer le message Ã  une
	 * zone pour qu'il disparaisse de la circulation mais de le garder en
	 * base de donÃ©e afin de garder un historique des logs
	 */
    }
    // End of user code
}
