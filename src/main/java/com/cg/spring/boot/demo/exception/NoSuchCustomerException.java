package  com.cg.spring.boot.demo.exception;

public class NoSuchCustomerException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public NoSuchCustomerException(String message) {
		super(message);
	}
}
