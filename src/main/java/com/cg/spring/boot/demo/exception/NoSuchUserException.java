package  com.cg.spring.boot.demo.exception;

public class NoSuchUserException extends Exception {

	private static final long serialVersionUID = 1L;
	
	private String message;
	
	public NoSuchUserException(String message) {
		super(message);
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
