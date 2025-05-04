package joris.gourdon.api.infrastructure.persistence.repositoriesImpl;

import joris.gourdon.api.domain.models.Division;
import joris.gourdon.api.domain.repositories.DivisionRepository;
import joris.gourdon.api.infrastructure.mapping.DivisionMapper;
import joris.gourdon.api.infrastructure.persistence.entities.DivisionEntity;
import joris.gourdon.api.infrastructure.persistence.repositoriesJpa.DivisionRepositoryJpa;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class DivisionRepositoryImpl implements DivisionRepository {
    private final DivisionRepositoryJpa divisionRepositoryJpa;
    private final DivisionMapper divisionMapper = DivisionMapper.INSTANCE;

    public DivisionRepositoryImpl(DivisionRepositoryJpa divisionRepositoryJpa) {
        this.divisionRepositoryJpa = divisionRepositoryJpa;
    }

    @Override
    public List<Division> findAll() {
        return divisionRepositoryJpa.findAll().stream()
                .map(divisionMapper::entityDivisionToDomainDivision)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Division> findById(int id) {
        return divisionRepositoryJpa.findById(id)
                .map(divisionMapper::entityDivisionToDomainDivision);
    }

    @Override
    public Division save(Division division) {
        DivisionEntity divisionEntity = divisionMapper.domainDivisionToEntityDivision(division);
        DivisionEntity savedEntity = divisionRepositoryJpa.save(divisionEntity);
        return divisionMapper.entityDivisionToDomainDivision(savedEntity);
    }

    @Override
    public void deleteById(int id) {
        divisionRepositoryJpa.deleteById(id);
    }
} 