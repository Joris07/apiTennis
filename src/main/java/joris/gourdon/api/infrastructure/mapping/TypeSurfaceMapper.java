package joris.gourdon.api.infrastructure.mapping;

import joris.gourdon.api.domain.models.TypeSurface;
import joris.gourdon.api.infrastructure.persistence.entities.TypeSurfaceEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TypeSurfaceMapper {
    TypeSurfaceMapper INSTANCE = Mappers.getMapper(TypeSurfaceMapper.class);

    TypeSurface entityTypeSurfaceToDomainTypeSurface(TypeSurfaceEntity entityTypeSurface);
    TypeSurfaceEntity domainTypeSurfaceToEntityTypeSurface(TypeSurface domainTypeSurface);
} 