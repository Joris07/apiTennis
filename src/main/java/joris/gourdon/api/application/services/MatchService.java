package joris.gourdon.api.application.services;

import joris.gourdon.api.application.mappingDTO.MatchDTOMapper;
import joris.gourdon.api.application.usecases.Match.*;
import joris.gourdon.api.domain.dto.requests.MatchRequestDTO;
import joris.gourdon.api.domain.dto.responses.MatchResponseDTO;
import joris.gourdon.api.domain.models.Match;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchService {
    private final FindAllMatch findAllMatch;
    private final FindMatchById findMatchById;
    private final CreateMatch createMatch;
    private final UpdateMatch updateMatch;
    private final DeleteMatch deleteMatch;
    private final MatchDTOMapper matchDTOMapper = MatchDTOMapper.INSTANCE;

    public MatchService(FindAllMatch findAllMatch,
                       FindMatchById findMatchById,
                       CreateMatch createMatch,
                       UpdateMatch updateMatch,
                       DeleteMatch deleteMatch) {
        this.findAllMatch = findAllMatch;
        this.findMatchById = findMatchById;
        this.createMatch = createMatch;
        this.updateMatch = updateMatch;
        this.deleteMatch = deleteMatch;
    }

    public List<MatchResponseDTO> findAll() {
        return findAllMatch.findAll().stream()
                .map(matchDTOMapper::toResponseDTO)
                .toList();
    }

    public MatchResponseDTO findById(int id) {
        return findMatchById.findById(id)
                .map(matchDTOMapper::toResponseDTO)
                .orElseThrow(() -> new RuntimeException("Match non trouvé avec l'id : " + id));
    }

    public MatchResponseDTO createMatch(MatchRequestDTO matchRequestDTO) {
        Match match = matchDTOMapper.toRequestDomain(matchRequestDTO, 0);
        Match savedMatch = createMatch.create(match);
        return matchDTOMapper.toResponseDTO(savedMatch);
    }

    public MatchResponseDTO updateMatch(int id, MatchRequestDTO matchRequestDTO) {
        Match match = matchDTOMapper.toRequestDomain(matchRequestDTO, id);
        Match updatedMatch = updateMatch.update(id, match);
        return matchDTOMapper.toResponseDTO(updatedMatch);
    }

    public void deleteMatch(int id) {
        deleteMatch.delete(id);
    }
} 