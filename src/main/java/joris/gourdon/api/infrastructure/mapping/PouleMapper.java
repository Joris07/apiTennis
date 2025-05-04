package joris.gourdon.api.infrastructure.mapping;

import joris.gourdon.api.domain.models.Poule;
import joris.gourdon.api.infrastructure.persistence.entities.PouleEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {TournoiMapper.class})
public interface PouleMapper {
    PouleMapper INSTANCE = Mappers.getMapper(PouleMapper.class);

    @Mapping(source = "championnat", target = "tournoi")
    Poule entityPouleToDomainPoule(PouleEntity entityPoule);

    @Mapping(source = "tournoi", target = "championnat")
    PouleEntity domainPouleToEntityPoule(Poule domainPoule);
} 