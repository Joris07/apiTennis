package joris.gourdon.api.infrastructure.persistence.repositoriesImpl;

import joris.gourdon.api.domain.models.Tournoi;
import joris.gourdon.api.domain.repositories.TournoiRepository;
import joris.gourdon.api.infrastructure.mapping.TournoiMapper;
import joris.gourdon.api.infrastructure.persistence.entities.TournoiEntity;
import joris.gourdon.api.infrastructure.persistence.repositories.TournoiRepositoryJpa;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class TournoiRepositoryImpl implements TournoiRepository {
    private final TournoiRepositoryJpa tournoiRepositoryJpa;
    private final TournoiMapper tournoiMapper = TournoiMapper.INSTANCE;

    public TournoiRepositoryImpl(TournoiRepositoryJpa tournoiRepositoryJpa) {
        this.tournoiRepositoryJpa = tournoiRepositoryJpa;
    }

    @Override
    public List<Tournoi> findAll() {
        return tournoiRepositoryJpa.findAllWithRelations().stream()
                .map(tournoiMapper::entityTournoiToDomainTournoi)
                .toList();
    }

    @Override
    public Optional<Tournoi> findById(int id) {
        return tournoiRepositoryJpa.findByIdWithRelations(id)
                .map(tournoiMapper::entityTournoiToDomainTournoi);
    }

    @Override
    public Tournoi save(Tournoi tournoi) {
        TournoiEntity entity = tournoiMapper.domainTournoiToEntityTournoi(tournoi);
        TournoiEntity savedEntity = tournoiRepositoryJpa.save(entity);
        return tournoiMapper.entityTournoiToDomainTournoi(savedEntity);
    }

    @Override
    public void deleteById(int id) {
        tournoiRepositoryJpa.deleteById(id);
    }
} 