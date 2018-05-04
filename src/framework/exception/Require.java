package framework.exception;

public class Require extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Require(String message, String methode){
		super("\nRequire : "+message+"\nMéthode : "+methode);
	}

}