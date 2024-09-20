package joris.gourdon.api.application.usecases.Joueur;

import jakarta.persistence.EntityNotFoundException;
import joris.gourdon.api.domain.models.Club;
import joris.gourdon.api.domain.models.Joueur;
import joris.gourdon.api.domain.repositories.ClubRepository;
import joris.gourdon.api.domain.repositories.JoueurRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CreateJoueur {
	private final JoueurRepository joueurRepository;
	private final ClubRepository clubRepository;

	public CreateJoueur(JoueurRepository joueurRepository, ClubRepository clubRepository) {
		this.joueurRepository = joueurRepository;
		this.clubRepository = clubRepository;
	}

	public Joueur create(Joueur joueur) {
		return joueurRepository.save(joueur);
	}
}