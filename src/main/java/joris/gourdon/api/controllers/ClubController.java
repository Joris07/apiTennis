package joris.gourdon.api.controllers;

import jakarta.validation.Valid;
import joris.gourdon.api.dto.ClubDTO;
import joris.gourdon.api.services.ClubService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("clubs")
public class ClubController {

	ClubService clubService;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ClubDTO> findAll() {
		return this.clubService.findAll();
	}

	@GetMapping(value = "/{id}")
	public ClubDTO findById(@PathVariable int id) {
		return this.clubService.findById(id);
	}

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public void createClub(@Valid @RequestBody ClubDTO clubDTO) {
		this.clubService.createClub(clubDTO);
	}

	@PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void updateClub(@PathVariable int id, @Valid @RequestBody ClubDTO clubDTO) {
		this.clubService.updateClub(id, clubDTO);
	}
}
