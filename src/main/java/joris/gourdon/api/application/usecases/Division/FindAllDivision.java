package joris.gourdon.api.application.usecases.Division;

import joris.gourdon.api.domain.models.Division;
import joris.gourdon.api.domain.repositories.DivisionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindAllDivision {
    private final DivisionRepository divisionRepository;

    public FindAllDivision(DivisionRepository divisionRepository) {
        this.divisionRepository = divisionRepository;
    }

    public List<Division> findAll() {
        return divisionRepository.findAll();
    }
} 