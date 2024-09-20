package joris.gourdon.api.application.usecases.Joueur;

import joris.gourdon.api.domain.models.Joueur;
import joris.gourdon.api.domain.repositories.JoueurRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FindJoueurById {
	private final JoueurRepository joueurRepository;

	public FindJoueurById(JoueurRepository joueurRepository) {
		this.joueurRepository = joueurRepository;
	}

	public Optional<Joueur> findById(int id) {
		return joueurRepository.findById(id);
	}
}
