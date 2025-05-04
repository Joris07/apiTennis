package joris.gourdon.api.application.services;

import joris.gourdon.api.application.mappingDTO.RencontreDTOMapper;
import joris.gourdon.api.application.usecases.Rencontre.*;
import joris.gourdon.api.domain.dto.requests.RencontreRequestDTO;
import joris.gourdon.api.domain.dto.responses.RencontreResponseDTO;
import joris.gourdon.api.domain.models.Rencontre;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RencontreService {
    private final FindAllRencontre findAllRencontre;
    private final FindRencontreById findRencontreById;
    private final CreateRencontre createRencontre;
    private final UpdateRencontre updateRencontre;
    private final DeleteRencontre deleteRencontre;
    private final RencontreDTOMapper rencontreDTOMapper = RencontreDTOMapper.INSTANCE;

    public RencontreService(FindAllRencontre findAllRencontre,
                          FindRencontreById findRencontreById,
                          CreateRencontre createRencontre,
                          UpdateRencontre updateRencontre,
                          DeleteRencontre deleteRencontre) {
        this.findAllRencontre = findAllRencontre;
        this.findRencontreById = findRencontreById;
        this.createRencontre = createRencontre;
        this.updateRencontre = updateRencontre;
        this.deleteRencontre = deleteRencontre;
    }

    public List<RencontreResponseDTO> findAll() {
        return findAllRencontre.findAll().stream()
                .map(rencontreDTOMapper::toResponseDTO)
                .toList();
    }

    public RencontreResponseDTO findById(int id) {
        return findRencontreById.findById(id)
                .map(rencontreDTOMapper::toResponseDTO)
                .orElseThrow(() -> new RuntimeException("Rencontre non trouvée avec l'id : " + id));
    }

    public RencontreResponseDTO createRencontre(RencontreRequestDTO rencontreRequestDTO) {
        Rencontre rencontre = rencontreDTOMapper.toRequestDomain(rencontreRequestDTO, 0);
        Rencontre savedRencontre = createRencontre.create(rencontre);
        return rencontreDTOMapper.toResponseDTO(savedRencontre);
    }

    public RencontreResponseDTO updateRencontre(int id, RencontreRequestDTO rencontreRequestDTO) {
        Rencontre rencontre = rencontreDTOMapper.toRequestDomain(rencontreRequestDTO, id);
        Rencontre updatedRencontre = updateRencontre.update(id, rencontre);
        return rencontreDTOMapper.toResponseDTO(updatedRencontre);
    }

    public void deleteRencontre(int id) {
        deleteRencontre.delete(id);
    }
} 