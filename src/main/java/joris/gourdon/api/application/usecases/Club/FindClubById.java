package joris.gourdon.api.application.usecases.Club;

import joris.gourdon.api.domain.models.Club;
import joris.gourdon.api.domain.repositories.ClubRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FindClubById {
	private final ClubRepository clubRepository;

	public FindClubById(ClubRepository clubRepository) {
		this.clubRepository = clubRepository;
	}

	public Optional<Club> findById(int id) {
		return clubRepository.findById(id);
	}
}