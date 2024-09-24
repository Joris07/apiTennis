package joris.gourdon.api.application.usecases.Joueur;

import joris.gourdon.api.domain.models.Joueur;
import joris.gourdon.api.domain.repositories.ClubRepository;
import joris.gourdon.api.domain.repositories.JoueurRepository;
import org.springframework.stereotype.Service;

@Service
public class CreateJoueur {
	private final JoueurRepository joueurRepository;

	public CreateJoueur(JoueurRepository joueurRepository) {
		this.joueurRepository = joueurRepository;
	}

	public Joueur create(Joueur joueur) {
		return joueurRepository.save(joueur);
	}
}