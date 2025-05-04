package joris.gourdon.api.application.usecases.Rencontre;

import joris.gourdon.api.domain.models.Rencontre;
import joris.gourdon.api.domain.repositories.RencontreRepository;
import org.springframework.stereotype.Service;

@Service
public class CreateRencontre {
    private final RencontreRepository rencontreRepository;

    public CreateRencontre(RencontreRepository rencontreRepository) {
        this.rencontreRepository = rencontreRepository;
    }

    public Rencontre create(Rencontre rencontre) {
        return rencontreRepository.save(rencontre);
    }
} 