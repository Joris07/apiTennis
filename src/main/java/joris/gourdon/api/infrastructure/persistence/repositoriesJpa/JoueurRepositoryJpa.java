package joris.gourdon.api.infrastructure.persistence.repositoriesJpa;

import joris.gourdon.api.infrastructure.persistence.entities.JoueurEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JoueurRepositoryJpa extends JpaRepository<JoueurEntity, Integer> { }
