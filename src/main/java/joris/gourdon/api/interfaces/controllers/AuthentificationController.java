package joris.gourdon.api.interfaces.controllers;

import joris.gourdon.api.application.services.JoueurService;
import joris.gourdon.api.domain.dto.AuthentificationDTO;
import joris.gourdon.api.domain.dto.requests.JoueurRequestDTO;
import joris.gourdon.api.infrastructure.security.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/auth")
public class AuthentificationController {
	private final JoueurService joueurService;
	private final AuthenticationService authenticationService;

	@PostMapping("/register")
	public ResponseEntity<Map<String, String>> register(@RequestBody JoueurRequestDTO joueurRequestDTO) {
		joueurService.createJoueur(joueurRequestDTO);
		return ResponseEntity.ok(Map.of("message", "Inscription réussie"));
	}

	@PostMapping("/login")
	public ResponseEntity<Map<String, String>> login(@RequestBody AuthentificationDTO authentificationDTO) {
		Map<String, String> response = authenticationService.authenticate(
				authentificationDTO.email(),
				authentificationDTO.password()
		);
		return ResponseEntity.ok(response);
	}
}
