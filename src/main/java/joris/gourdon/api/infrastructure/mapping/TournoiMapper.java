package joris.gourdon.api.infrastructure.mapping;

import joris.gourdon.api.domain.models.Tournoi;
import joris.gourdon.api.infrastructure.persistence.entities.TournoiEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {ClubMapper.class, TypeSurfaceMapper.class, TypeTournoiMapper.class})
public interface TournoiMapper {
    TournoiMapper INSTANCE = Mappers.getMapper(TournoiMapper.class);

    @Mapping(source = "club", target = "club")
    @Mapping(source = "typeSurfaceEntity", target = "typeSurface")
    @Mapping(source = "typeTournoiEntity", target = "typeTournoi")
    Tournoi entityTournoiToDomainTournoi(TournoiEntity entityTournoi);

    @Mapping(source = "club", target = "club")
    @Mapping(source = "typeSurface", target = "typeSurfaceEntity")
    @Mapping(source = "typeTournoi", target = "typeTournoiEntity")
    TournoiEntity domainTournoiToEntityTournoi(Tournoi domainTournoi);
} 