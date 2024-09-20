package joris.gourdon.api.application.usecases.Joueur;

import jakarta.persistence.EntityNotFoundException;
import joris.gourdon.api.domain.models.Joueur;
import joris.gourdon.api.domain.repositories.JoueurRepository;
import org.springframework.stereotype.Service;

@Service
public class UpdateJoueur {
	private final JoueurRepository joueurRepository;

	public UpdateJoueur(JoueurRepository joueurRepository) {
		this.joueurRepository = joueurRepository;
	}

	public Joueur update(int id, Joueur joueurDetails) {
		Joueur existingJoueur = joueurRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Club non trouvé."));

		existingJoueur.setNom(joueurDetails.getNom());
		existingJoueur.setPrenom(joueurDetails.getPrenom());
		existingJoueur.setClub(joueurDetails.getClub());
		existingJoueur.setGenre(joueurDetails.getGenre());
		existingJoueur.setDateNaissance(joueurDetails.getDateNaissance());
		existingJoueur.setNationalite(joueurDetails.getNationalite());
		
		return joueurRepository.save(existingJoueur);
	}
}
