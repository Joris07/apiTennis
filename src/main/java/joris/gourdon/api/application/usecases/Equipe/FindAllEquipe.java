package joris.gourdon.api.application.usecases.Equipe;

import joris.gourdon.api.domain.models.Equipe;
import joris.gourdon.api.domain.repositories.EquipeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindAllEquipe {
    private final EquipeRepository equipeRepository;

    public FindAllEquipe(EquipeRepository equipeRepository) {
        this.equipeRepository = equipeRepository;
    }

    public List<Equipe> findAll() {
        return equipeRepository.findAll();
    }
} 