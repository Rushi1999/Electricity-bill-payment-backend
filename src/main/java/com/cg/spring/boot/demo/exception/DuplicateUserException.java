package  com.cg.spring.boot.demo.exception;

public class DuplicateUserException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	private String message;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public DuplicateUserException(String message) {
		super(message);
	}
}
