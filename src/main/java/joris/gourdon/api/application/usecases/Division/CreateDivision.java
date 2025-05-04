package joris.gourdon.api.application.usecases.Division;

import joris.gourdon.api.domain.models.Division;
import joris.gourdon.api.domain.repositories.DivisionRepository;
import org.springframework.stereotype.Service;

@Service
public class CreateDivision {
    private final DivisionRepository divisionRepository;

    public CreateDivision(DivisionRepository divisionRepository) {
        this.divisionRepository = divisionRepository;
    }

    public Division create(Division division) {
        return divisionRepository.save(division);
    }
} 