package  com.cg.spring.boot.demo.exception;

public class NoSuchCustomerException extends Exception {
	private String message;
	public NoSuchCustomerException(String message) {
		super(message);
	}
}
