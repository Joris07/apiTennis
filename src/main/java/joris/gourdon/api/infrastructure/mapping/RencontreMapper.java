package joris.gourdon.api.infrastructure.mapping;

import joris.gourdon.api.domain.models.Rencontre;
import joris.gourdon.api.infrastructure.persistence.entities.RencontreEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {PouleMapper.class, EquipeMapper.class})
public interface RencontreMapper {
    RencontreMapper INSTANCE = Mappers.getMapper(RencontreMapper.class);

    @Mapping(source = "pouleEntity", target = "poule")
    @Mapping(source = "equipe1Entity", target = "equipe1")
    @Mapping(source = "equipe2Entity", target = "equipe2")
    @Mapping(source = "gagnantEntity", target = "gagnant")
    Rencontre entityRencontreToDomainRencontre(RencontreEntity entityRencontre);

    @Mapping(source = "poule", target = "pouleEntity")
    @Mapping(source = "equipe1", target = "equipe1Entity")
    @Mapping(source = "equipe2", target = "equipe2Entity")
    @Mapping(source = "gagnant", target = "gagnantEntity")
    RencontreEntity domainRencontreToEntityRencontre(Rencontre domainRencontre);
} 