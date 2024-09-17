package joris.gourdon.api.application.usecases.Club;

import joris.gourdon.api.domain.models.Club;
import joris.gourdon.api.domain.repositories.ClubRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindAllClub {
	private final ClubRepository clubRepository;

	public FindAllClub(ClubRepository clubRepository) {
		this.clubRepository = clubRepository;
	}

	public List<Club> findAll() {
		return clubRepository.findAll();
	}
}