package joris.gourdon.api.infrastructure.persistence.repositoriesJpa;

import joris.gourdon.api.infrastructure.persistence.entities.DivisionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DivisionRepositoryJpa extends JpaRepository<DivisionEntity, Integer> {
} 