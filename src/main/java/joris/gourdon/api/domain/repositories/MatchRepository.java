package joris.gourdon.api.domain.repositories;

import joris.gourdon.api.domain.models.Match;
import java.util.List;
import java.util.Optional;

public interface MatchRepository {
    List<Match> findAll();
    Optional<Match> findById(int id);
    Match save(Match match);
    void deleteById(int id);
} 