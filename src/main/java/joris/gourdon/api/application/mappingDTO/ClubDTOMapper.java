package joris.gourdon.api.application.mappingDTO;

import joris.gourdon.api.domain.dto.ClubDTO;
import joris.gourdon.api.domain.models.Club;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ClubDTOMapper {
	ClubDTOMapper INSTANCE = Mappers.getMapper(ClubDTOMapper.class);

	ClubDTO toDTO(Club club);
	Club toDomain(ClubDTO clubDTO);
}
