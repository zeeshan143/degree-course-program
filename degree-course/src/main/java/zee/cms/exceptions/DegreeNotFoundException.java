package zee.cms.exceptions;

public class DegreeNotFoundException extends RuntimeException {
	public DegreeNotFoundException(String message, Throwable cause) { super(message, cause); }
	public DegreeNotFoundException(String message) { super(message); }
	public DegreeNotFoundException(Throwable cause) { super(cause); }
}
