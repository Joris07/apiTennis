package joris.gourdon.api.application.usecases.Tournoi;

import joris.gourdon.api.domain.models.Tournoi;
import joris.gourdon.api.domain.repositories.TournoiRepository;
import org.springframework.stereotype.Service;

@Service
public class CreateTournoi {
    private final TournoiRepository tournoiRepository;

    public CreateTournoi(TournoiRepository tournoiRepository) {
        this.tournoiRepository = tournoiRepository;
    }

    public Tournoi create(Tournoi tournoi) {
        return tournoiRepository.save(tournoi);
    }
} 