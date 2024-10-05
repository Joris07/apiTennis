package joris.gourdon.api.application.mappingDTO;

import joris.gourdon.api.domain.dto.EquipeDTO;
import joris.gourdon.api.domain.models.Equipe;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface EquipeDTOMapper {
	EquipeDTOMapper INSTANCE = Mappers.getMapper(EquipeDTOMapper.class);

	EquipeDTO toDTO(Equipe equipe);
	Equipe toDomain(EquipeDTO equipeDTO);
}