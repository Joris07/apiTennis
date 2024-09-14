package joris.gourdon.api.controller;

import joris.gourdon.api.dto.ClubDTO;
import joris.gourdon.api.service.ClubService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("clubs")
public class ClubController {

	ClubService clubService;
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ClubDTO> search() {
		return this.clubService.search();
	}
}
