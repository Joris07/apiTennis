package joris.gourdon.api.infrastructure.persistence.repositoriesImpl;

import joris.gourdon.api.domain.models.Championnat;
import joris.gourdon.api.domain.repositories.ChampionnatRepository;
import joris.gourdon.api.infrastructure.mapping.ChampionnatMapper;
import joris.gourdon.api.infrastructure.persistence.entities.ChampionnatEntity;
import joris.gourdon.api.infrastructure.persistence.repositories.ChampionnatRepositoryJpa;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ChampionnatRepositoryImpl implements ChampionnatRepository {
    private final ChampionnatRepositoryJpa championnatRepositoryJpa;
    private final ChampionnatMapper championnatMapper = ChampionnatMapper.INSTANCE;

    public ChampionnatRepositoryImpl(ChampionnatRepositoryJpa championnatRepositoryJpa) {
        this.championnatRepositoryJpa = championnatRepositoryJpa;
    }

    @Override
    public List<Championnat> findAll() {
        return championnatRepositoryJpa.findAll().stream()
                .map(championnatMapper::entityChampionnatToDomainChampionnat)
                .toList();
    }

    @Override
    public Optional<Championnat> findById(int id) {
        return championnatRepositoryJpa.findById(id)
                .map(championnatMapper::entityChampionnatToDomainChampionnat);
    }

    @Override
    public Championnat save(Championnat championnat) {
        ChampionnatEntity entity = championnatMapper.domainChampionnatToEntityChampionnat(championnat);
        ChampionnatEntity savedEntity = championnatRepositoryJpa.save(entity);
        return championnatMapper.entityChampionnatToDomainChampionnat(savedEntity);
    }

    @Override
    public void deleteById(int id) {
        championnatRepositoryJpa.deleteById(id);
    }
} 