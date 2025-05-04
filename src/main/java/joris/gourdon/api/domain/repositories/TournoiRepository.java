package joris.gourdon.api.domain.repositories;

import joris.gourdon.api.domain.models.Tournoi;
import java.util.List;
import java.util.Optional;

public interface TournoiRepository {
    List<Tournoi> findAll();
    Optional<Tournoi> findById(int id);
    Tournoi save(Tournoi tournoi);
    void deleteById(int id);
} 