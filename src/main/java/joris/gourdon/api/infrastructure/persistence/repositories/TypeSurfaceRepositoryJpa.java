package joris.gourdon.api.infrastructure.persistence.repositories;

import joris.gourdon.api.infrastructure.persistence.entities.TypeSurfaceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeSurfaceRepositoryJpa extends JpaRepository<TypeSurfaceEntity, Integer> {
} 