package joris.gourdon.api.infrastructure.handler;

import joris.gourdon.api.domain.dto.ErreurDTO;
import joris.gourdon.api.infrastructure.exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErreurDTO> handleValidationExceptions(MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<>();

		// Collecte des messages d'erreur de chaque champ non valide
		ex.getBindingResult().getFieldErrors().forEach(error ->
				errors.put(error.getField(), error.getDefaultMessage())
		);

		// Créer l'objet ErreurDTO avec le message, les détails des erreurs, le timestamp et le code de statut HTTP
		ErreurDTO erreurDTO = new ErreurDTO(
				HttpStatus.BAD_REQUEST.value(),
				"Erreur de validation des données.",
				errors,
				LocalDateTime.now()
		);

		// Retourne une réponse avec le statut HTTP 400 (Bad Request)
		return new ResponseEntity<>(erreurDTO, HttpStatus.BAD_REQUEST);
	}

	// Gérer ResourceNotFoundException
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErreurDTO> handleResourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
		ErreurDTO erreur = new ErreurDTO(
				HttpStatus.NOT_FOUND.value(),
				ex.getMessage(),
				null,
				LocalDateTime.now() // Ajouter la date et l'heure actuelles
		);
		return new ResponseEntity<>(erreur, HttpStatus.NOT_FOUND);
	}

	// Gérer InvalidInputException
	@ExceptionHandler(InvalidInputException.class)
	public ResponseEntity<ErreurDTO> handleInvalidInputException(InvalidInputException ex, WebRequest request) {
		ErreurDTO erreur = new ErreurDTO(
				HttpStatus.BAD_REQUEST.value(),
				ex.getMessage(),
				null,
				LocalDateTime.now()
		);
		return new ResponseEntity<>(erreur, HttpStatus.BAD_REQUEST);
	}

	// Gérer ConflictException
	@ExceptionHandler(ConflictException.class)
	public ResponseEntity<ErreurDTO> handleConflictException(ConflictException ex, WebRequest request) {
		ErreurDTO erreur = new ErreurDTO(
				HttpStatus.CONFLICT.value(),
				ex.getMessage(),
				null,
				LocalDateTime.now()
		);
		return new ResponseEntity<>(erreur, HttpStatus.CONFLICT);
	}

	// Gérer UnauthorizedException
	@ExceptionHandler(UnauthorizedException.class)
	public ResponseEntity<ErreurDTO> handleUnauthorizedException(UnauthorizedException ex, WebRequest request) {
		ErreurDTO erreur = new ErreurDTO(
				HttpStatus.UNAUTHORIZED.value(),
				ex.getMessage(),
				null,
				LocalDateTime.now()
		);
		return new ResponseEntity<>(erreur, HttpStatus.UNAUTHORIZED);
	}

	// Gérer BadRequestException
	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<ErreurDTO> handleBadRequestException(BadRequestException ex, WebRequest request) {
		ErreurDTO erreur = new ErreurDTO(
				HttpStatus.BAD_REQUEST.value(),
				ex.getMessage(),
				null,
				LocalDateTime.now()
		);
		return new ResponseEntity<>(erreur, HttpStatus.BAD_REQUEST);
	}

	// Gérer toutes les autres exceptions génériques (ex: 500 Internal Server Error)
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErreurDTO> handleGlobalException(Exception ex, WebRequest request) {
		ErreurDTO erreur = new ErreurDTO(
				HttpStatus.INTERNAL_SERVER_ERROR.value(),
				ex.getMessage(),
				null,
				LocalDateTime.now()
		);
		return new ResponseEntity<>(erreur, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
