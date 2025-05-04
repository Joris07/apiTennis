package joris.gourdon.api.application.usecases.Equipe;

import jakarta.persistence.EntityNotFoundException;
import joris.gourdon.api.domain.models.Equipe;
import joris.gourdon.api.domain.repositories.EquipeRepository;
import org.springframework.stereotype.Service;

@Service
public class DeleteEquipe {
    private final EquipeRepository equipeRepository;

    public DeleteEquipe(EquipeRepository equipeRepository) {
        this.equipeRepository = equipeRepository;
    }

    public void delete(int id) {
        Equipe equipe = equipeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Équipe non trouvée."));
        equipeRepository.deleteById(id);
    }
} 