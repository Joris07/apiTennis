package joris.gourdon.api.controller;

import joris.gourdon.api.dto.JoueurDTO;
import joris.gourdon.api.service.JoueurService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("joueurs")
public class JoueurController {

	JoueurService joueurService;
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<JoueurDTO> search() {
		return this.joueurService.search();
	}
}