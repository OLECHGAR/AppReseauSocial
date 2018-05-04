package framework.exception;

public class Ensure extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Ensure(String message, String methode){
		super("\nEnsure : "+message+"\nMéthode : "+methode);
	}

}