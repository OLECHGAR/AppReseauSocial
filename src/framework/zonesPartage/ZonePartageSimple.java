package framework.zonesPartage;

//Start of user code (user defined imports)
import java.util.ArrayList;
import framework.exception.NotNullException;
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
	 * Returns messages.
	 * 
	 * @return messages
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
		if (transferable == null)
			throw new NotNullException("Transferable");
		this.transferables.add(transferable);
	}

	// End of user code
}
