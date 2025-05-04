package joris.gourdon.api.infrastructure.persistence.repositoriesImpl;

import joris.gourdon.api.domain.models.Equipe;
import joris.gourdon.api.domain.repositories.EquipeRepository;
import joris.gourdon.api.infrastructure.mapping.EquipeMapper;
import joris.gourdon.api.infrastructure.persistence.entities.EquipeEntity;
import joris.gourdon.api.infrastructure.persistence.repositoriesJpa.EquipeRepositoryJpa;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class EquipeRepositoryImpl implements EquipeRepository {
    private final EquipeRepositoryJpa equipeRepositoryJpa;
    private final EquipeMapper equipeMapper = EquipeMapper.INSTANCE;

    public EquipeRepositoryImpl(EquipeRepositoryJpa equipeRepositoryJpa) {
        this.equipeRepositoryJpa = equipeRepositoryJpa;
    }

    @Override
    public List<Equipe> findAll() {
        return equipeRepositoryJpa.findAll().stream()
                .map(equipeMapper::entityEquipeToDomainEquipe)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Equipe> findById(int id) {
        return equipeRepositoryJpa.findById(id)
                .map(equipeMapper::entityEquipeToDomainEquipe);
    }

    @Override
    public Equipe save(Equipe equipe) {
        EquipeEntity equipeEntity = equipeMapper.domainEquipeToEntityEquipe(equipe);
        EquipeEntity savedEntity = equipeRepositoryJpa.save(equipeEntity);
        return equipeMapper.entityEquipeToDomainEquipe(savedEntity);
    }

    @Override
    public void deleteById(int id) {
        equipeRepositoryJpa.deleteById(id);
    }
} 