package joris.gourdon.api.application.mappingDTO;

import joris.gourdon.api.domain.dto.requests.MatchRequestDTO;
import joris.gourdon.api.domain.dto.responses.MatchResponseDTO;
import joris.gourdon.api.domain.models.Match;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface MatchDTOMapper {
    MatchDTOMapper INSTANCE = Mappers.getMapper(MatchDTOMapper.class);

    MatchResponseDTO toResponseDTO(Match match);
    Match toRequestDomain(MatchRequestDTO matchRequestDTO, int id);
} 