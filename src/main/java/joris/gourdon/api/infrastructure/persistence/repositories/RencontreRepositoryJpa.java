package joris.gourdon.api.infrastructure.persistence.repositories;

import joris.gourdon.api.infrastructure.persistence.entities.RencontreEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RencontreRepositoryJpa extends JpaRepository<RencontreEntity, Integer> {
} 