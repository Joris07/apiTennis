package joris.gourdon.api.application.usecases.Championnat;

import joris.gourdon.api.domain.models.Championnat;
import joris.gourdon.api.domain.repositories.ChampionnatRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindAllChampionnat {
    private final ChampionnatRepository championnatRepository;

    public FindAllChampionnat(ChampionnatRepository championnatRepository) {
        this.championnatRepository = championnatRepository;
    }

    public List<Championnat> findAll() {
        return championnatRepository.findAll();
    }
} 