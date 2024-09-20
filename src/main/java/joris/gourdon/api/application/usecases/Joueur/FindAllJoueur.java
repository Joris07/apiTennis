package joris.gourdon.api.application.usecases.Joueur;

import joris.gourdon.api.domain.models.Joueur;
import joris.gourdon.api.domain.repositories.JoueurRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindAllJoueur {
	private final JoueurRepository joueurRepository;

	public FindAllJoueur(JoueurRepository joueurRepository) {
		this.joueurRepository = joueurRepository;
	}

	public List<Joueur> findAll() {
		return joueurRepository.findAll();
	}
}
