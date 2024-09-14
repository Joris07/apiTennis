package joris.gourdon.api.service;

import joris.gourdon.api.dto.ClubDTO;
import joris.gourdon.api.dto.JoueurDTO;
import joris.gourdon.api.repository.ClubRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class ClubService {

	private ClubRepository clubRepository;

	public List<ClubDTO> search() {
		return this.clubRepository
				.findAll()
				.stream()
				.map(club -> new ClubDTO(
							club.getId(),
							club.getNom(),
							club.getAdresse(),
							club.getVille(),
							club.getCodePostal(),
							club.getPays()
					)
				)
				.collect(Collectors.toList());
	}
}
