package slava.cd;

public class CDException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public CDException(Exception cause) {
		super(cause);
	}

	public CDException(String message) {
		super(message);
	}

}
