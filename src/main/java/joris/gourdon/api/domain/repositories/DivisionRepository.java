package joris.gourdon.api.domain.repositories;

import joris.gourdon.api.domain.models.Division;

import java.util.List;
import java.util.Optional;

public interface DivisionRepository {
    List<Division> findAll();
    Optional<Division> findById(int id);
    Division save(Division division);
    void deleteById(int id);
} 