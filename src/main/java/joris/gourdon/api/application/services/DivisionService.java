package joris.gourdon.api.application.services;

import joris.gourdon.api.application.mappingDTO.DivisionDTOMapper;
import joris.gourdon.api.application.usecases.Division.*;
import joris.gourdon.api.domain.dto.requests.DivisionRequestDTO;
import joris.gourdon.api.domain.dto.responses.DivisionResponseDTO;
import joris.gourdon.api.domain.models.Division;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DivisionService {
    private final FindAllDivision findAllDivision;
    private final FindDivisionById findDivisionById;
    private final CreateDivision createDivision;
    private final UpdateDivision updateDivision;
    private final DeleteDivision deleteDivision;
    private final DivisionDTOMapper divisionDTOMapper;

    public DivisionService(FindAllDivision findAllDivision,
                          FindDivisionById findDivisionById,
                          CreateDivision createDivision,
                          UpdateDivision updateDivision,
                          DeleteDivision deleteDivision,
                          DivisionDTOMapper divisionDTOMapper) {
        this.findAllDivision = findAllDivision;
        this.findDivisionById = findDivisionById;
        this.createDivision = createDivision;
        this.updateDivision = updateDivision;
        this.deleteDivision = deleteDivision;
        this.divisionDTOMapper = divisionDTOMapper;
    }

    public List<DivisionResponseDTO> findAll() {
        return findAllDivision.findAll().stream()
                .map(divisionDTOMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    public DivisionResponseDTO findById(int id) {
        return findDivisionById.findById(id)
                .map(divisionDTOMapper::toResponseDTO)
                .orElseThrow(() -> new RuntimeException("Division non trouvée."));
    }

    public DivisionResponseDTO createDivision(DivisionRequestDTO divisionRequestDTO) {
        Division division = divisionDTOMapper.toRequestDomain(divisionRequestDTO, 0);
        Division savedDivision = createDivision.create(division);
        return divisionDTOMapper.toResponseDTO(savedDivision);
    }

    public DivisionResponseDTO updateDivision(int id, DivisionRequestDTO divisionRequestDTO) {
        Division division = divisionDTOMapper.toRequestDomain(divisionRequestDTO, id);
        Division updatedDivision = updateDivision.update(id, division);
        return divisionDTOMapper.toResponseDTO(updatedDivision);
    }

    public void deleteDivision(int id) {
        deleteDivision.delete(id);
    }
} 