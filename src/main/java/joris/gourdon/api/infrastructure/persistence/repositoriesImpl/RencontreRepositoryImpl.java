package joris.gourdon.api.infrastructure.persistence.repositoriesImpl;

import joris.gourdon.api.domain.models.Rencontre;
import joris.gourdon.api.domain.repositories.RencontreRepository;
import joris.gourdon.api.infrastructure.mapping.RencontreMapper;
import joris.gourdon.api.infrastructure.persistence.entities.RencontreEntity;
import joris.gourdon.api.infrastructure.persistence.repositories.RencontreRepositoryJpa;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class RencontreRepositoryImpl implements RencontreRepository {
    private final RencontreRepositoryJpa rencontreRepositoryJpa;
    private final RencontreMapper rencontreMapper = RencontreMapper.INSTANCE;

    public RencontreRepositoryImpl(RencontreRepositoryJpa rencontreRepositoryJpa) {
        this.rencontreRepositoryJpa = rencontreRepositoryJpa;
    }

    @Override
    public List<Rencontre> findAll() {
        return rencontreRepositoryJpa.findAll().stream()
                .map(rencontreMapper::entityRencontreToDomainRencontre)
                .toList();
    }

    @Override
    public Optional<Rencontre> findById(int id) {
        return rencontreRepositoryJpa.findById(id)
                .map(rencontreMapper::entityRencontreToDomainRencontre);
    }

    @Override
    public Rencontre save(Rencontre rencontre) {
        RencontreEntity entity = rencontreMapper.domainRencontreToEntityRencontre(rencontre);
        RencontreEntity savedEntity = rencontreRepositoryJpa.save(entity);
        return rencontreMapper.entityRencontreToDomainRencontre(savedEntity);
    }

    @Override
    public void deleteById(int id) {
        rencontreRepositoryJpa.deleteById(id);
    }
} 