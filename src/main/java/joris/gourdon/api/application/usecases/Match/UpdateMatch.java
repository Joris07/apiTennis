package joris.gourdon.api.application.usecases.Match;

import joris.gourdon.api.domain.models.Match;
import joris.gourdon.api.domain.repositories.MatchRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UpdateMatch {
    private final MatchRepository matchRepository;

    public UpdateMatch(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    public Match update(int id, Match matchDetails) {
        return matchRepository.findById(id)
                .map(existingMatch -> {
                    existingMatch.setJoueur1(matchDetails.getJoueur1());
                    existingMatch.setJoueur2(matchDetails.getJoueur2());
                    existingMatch.setScore(matchDetails.getScore());
                    existingMatch.setGagnant(matchDetails.getGagnant());
                    existingMatch.setRencontre(matchDetails.getRencontre());
                    existingMatch.setTournoi(matchDetails.getTournoi());
                    return matchRepository.save(existingMatch);
                })
                .orElseThrow(() -> new EntityNotFoundException("Match non trouvé avec l'id : " + id));
    }
} 