package joris.gourdon.api.application.usecases.Club;

import jakarta.persistence.EntityNotFoundException;
import joris.gourdon.api.domain.models.Club;
import joris.gourdon.api.domain.repositories.ClubRepository;
import org.springframework.stereotype.Service;

@Service
public class UpdateClub {
	private final ClubRepository clubRepository;

	public UpdateClub(ClubRepository clubRepository) {
		this.clubRepository = clubRepository;
	}

	public Club update(int id, Club clubDetails) {
		Club existingClub = clubRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Club non trouvé."));

		existingClub.setNom(clubDetails.getNom());
		existingClub.setAdresse(clubDetails.getAdresse());
		existingClub.setVille(clubDetails.getVille());
		existingClub.setCodePostal(clubDetails.getCodePostal());
		existingClub.setPays(clubDetails.getPays());

		return clubRepository.save(existingClub);
	}
}
