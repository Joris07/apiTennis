package joris.gourdon.api.infrastructure.persistence.repositoriesImpl;

import joris.gourdon.api.domain.models.TypeTournoi;
import joris.gourdon.api.domain.repositories.TypeTournoiRepository;
import joris.gourdon.api.infrastructure.mapping.TypeTournoiMapper;
import joris.gourdon.api.infrastructure.persistence.repositories.TypeTournoiRepositoryJpa;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class TypeTournoiRepositoryImpl implements TypeTournoiRepository {
    private final TypeTournoiRepositoryJpa typeTournoiRepositoryJpa;
    private final TypeTournoiMapper typeTournoiMapper = TypeTournoiMapper.INSTANCE;

    public TypeTournoiRepositoryImpl(TypeTournoiRepositoryJpa typeTournoiRepositoryJpa) {
        this.typeTournoiRepositoryJpa = typeTournoiRepositoryJpa;
    }

    @Override
    public List<TypeTournoi> findAll() {
        return typeTournoiRepositoryJpa.findAll().stream()
                .map(typeTournoiMapper::entityTypeTournoiToDomainTypeTournoi)
                .toList();
    }

    @Override
    public Optional<TypeTournoi> findById(int id) {
        return typeTournoiRepositoryJpa.findById(id)
                .map(typeTournoiMapper::entityTypeTournoiToDomainTypeTournoi);
    }
} 