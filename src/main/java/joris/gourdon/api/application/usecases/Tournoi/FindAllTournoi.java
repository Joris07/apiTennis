package joris.gourdon.api.application.usecases.Tournoi;

import joris.gourdon.api.domain.models.Tournoi;
import joris.gourdon.api.domain.repositories.TournoiRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindAllTournoi {
    private final TournoiRepository tournoiRepository;

    public FindAllTournoi(TournoiRepository tournoiRepository) {
        this.tournoiRepository = tournoiRepository;
    }

    public List<Tournoi> findAll() {
        return tournoiRepository.findAll();
    }
} 