package joris.gourdon.api.infrastructure.mapping;

import joris.gourdon.api.domain.models.Categorie;
import joris.gourdon.api.infrastructure.persistence.entities.CategorieEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CategorieMapper {
    CategorieMapper INSTANCE = Mappers.getMapper(CategorieMapper.class);

    CategorieEntity domainCategorieToEntityCategorie(Categorie domainCategorie);
    Categorie entityCategorieToDomainCategorie(CategorieEntity entityCategorie);
} 