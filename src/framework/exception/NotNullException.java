package framework.exception;

public class NotNullException extends Exception {
	
	public NotNullException(String message){
		super("Not Null dans"+message);
	}

}
