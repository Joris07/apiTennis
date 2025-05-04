package joris.gourdon.api.application.usecases.Equipe;

import joris.gourdon.api.domain.models.Equipe;
import joris.gourdon.api.domain.repositories.EquipeRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FindEquipeById {
    private final EquipeRepository equipeRepository;

    public FindEquipeById(EquipeRepository equipeRepository) {
        this.equipeRepository = equipeRepository;
    }

    public Optional<Equipe> findById(int id) {
        return equipeRepository.findById(id);
    }
} 