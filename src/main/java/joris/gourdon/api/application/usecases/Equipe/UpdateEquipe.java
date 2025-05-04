package joris.gourdon.api.application.usecases.Equipe;

import jakarta.persistence.EntityNotFoundException;
import joris.gourdon.api.domain.models.Equipe;
import joris.gourdon.api.domain.repositories.EquipeRepository;
import org.springframework.stereotype.Service;

@Service
public class UpdateEquipe {
    private final EquipeRepository equipeRepository;

    public UpdateEquipe(EquipeRepository equipeRepository) {
        this.equipeRepository = equipeRepository;
    }

    public Equipe update(int id, Equipe equipeDetails) {
        Equipe existingEquipe = equipeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Équipe non trouvée."));

        existingEquipe.setNom(equipeDetails.getNom());
        existingEquipe.setClub(equipeDetails.getClub());
        existingEquipe.setCategorie(equipeDetails.getCategorie());
        existingEquipe.setDivision(equipeDetails.getDivision());

        return equipeRepository.save(existingEquipe);
    }
} 