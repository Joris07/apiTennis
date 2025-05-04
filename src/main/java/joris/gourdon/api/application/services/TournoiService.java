package joris.gourdon.api.application.services;

import joris.gourdon.api.application.mappingDTO.TournoiDTOMapper;
import joris.gourdon.api.application.usecases.Tournoi.*;
import joris.gourdon.api.domain.dto.requests.TournoiRequestDTO;
import joris.gourdon.api.domain.dto.responses.TournoiResponseDTO;
import joris.gourdon.api.domain.models.Tournoi;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TournoiService {
    private final FindAllTournoi findAllTournoi;
    private final FindTournoiById findTournoiById;
    private final CreateTournoi createTournoi;
    private final UpdateTournoi updateTournoi;
    private final DeleteTournoi deleteTournoi;
    private final TournoiDTOMapper tournoiDTOMapper = TournoiDTOMapper.INSTANCE;

    public TournoiService(FindAllTournoi findAllTournoi,
                          FindTournoiById findTournoiById,
                          CreateTournoi createTournoi,
                          UpdateTournoi updateTournoi,
                          DeleteTournoi deleteTournoi) {
        this.findAllTournoi = findAllTournoi;
        this.findTournoiById = findTournoiById;
        this.createTournoi = createTournoi;
        this.updateTournoi = updateTournoi;
        this.deleteTournoi = deleteTournoi;
    }

    public List<TournoiResponseDTO> findAll() {
        return findAllTournoi.findAll().stream()
                .map(tournoiDTOMapper::toResponseDTO)
                .toList();
    }

    public TournoiResponseDTO findById(int id) {
        return findTournoiById.findById(id)
                .map(tournoiDTOMapper::toResponseDTO)
                .orElseThrow(() -> new RuntimeException("Tournoi non trouvé avec l'id : " + id));
    }

    public TournoiResponseDTO createTournoi(TournoiRequestDTO tournoiRequestDTO) {
        Tournoi tournoi = tournoiDTOMapper.toRequestDomain(tournoiRequestDTO, 0);
        Tournoi savedTournoi = createTournoi.create(tournoi);
        return tournoiDTOMapper.toResponseDTO(savedTournoi);
    }

    public TournoiResponseDTO updateTournoi(int id, TournoiRequestDTO tournoiRequestDTO) {
        Tournoi tournoi = tournoiDTOMapper.toRequestDomain(tournoiRequestDTO, id);
        Tournoi updatedTournoi = updateTournoi.update(id, tournoi);
        return tournoiDTOMapper.toResponseDTO(updatedTournoi);
    }

    public void deleteTournoi(int id) {
        deleteTournoi.delete(id);
    }
} 