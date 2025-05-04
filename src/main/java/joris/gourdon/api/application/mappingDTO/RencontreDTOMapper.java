package joris.gourdon.api.application.mappingDTO;

import joris.gourdon.api.domain.dto.requests.RencontreRequestDTO;
import joris.gourdon.api.domain.dto.responses.RencontreResponseDTO;
import joris.gourdon.api.domain.models.Rencontre;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface RencontreDTOMapper {
    RencontreDTOMapper INSTANCE = Mappers.getMapper(RencontreDTOMapper.class);

    RencontreResponseDTO toResponseDTO(Rencontre rencontre);
    Rencontre toRequestDomain(RencontreRequestDTO rencontreRequestDTO, int id);
} 