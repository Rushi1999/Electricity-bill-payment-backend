package  com.cg.spring.boot.demo.exception;

public class DuplicateCustomerException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public DuplicateCustomerException(String message) {
		super(message);
	}
}
