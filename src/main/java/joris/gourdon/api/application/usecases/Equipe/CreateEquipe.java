package joris.gourdon.api.application.usecases.Equipe;

import joris.gourdon.api.domain.models.Equipe;
import joris.gourdon.api.domain.repositories.EquipeRepository;
import org.springframework.stereotype.Service;

@Service
public class CreateEquipe {
    private final EquipeRepository equipeRepository;

    public CreateEquipe(EquipeRepository equipeRepository) {
        this.equipeRepository = equipeRepository;
    }

    public Equipe create(Equipe equipe) {
        return equipeRepository.save(equipe);
    }
} 