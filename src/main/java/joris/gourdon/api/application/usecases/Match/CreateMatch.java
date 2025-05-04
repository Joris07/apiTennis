package joris.gourdon.api.application.usecases.Match;

import joris.gourdon.api.domain.models.Match;
import joris.gourdon.api.domain.repositories.MatchRepository;
import org.springframework.stereotype.Service;

@Service
public class CreateMatch {
    private final MatchRepository matchRepository;

    public CreateMatch(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    public Match create(Match match) {
        return matchRepository.save(match);
    }
} 