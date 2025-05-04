package joris.gourdon.api.application.usecases.Match;

import joris.gourdon.api.domain.models.Match;
import joris.gourdon.api.domain.repositories.MatchRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FindMatchById {
    private final MatchRepository matchRepository;

    public FindMatchById(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    public Optional<Match> findById(int id) {
        return matchRepository.findById(id);
    }
} 