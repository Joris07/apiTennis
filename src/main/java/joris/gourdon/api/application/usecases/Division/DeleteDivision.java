package joris.gourdon.api.application.usecases.Division;

import jakarta.persistence.EntityNotFoundException;
import joris.gourdon.api.domain.models.Division;
import joris.gourdon.api.domain.repositories.DivisionRepository;
import org.springframework.stereotype.Service;

@Service
public class DeleteDivision {
    private final DivisionRepository divisionRepository;

    public DeleteDivision(DivisionRepository divisionRepository) {
        this.divisionRepository = divisionRepository;
    }

    public void delete(int id) {
        Division division = divisionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Division non trouvée."));
        divisionRepository.deleteById(id);
    }
} 