package framework.exception;

public class NotNullException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NotNullException(String message, String methode){
		super("\nShould not be null : "+message+"\nMéthode : "+methode);
	}

}
