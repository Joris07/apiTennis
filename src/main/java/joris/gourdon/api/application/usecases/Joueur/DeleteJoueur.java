package joris.gourdon.api.application.usecases.Joueur;

import jakarta.persistence.EntityNotFoundException;
import joris.gourdon.api.domain.models.Joueur;
import joris.gourdon.api.domain.repositories.JoueurRepository;
import org.springframework.stereotype.Service;

@Service
public class DeleteJoueur {

	private final JoueurRepository joueurRepository;

	public DeleteJoueur(JoueurRepository joueurRepository) {
		this.joueurRepository = joueurRepository;
	}

	public void delete(int id) {
		Joueur joueur = joueurRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Club non trouvé."));
		joueurRepository.deleteById(id);
	}
}
