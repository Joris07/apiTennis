package joris.gourdon.api.application.usecases.Division;

import joris.gourdon.api.domain.models.Division;
import joris.gourdon.api.domain.repositories.DivisionRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FindDivisionById {
    private final DivisionRepository divisionRepository;

    public FindDivisionById(DivisionRepository divisionRepository) {
        this.divisionRepository = divisionRepository;
    }

    public Optional<Division> findById(int id) {
        return divisionRepository.findById(id);
    }
} 