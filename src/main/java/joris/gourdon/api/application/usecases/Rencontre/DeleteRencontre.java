package joris.gourdon.api.application.usecases.Rencontre;

import joris.gourdon.api.domain.repositories.RencontreRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class DeleteRencontre {
    private final RencontreRepository rencontreRepository;

    public DeleteRencontre(RencontreRepository rencontreRepository) {
        this.rencontreRepository = rencontreRepository;
    }

    public void delete(int id) {
        rencontreRepository.findById(id)
                .ifPresentOrElse(
                        rencontre -> rencontreRepository.deleteById(id),
                        () -> {
                            throw new EntityNotFoundException("Rencontre non trouvée avec l'id : " + id);
                        }
                );
    }
} 