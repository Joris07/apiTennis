package joris.gourdon.api.application.usecases.Club;

import jakarta.persistence.EntityNotFoundException;
import joris.gourdon.api.domain.models.Club;
import joris.gourdon.api.domain.repositories.ClubRepository;
import org.springframework.stereotype.Service;

@Service
public class DeleteClub {
	private final ClubRepository clubRepository;

	public DeleteClub(ClubRepository clubRepository) {
		this.clubRepository = clubRepository;
	}

	public void delete(int id) {
		Club existingClub = clubRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Club non trouvé avec l'id : " + id));
		clubRepository.deleteById(id);
	}
}