package joris.gourdon.api.application.usecases.Club;

import joris.gourdon.api.domain.models.Club;
import joris.gourdon.api.domain.repositories.ClubRepository;
import org.springframework.stereotype.Service;

@Service
public class CreateClub {
	private final ClubRepository clubRepository;

	public CreateClub(ClubRepository clubRepository) {
		this.clubRepository = clubRepository;
	}

	public Club create(Club club) {
		return clubRepository.save(club);
	}
}