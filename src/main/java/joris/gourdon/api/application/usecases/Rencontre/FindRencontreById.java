package joris.gourdon.api.application.usecases.Rencontre;

import joris.gourdon.api.domain.models.Rencontre;
import joris.gourdon.api.domain.repositories.RencontreRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FindRencontreById {
    private final RencontreRepository rencontreRepository;

    public FindRencontreById(RencontreRepository rencontreRepository) {
        this.rencontreRepository = rencontreRepository;
    }

    public Optional<Rencontre> findById(int id) {
        return rencontreRepository.findById(id);
    }
} 