package joris.gourdon.api.infrastructure.mapping;

import joris.gourdon.api.domain.models.Club;
import joris.gourdon.api.infrastructure.persistence.entities.ClubEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClubMapper {
	ClubMapper INSTANCE = Mappers.getMapper(ClubMapper.class);

	@Mapping(source = "id", target = "id")
	@Mapping(source = "nom", target = "nom")
	@Mapping(source = "adresse", target = "adresse")
	@Mapping(source = "ville", target = "ville")
	@Mapping(source = "codePostal", target = "codePostal")
	@Mapping(source = "pays", target = "pays")
	Club entityClubToDomainClub(ClubEntity entityClub);

	@Mapping(source = "id", target = "id")
	@Mapping(source = "nom", target = "nom")
	@Mapping(source = "adresse", target = "adresse")
	@Mapping(source = "ville", target = "ville")
	@Mapping(source = "codePostal", target = "codePostal")
	@Mapping(source = "pays", target = "pays")
	ClubEntity domainClubToEntityClub(Club domainClub);
}
