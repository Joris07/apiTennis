package joris.gourdon.api.application.usecases.Tournoi;

import joris.gourdon.api.domain.models.Tournoi;
import joris.gourdon.api.domain.repositories.TournoiRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class DeleteTournoi {
    private final TournoiRepository tournoiRepository;

    public DeleteTournoi(TournoiRepository tournoiRepository) {
        this.tournoiRepository = tournoiRepository;
    }

    public void delete(int id) {
        tournoiRepository.findById(id)
                .ifPresentOrElse(
                        tournoi -> tournoiRepository.deleteById(id),
                        () -> {
                            throw new EntityNotFoundException("Tournoi non trouvé avec l'id : " + id);
                        }
                );
    }
} 