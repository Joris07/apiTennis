package joris.gourdon.api.interfaces.controllers;

import jakarta.validation.Valid;
import joris.gourdon.api.application.services.JoueurService;
import joris.gourdon.api.domain.dto.requests.JoueurRequestDTO;
import joris.gourdon.api.domain.dto.responses.JoueurResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/joueurs")
public class JoueurController {

	private final JoueurService joueurService;

	public JoueurController(JoueurService joueurService) {
		this.joueurService = joueurService;
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<JoueurResponseDTO> findAll() {
		return joueurService.findAll();
	}

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<JoueurResponseDTO> findById(@PathVariable int id) {
		JoueurResponseDTO joueurResponseDTO = joueurService.findById(id);
		return ResponseEntity.ok(joueurResponseDTO);
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<JoueurResponseDTO> create(@Valid @RequestBody JoueurRequestDTO joueurRequestDTO) {
		JoueurResponseDTO savedJoueurResponseDTO = joueurService.createJoueur(joueurRequestDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedJoueurResponseDTO);
	}

	@PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<JoueurResponseDTO> updatePut(@PathVariable int id, @Valid @RequestBody JoueurRequestDTO joueurRequestDTO) {
		JoueurResponseDTO joueurResponseDTO = joueurService.updateJoueur(id, joueurRequestDTO);
		return ResponseEntity.ok().body(joueurResponseDTO);
	}
}