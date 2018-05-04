package framework.exception;

public class Invariant extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Invariant(String message, String methode){
		super("\nInvariant : "+message+"\nMéthode : "+methode);
	}

}