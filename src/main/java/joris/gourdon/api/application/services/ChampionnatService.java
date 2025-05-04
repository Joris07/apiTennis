package joris.gourdon.api.application.services;

import joris.gourdon.api.application.mappingDTO.ChampionnatDTOMapper;
import joris.gourdon.api.application.usecases.Championnat.*;
import joris.gourdon.api.domain.dto.requests.ChampionnatRequestDTO;
import joris.gourdon.api.domain.dto.responses.ChampionnatResponseDTO;
import joris.gourdon.api.domain.models.Championnat;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChampionnatService {
    private final FindAllChampionnat findAllChampionnat;
    private final FindChampionnatById findChampionnatById;
    private final CreateChampionnat createChampionnat;
    private final UpdateChampionnat updateChampionnat;
    private final DeleteChampionnat deleteChampionnat;
    private final ChampionnatDTOMapper championnatDTOMapper = ChampionnatDTOMapper.INSTANCE;

    public ChampionnatService(FindAllChampionnat findAllChampionnat,
                            FindChampionnatById findChampionnatById,
                            CreateChampionnat createChampionnat,
                            UpdateChampionnat updateChampionnat,
                            DeleteChampionnat deleteChampionnat) {
        this.findAllChampionnat = findAllChampionnat;
        this.findChampionnatById = findChampionnatById;
        this.createChampionnat = createChampionnat;
        this.updateChampionnat = updateChampionnat;
        this.deleteChampionnat = deleteChampionnat;
    }

    public List<ChampionnatResponseDTO> findAll() {
        return findAllChampionnat.findAll().stream()
                .map(championnatDTOMapper::toResponseDTO)
                .toList();
    }

    public ChampionnatResponseDTO findById(int id) {
        return findChampionnatById.findById(id)
                .map(championnatDTOMapper::toResponseDTO)
                .orElseThrow(() -> new RuntimeException("Championnat non trouvé avec l'id : " + id));
    }

    public ChampionnatResponseDTO createChampionnat(ChampionnatRequestDTO championnatRequestDTO) {
        Championnat championnat = championnatDTOMapper.toRequestDomain(championnatRequestDTO, 0);
        Championnat savedChampionnat = createChampionnat.create(championnat);
        return championnatDTOMapper.toResponseDTO(savedChampionnat);
    }

    public ChampionnatResponseDTO updateChampionnat(int id, ChampionnatRequestDTO championnatRequestDTO) {
        Championnat championnat = championnatDTOMapper.toRequestDomain(championnatRequestDTO, id);
        Championnat updatedChampionnat = updateChampionnat.update(id, championnat);
        return championnatDTOMapper.toResponseDTO(updatedChampionnat);
    }

    public void deleteChampionnat(int id) {
        deleteChampionnat.delete(id);
    }
} 