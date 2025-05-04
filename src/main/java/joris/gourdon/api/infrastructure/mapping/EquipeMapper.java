package joris.gourdon.api.infrastructure.mapping;

import joris.gourdon.api.domain.models.Equipe;
import joris.gourdon.api.infrastructure.persistence.entities.EquipeEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {ClubMapper.class})
public interface EquipeMapper {
    EquipeMapper INSTANCE = Mappers.getMapper(EquipeMapper.class);

    @Mapping(source = "club", target = "club")
    Equipe entityEquipeToDomainEquipe(EquipeEntity entityEquipe);

    @Mapping(source = "club", target = "club")
    EquipeEntity domainEquipeToEntityEquipe(Equipe domainEquipe);
} 