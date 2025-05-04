package joris.gourdon.api.application.usecases.Match;

import joris.gourdon.api.domain.models.Match;
import joris.gourdon.api.domain.repositories.MatchRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindAllMatch {
    private final MatchRepository matchRepository;

    public FindAllMatch(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    public List<Match> findAll() {
        return matchRepository.findAll();
    }
} 