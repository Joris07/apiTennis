package joris.gourdon.api.application.mappingDTO;

import joris.gourdon.api.domain.dto.requests.ChampionnatRequestDTO;
import joris.gourdon.api.domain.dto.responses.ChampionnatResponseDTO;
import joris.gourdon.api.domain.models.Championnat;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ChampionnatDTOMapper {
    ChampionnatDTOMapper INSTANCE = Mappers.getMapper(ChampionnatDTOMapper.class);

    ChampionnatResponseDTO toResponseDTO(Championnat championnat);
    Championnat toRequestDomain(ChampionnatRequestDTO championnatRequestDTO, int id);
} 