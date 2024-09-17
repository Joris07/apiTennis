package joris.gourdon.api.domain.repositories;

import joris.gourdon.api.domain.models.Club;

import java.util.List;
import java.util.Optional;

public interface ClubRepository {
	List<Club> findAll();
	Optional<Club> findById(int id);
	Club save(Club club);
	void deleteById(int id);
}