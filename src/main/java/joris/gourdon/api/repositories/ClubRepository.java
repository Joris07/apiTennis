package joris.gourdon.api.repositories;

import joris.gourdon.api.models.Club;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClubRepository extends JpaRepository<Club, Integer> { }