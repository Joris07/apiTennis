package joris.gourdon.api.infrastructure.exceptions;

public class InvalidInputException extends RuntimeException {
	public InvalidInputException(String message) {
		super(message);
	}
}