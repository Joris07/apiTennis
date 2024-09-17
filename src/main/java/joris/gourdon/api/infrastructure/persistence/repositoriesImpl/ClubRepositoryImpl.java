package joris.gourdon.api.infrastructure.persistence.repositoriesImpl;

import joris.gourdon.api.domain.models.Club;
import joris.gourdon.api.domain.repositories.ClubRepository;
import joris.gourdon.api.infrastructure.mapping.ClubMapper;
import joris.gourdon.api.infrastructure.persistence.entities.ClubEntity;
import joris.gourdon.api.infrastructure.persistence.repositoriesJpa.ClubRepositoryJpa;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class ClubRepositoryImpl implements ClubRepository {
	private final ClubRepositoryJpa clubRepositoryJpa;
	private final ClubMapper clubMapper = ClubMapper.INSTANCE;

	public ClubRepositoryImpl(ClubRepositoryJpa clubRepositoryJpa) {
		this.clubRepositoryJpa = clubRepositoryJpa;
	}

	@Override
	public List<Club> findAll() {
		return clubRepositoryJpa.findAll().stream()
				.map(clubMapper::entityClubToDomainClub)
				.collect(Collectors.toList());
	}

	@Override
	public Optional<Club> findById(int id) {
		return clubRepositoryJpa.findById(id)
				.map(clubMapper::entityClubToDomainClub);
	}

	@Override
	public Club save(Club club) {
		ClubEntity clubEntity = clubMapper.domainClubToEntityClub(club);
		ClubEntity savedEntity = clubRepositoryJpa.save(clubEntity);
		return clubMapper.entityClubToDomainClub(savedEntity);
	}

	@Override
	public void deleteById(int id) {
		clubRepositoryJpa.deleteById(id);
	}
}