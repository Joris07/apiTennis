package joris.gourdon.api.application.usecases.Championnat;

import joris.gourdon.api.domain.models.Championnat;
import joris.gourdon.api.domain.repositories.ChampionnatRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class DeleteChampionnat {
    private final ChampionnatRepository championnatRepository;

    public DeleteChampionnat(ChampionnatRepository championnatRepository) {
        this.championnatRepository = championnatRepository;
    }

    public void delete(int id) {
        championnatRepository.findById(id)
                .ifPresentOrElse(
                        championnat -> championnatRepository.deleteById(id),
                        () -> {
                            throw new EntityNotFoundException("Championnat non trouvé avec l'id : " + id);
                        }
                );
    }
} 