package joris.gourdon.api.infrastructure.mapping;

import joris.gourdon.api.domain.models.Club;
import joris.gourdon.api.infrastructure.persistence.entities.ClubEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClubMapper {
	ClubMapper INSTANCE = Mappers.getMapper(ClubMapper.class);

	// Transformation entre modèle et entité
	ClubEntity domainClubToEntityClub(Club domainClub);
	Club entityClubToDomainClub(ClubEntity entityClub);
}
