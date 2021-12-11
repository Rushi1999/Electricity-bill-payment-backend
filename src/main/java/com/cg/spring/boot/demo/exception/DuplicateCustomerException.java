package  com.cg.spring.boot.demo.exception;

public class DuplicateCustomerException extends Exception {
	private String message;
	public DuplicateCustomerException(String message) {
		super(message);
	}
}
