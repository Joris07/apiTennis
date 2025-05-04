package joris.gourdon.api.application.usecases.Championnat;

import joris.gourdon.api.domain.models.Championnat;
import joris.gourdon.api.domain.repositories.ChampionnatRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FindChampionnatById {
    private final ChampionnatRepository championnatRepository;

    public FindChampionnatById(ChampionnatRepository championnatRepository) {
        this.championnatRepository = championnatRepository;
    }

    public Optional<Championnat> findById(int id) {
        return championnatRepository.findById(id);
    }
} 