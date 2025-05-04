package joris.gourdon.api.infrastructure.persistence.repositoriesImpl;

import joris.gourdon.api.domain.models.Match;
import joris.gourdon.api.domain.repositories.MatchRepository;
import joris.gourdon.api.infrastructure.mapping.MatchMapper;
import joris.gourdon.api.infrastructure.persistence.entities.MatchEntity;
import joris.gourdon.api.infrastructure.persistence.repositories.MatchRepositoryJpa;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MatchRepositoryImpl implements MatchRepository {
    private final MatchRepositoryJpa matchRepositoryJpa;
    private final MatchMapper matchMapper = MatchMapper.INSTANCE;

    public MatchRepositoryImpl(MatchRepositoryJpa matchRepositoryJpa) {
        this.matchRepositoryJpa = matchRepositoryJpa;
    }

    @Override
    public List<Match> findAll() {
        return matchRepositoryJpa.findAll().stream()
                .map(matchMapper::entityMatchToDomainMatch)
                .toList();
    }

    @Override
    public Optional<Match> findById(int id) {
        return matchRepositoryJpa.findById(id)
                .map(matchMapper::entityMatchToDomainMatch);
    }

    @Override
    public Match save(Match match) {
        MatchEntity entity = matchMapper.domainMatchToEntityMatch(match);
        MatchEntity savedEntity = matchRepositoryJpa.save(entity);
        return matchMapper.entityMatchToDomainMatch(savedEntity);
    }

    @Override
    public void deleteById(int id) {
        matchRepositoryJpa.deleteById(id);
    }
} 