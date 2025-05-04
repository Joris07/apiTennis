package joris.gourdon.api.domain.repositories;

import joris.gourdon.api.domain.models.Equipe;

import java.util.List;
import java.util.Optional;

public interface EquipeRepository {
    List<Equipe> findAll();
    Optional<Equipe> findById(int id);
    Equipe save(Equipe equipe);
    void deleteById(int id);
} 