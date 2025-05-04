package joris.gourdon.api.application.usecases.Rencontre;

import joris.gourdon.api.domain.models.Rencontre;
import joris.gourdon.api.domain.repositories.RencontreRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UpdateRencontre {
    private final RencontreRepository rencontreRepository;

    public UpdateRencontre(RencontreRepository rencontreRepository) {
        this.rencontreRepository = rencontreRepository;
    }

    public Rencontre update(int id, Rencontre rencontreDetails) {
        return rencontreRepository.findById(id)
                .map(existingRencontre -> {
                    existingRencontre.setPoule(rencontreDetails.getPoule());
                    existingRencontre.setEquipe1(rencontreDetails.getEquipe1());
                    existingRencontre.setEquipe2(rencontreDetails.getEquipe2());
                    existingRencontre.setDate(rencontreDetails.getDate());
                    existingRencontre.setScore(rencontreDetails.getScore());
                    existingRencontre.setGagnant(rencontreDetails.getGagnant());
                    return rencontreRepository.save(existingRencontre);
                })
                .orElseThrow(() -> new EntityNotFoundException("Rencontre non trouvée avec l'id : " + id));
    }
} 