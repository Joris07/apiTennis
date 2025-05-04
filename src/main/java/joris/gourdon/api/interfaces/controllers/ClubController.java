package joris.gourdon.api.interfaces.controllers;

import jakarta.validation.Valid;
import joris.gourdon.api.application.services.ClubService;
import joris.gourdon.api.domain.dto.requests.ClubRequestDTO;
import joris.gourdon.api.domain.dto.responses.ClubResponseDTO;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clubs")
public class ClubController {

	private final ClubService clubService;

	public ClubController(ClubService clubService) {
		this.clubService = clubService;
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ClubResponseDTO> findAll() {
		return clubService.findAll();
	}

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ClubResponseDTO> findById(@PathVariable int id) {
		ClubResponseDTO clubDTO = clubService.findById(id);
		return ResponseEntity.ok(clubDTO);
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ClubResponseDTO> create(@Valid @RequestBody ClubRequestDTO clubDTO) {
		ClubResponseDTO savedClubDTO = clubService.createClub(clubDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedClubDTO);
	}

	@PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> update(@PathVariable int id, @Valid @RequestBody ClubRequestDTO clubDTO) {
		clubService.updateClub(id, clubDTO);
		return ResponseEntity.ok().build();
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable int id) {
		clubService.deleteClub(id);
		return ResponseEntity.noContent().build();
	}
}