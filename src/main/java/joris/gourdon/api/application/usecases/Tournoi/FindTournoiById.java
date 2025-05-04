package joris.gourdon.api.application.usecases.Tournoi;

import joris.gourdon.api.domain.models.Tournoi;
import joris.gourdon.api.domain.repositories.TournoiRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FindTournoiById {
    private final TournoiRepository tournoiRepository;

    public FindTournoiById(TournoiRepository tournoiRepository) {
        this.tournoiRepository = tournoiRepository;
    }

    public Optional<Tournoi> findById(int id) {
        return tournoiRepository.findById(id);
    }
} 