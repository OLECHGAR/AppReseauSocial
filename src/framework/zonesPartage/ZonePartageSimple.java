package framework.zonesPartage;

//Start of user code (user defined imports)
import java.util.ArrayList;

import framework.exception.*;
import framework.transferable.$Transferable;
//End of user code

/**
 * Description of ZonePartageSimple.
 * 
 * @author pignardf
 */
public class ZonePartageSimple {
	// Start of user code (user defined attributes for ZonePartage)
	protected ArrayList<$Transferable> transferables = new ArrayList<$Transferable>();
	// End of user code

	/**
	 * The constructor.
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
	public ArrayList<$Transferable> getTransferables() {
		return this.transferables;
	}

	/**
	 * 
	 * @param transferable
	 * @throws NotNullException
	 */
	public void addTransferable($Transferable transferable) throws NotNullException {
		if (transferable == null)throw new NotNullException("$Transferable transferable","addTransferable");
		this.transferables.add(transferable);
	}
	
	public <T> T afficherMessageIndex(int index) throws Require{
		if(index >= this.transferables.size()) throw new Require("index < transferable.size()", "afficherMessageIndex");
		return (T) this.transferables.get(index).getContenu();
	}
	
	public int size(){
		if(this.transferables == null)
			return 0;
		return this.transferables.size();
	}
	
	public void supprimer($Transferable<?> t){
		this.transferables.remove(this.transferables.indexOf(t));
		/*?à décider : Requete de supression du transferable et de toutes les requetes en rapport
		 Ou alors juste ne pas attribuer le message à une zone pour qu'il disparaisse de la circulation mais de le garder en base
		de donée afin de garder un historique des logs
		*/
	}
	// End of user code
}
