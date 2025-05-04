package joris.gourdon.api.infrastructure.mapping;

import joris.gourdon.api.domain.models.TypeTournoi;
import joris.gourdon.api.infrastructure.persistence.entities.TypeTournoiEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TypeTournoiMapper {
    TypeTournoiMapper INSTANCE = Mappers.getMapper(TypeTournoiMapper.class);

    TypeTournoi entityTypeTournoiToDomainTypeTournoi(TypeTournoiEntity entityTypeTournoi);
    TypeTournoiEntity domainTypeTournoiToEntityTypeTournoi(TypeTournoi domainTypeTournoi);
} 