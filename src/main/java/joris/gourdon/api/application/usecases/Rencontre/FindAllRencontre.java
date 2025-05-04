package joris.gourdon.api.application.usecases.Rencontre;

import joris.gourdon.api.domain.models.Rencontre;
import joris.gourdon.api.domain.repositories.RencontreRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindAllRencontre {
    private final RencontreRepository rencontreRepository;

    public FindAllRencontre(RencontreRepository rencontreRepository) {
        this.rencontreRepository = rencontreRepository;
    }

    public List<Rencontre> findAll() {
        return rencontreRepository.findAll();
    }
} 