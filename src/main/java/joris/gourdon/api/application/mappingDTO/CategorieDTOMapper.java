package joris.gourdon.api.application.mappingDTO;

import joris.gourdon.api.domain.dto.requests.CategorieRequestDTO;
import joris.gourdon.api.domain.dto.responses.CategorieResponseDTO;
import joris.gourdon.api.domain.models.Categorie;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CategorieDTOMapper {
    CategorieDTOMapper INSTANCE = Mappers.getMapper(CategorieDTOMapper.class);

    CategorieResponseDTO toResponseDTO(Categorie categorie);
    Categorie toRequestDomain(CategorieRequestDTO categorieRequestDTO, int id);
} 