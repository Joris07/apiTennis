package joris.gourdon.api.infrastructure.mapping;

import joris.gourdon.api.domain.models.Match;
import joris.gourdon.api.infrastructure.persistence.entities.MatchEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {JoueurMapper.class, RencontreMapper.class, TournoiMapper.class})
public interface MatchMapper {
    MatchMapper INSTANCE = Mappers.getMapper(MatchMapper.class);

    @Mapping(source = "joueurEntity1", target = "joueur1")
    @Mapping(source = "joueurEntity2", target = "joueur2")
    @Mapping(source = "rencontreEntity", target = "rencontre")
    @Mapping(source = "tournoiEntity", target = "tournoi")
    Match entityMatchToDomainMatch(MatchEntity entityMatch);

    @Mapping(source = "joueur1", target = "joueurEntity1")
    @Mapping(source = "joueur2", target = "joueurEntity2")
    @Mapping(source = "rencontre", target = "rencontreEntity")
    @Mapping(source = "tournoi", target = "tournoiEntity")
    MatchEntity domainMatchToEntityMatch(Match domainMatch);
} 