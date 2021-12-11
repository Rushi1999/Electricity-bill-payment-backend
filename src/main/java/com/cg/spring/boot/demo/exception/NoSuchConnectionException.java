package  com.cg.spring.boot.demo.exception;;

public class NoSuchConnectionException extends Exception {
	private String message;
	public NoSuchConnectionException(String message) {
		super(message);
	}
}
