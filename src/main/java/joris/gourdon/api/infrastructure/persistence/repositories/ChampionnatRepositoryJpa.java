package joris.gourdon.api.infrastructure.persistence.repositories;

import joris.gourdon.api.infrastructure.persistence.entities.ChampionnatEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChampionnatRepositoryJpa extends JpaRepository<ChampionnatEntity, Integer> {
} 