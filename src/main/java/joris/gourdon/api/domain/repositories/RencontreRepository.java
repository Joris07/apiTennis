package joris.gourdon.api.domain.repositories;

import joris.gourdon.api.domain.models.Rencontre;
import java.util.List;
import java.util.Optional;

public interface RencontreRepository {
    List<Rencontre> findAll();
    Optional<Rencontre> findById(int id);
    Rencontre save(Rencontre rencontre);
    void deleteById(int id);
} 