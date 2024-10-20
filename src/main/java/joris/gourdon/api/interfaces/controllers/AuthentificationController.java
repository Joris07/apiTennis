package joris.gourdon.api.interfaces.controllers;

import joris.gourdon.api.application.services.JoueurService;
import joris.gourdon.api.domain.dto.AuthentificationDTO;
import joris.gourdon.api.domain.dto.requests.JoueurRequestDTO;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@AllArgsConstructor
@RestController
public class AuthentificationController {
	private JoueurService joueurService;
	private AuthenticationManager authenticationManager;

	@PostMapping(path = "/register")
	public void register(@RequestBody JoueurRequestDTO joueurRequestDTO) {
		this.joueurService.createJoueur(joueurRequestDTO) ;
	}

	@PostMapping(path = "/login")
	public Map<String, String> connexion(@RequestBody AuthentificationDTO authentificationDTO) {
		final Authentication authenticate = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(authentificationDTO.email(), authentificationDTO.password())
		);
		return null;
	}
}
