package joris.gourdon.api.application.services;

import jakarta.persistence.EntityNotFoundException;
import joris.gourdon.api.application.mappingDTO.EquipeDTOMapper;
import joris.gourdon.api.application.usecases.Equipe.*;
import joris.gourdon.api.domain.dto.requests.EquipeRequestDTO;
import joris.gourdon.api.domain.dto.responses.EquipeResponseDTO;
import joris.gourdon.api.domain.models.Equipe;
import joris.gourdon.api.domain.repositories.EquipeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class EquipeService {
    private final FindAllEquipe findAllEquipe;
    private final CreateEquipe createEquipe;
    private final UpdateEquipe updateEquipe;
    private final FindEquipeById findEquipeById;
    private final DeleteEquipe deleteEquipe;
    private final EquipeRepository equipeRepository;
    private final EquipeDTOMapper equipeDTOMapper;

    public List<EquipeResponseDTO> findAll() {
        return findAllEquipe.findAll().stream()
                .map(equipeDTOMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    public EquipeResponseDTO findById(int id) {
        Equipe equipe = findEquipeById.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Équipe non trouvée"));
        return equipeDTOMapper.toResponseDTO(equipe);
    }

    public EquipeResponseDTO createEquipe(EquipeRequestDTO equipeRequestDTO) {
        Equipe equipe = equipeDTOMapper.toRequestDomain(equipeRequestDTO, 0);
        Equipe savedEquipe = createEquipe.create(equipe);
        return equipeDTOMapper.toResponseDTO(savedEquipe);
    }

    public EquipeResponseDTO updateEquipe(int id, EquipeRequestDTO equipeRequestDTO) {
        Equipe equipe = equipeDTOMapper.toRequestDomain(equipeRequestDTO, id);
        Equipe updatedEquipe = updateEquipe.update(id, equipe);
        return equipeDTOMapper.toResponseDTO(updatedEquipe);
    }

    public void deleteEquipe(int id) {
        deleteEquipe.delete(id);
    }
} 