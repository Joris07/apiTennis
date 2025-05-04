package joris.gourdon.api.application.usecases.Match;

import joris.gourdon.api.domain.models.Match;
import joris.gourdon.api.domain.repositories.MatchRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class DeleteMatch {
    private final MatchRepository matchRepository;

    public DeleteMatch(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    public void delete(int id) {
        matchRepository.findById(id)
                .ifPresentOrElse(
                        match -> matchRepository.deleteById(id),
                        () -> {
                            throw new EntityNotFoundException("Match non trouvé avec l'id : " + id);
                        }
                );
    }
} 