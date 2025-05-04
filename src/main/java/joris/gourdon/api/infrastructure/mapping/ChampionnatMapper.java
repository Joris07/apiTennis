package joris.gourdon.api.infrastructure.mapping;

import joris.gourdon.api.domain.models.Championnat;
import joris.gourdon.api.infrastructure.persistence.entities.ChampionnatEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {CategorieMapper.class, DivisionMapper.class})
public interface ChampionnatMapper {
    ChampionnatMapper INSTANCE = Mappers.getMapper(ChampionnatMapper.class);

    @Mapping(source = "categorieEntity", target = "categorie")
    @Mapping(source = "divisionEntity", target = "division")
    Championnat entityChampionnatToDomainChampionnat(ChampionnatEntity entityChampionnat);

    @Mapping(source = "categorie", target = "categorieEntity")
    @Mapping(source = "division", target = "divisionEntity")
    ChampionnatEntity domainChampionnatToEntityChampionnat(Championnat domainChampionnat);
} 