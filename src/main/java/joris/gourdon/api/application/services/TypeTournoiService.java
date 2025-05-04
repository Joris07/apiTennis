package joris.gourdon.api.application.services;

import joris.gourdon.api.domain.dto.responses.TypeTournoiResponseDTO;
import joris.gourdon.api.domain.models.TypeTournoi;
import joris.gourdon.api.domain.repositories.TypeTournoiRepository;
import joris.gourdon.api.infrastructure.mapping.TypeTournoiMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeTournoiService {
    private final TypeTournoiRepository typeTournoiRepository;
    private final TypeTournoiMapper typeTournoiMapper = TypeTournoiMapper.INSTANCE;

    public TypeTournoiService(TypeTournoiRepository typeTournoiRepository) {
        this.typeTournoiRepository = typeTournoiRepository;
    }

    public List<TypeTournoiResponseDTO> findAll() {
        List<TypeTournoi> typeTournois = typeTournoiRepository.findAll();
        return typeTournois.stream()
                .map(this::toResponseDTO)
                .toList();
    }

    public TypeTournoiResponseDTO findById(int id) {
        TypeTournoi typeTournoi = typeTournoiRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Type de tournoi non trouvé avec l'id : " + id));
        return toResponseDTO(typeTournoi);
    }

    private TypeTournoiResponseDTO toResponseDTO(TypeTournoi typeTournoi) {
        return new TypeTournoiResponseDTO(
                typeTournoi.getId(),
                typeTournoi.getNom()
        );
    }
} 