package joris.gourdon.api.infrastructure.persistence.repositoriesJpa;

import joris.gourdon.api.infrastructure.persistence.entities.ClubEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClubRepositoryJpa extends JpaRepository<ClubEntity, Integer> { }