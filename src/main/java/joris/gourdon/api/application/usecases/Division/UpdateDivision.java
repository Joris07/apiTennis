package joris.gourdon.api.application.usecases.Division;

import jakarta.persistence.EntityNotFoundException;
import joris.gourdon.api.domain.models.Division;
import joris.gourdon.api.domain.repositories.DivisionRepository;
import org.springframework.stereotype.Service;

@Service
public class UpdateDivision {
    private final DivisionRepository divisionRepository;

    public UpdateDivision(DivisionRepository divisionRepository) {
        this.divisionRepository = divisionRepository;
    }

    public Division update(int id, Division divisionDetails) {
        Division existingDivision = divisionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Division non trouvée."));

        existingDivision.setNom(divisionDetails.getNom());

        return divisionRepository.save(existingDivision);
    }
} 