package joris.gourdon.api.application.mappingDTO;

import joris.gourdon.api.domain.dto.requests.DivisionRequestDTO;
import joris.gourdon.api.domain.dto.responses.DivisionResponseDTO;
import joris.gourdon.api.domain.models.Division;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface DivisionDTOMapper {
    DivisionDTOMapper INSTANCE = Mappers.getMapper(DivisionDTOMapper.class);

    DivisionResponseDTO toResponseDTO(Division division);
    Division toRequestDomain(DivisionRequestDTO divisionRequestDTO, int id);
} 