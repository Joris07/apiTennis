package joris.gourdon.api.infrastructure.persistence.repositoriesJpa;

import joris.gourdon.api.infrastructure.persistence.entities.EquipeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipeRepositoryJpa extends JpaRepository<EquipeEntity, Integer> {
} 