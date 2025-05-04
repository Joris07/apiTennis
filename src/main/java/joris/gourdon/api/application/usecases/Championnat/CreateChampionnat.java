package joris.gourdon.api.application.usecases.Championnat;

import joris.gourdon.api.domain.models.Championnat;
import joris.gourdon.api.domain.repositories.ChampionnatRepository;
import org.springframework.stereotype.Service;

@Service
public class CreateChampionnat {
    private final ChampionnatRepository championnatRepository;

    public CreateChampionnat(ChampionnatRepository championnatRepository) {
        this.championnatRepository = championnatRepository;
    }

    public Championnat create(Championnat championnat) {
        return championnatRepository.save(championnat);
    }
} 