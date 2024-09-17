package joris.gourdon.api.infrastructure.exceptions;

public class ConflictException extends RuntimeException {
	public ConflictException(String message) {
		super(message);
	}
}