package joris.gourdon.api.domain.repositories;

import joris.gourdon.api.domain.models.Championnat;
import java.util.List;
import java.util.Optional;

public interface ChampionnatRepository {
    List<Championnat> findAll();
    Optional<Championnat> findById(int id);
    Championnat save(Championnat championnat);
    void deleteById(int id);
} 