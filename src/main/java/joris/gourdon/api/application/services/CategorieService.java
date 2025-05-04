package joris.gourdon.api.application.services;

import jakarta.persistence.EntityNotFoundException;
import joris.gourdon.api.application.mappingDTO.CategorieDTOMapper;
import joris.gourdon.api.application.usecases.Categorie.*;
import joris.gourdon.api.domain.dto.requests.CategorieRequestDTO;
import joris.gourdon.api.domain.dto.responses.CategorieResponseDTO;
import joris.gourdon.api.domain.models.Categorie;
import joris.gourdon.api.domain.repositories.CategorieRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class CategorieService {
    private final FindAllCategorie findAllCategorie;
    private final CreateCategorie createCategorie;
    private final UpdateCategorie updateCategorie;
    private final FindCategorieById findCategorieById;
    private final DeleteCategorie deleteCategorie;
    private final CategorieRepository categorieRepository;
    private final CategorieDTOMapper categorieDTOMapper;

    public List<CategorieResponseDTO> findAll() {
        return findAllCategorie.findAll().stream()
                .map(categorieDTOMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    public CategorieResponseDTO findById(int id) {
        Categorie categorie = findCategorieById.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Catégorie non trouvée"));
        return categorieDTOMapper.toResponseDTO(categorie);
    }

    public CategorieResponseDTO createCategorie(CategorieRequestDTO categorieRequestDTO) {
        Categorie categorie = categorieDTOMapper.toRequestDomain(categorieRequestDTO, 0);
        Categorie savedCategorie = createCategorie.create(categorie);
        return categorieDTOMapper.toResponseDTO(savedCategorie);
    }

    public CategorieResponseDTO updateCategorie(int id, CategorieRequestDTO categorieRequestDTO) {
        Categorie categorie = categorieDTOMapper.toRequestDomain(categorieRequestDTO, id);
        Categorie updatedCategorie = updateCategorie.update(id, categorie);
        return categorieDTOMapper.toResponseDTO(updatedCategorie);
    }

    public void deleteCategorie(int id) {
        deleteCategorie.delete(id);
    }
} 