package joris.gourdon.api.infrastructure.persistence.repositoriesJpa;

import joris.gourdon.api.infrastructure.persistence.entities.CategorieEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategorieRepositoryJpa extends JpaRepository<CategorieEntity, Integer> {
} 