package joris.gourdon.api.domain.repositories;

import joris.gourdon.api.domain.models.TypeTournoi;
import java.util.List;
import java.util.Optional;

public interface TypeTournoiRepository {
    List<TypeTournoi> findAll();
    Optional<TypeTournoi> findById(int id);
} 