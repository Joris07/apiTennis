package joris.gourdon.api.infrastructure.persistence.repositories;

import joris.gourdon.api.infrastructure.persistence.entities.TypeTournoiEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeTournoiRepositoryJpa extends JpaRepository<TypeTournoiEntity, Integer> {
} 