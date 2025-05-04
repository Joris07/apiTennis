package joris.gourdon.api.infrastructure.persistence.repositoriesImpl;

import joris.gourdon.api.domain.models.TypeSurface;
import joris.gourdon.api.domain.repositories.TypeSurfaceRepository;
import joris.gourdon.api.infrastructure.mapping.TypeSurfaceMapper;
import joris.gourdon.api.infrastructure.persistence.repositories.TypeSurfaceRepositoryJpa;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class TypeSurfaceRepositoryImpl implements TypeSurfaceRepository {
    private final TypeSurfaceRepositoryJpa typeSurfaceRepositoryJpa;
    private final TypeSurfaceMapper typeSurfaceMapper = TypeSurfaceMapper.INSTANCE;

    public TypeSurfaceRepositoryImpl(TypeSurfaceRepositoryJpa typeSurfaceRepositoryJpa) {
        this.typeSurfaceRepositoryJpa = typeSurfaceRepositoryJpa;
    }

    @Override
    public List<TypeSurface> findAll() {
        return typeSurfaceRepositoryJpa.findAll().stream()
                .map(typeSurfaceMapper::entityTypeSurfaceToDomainTypeSurface)
                .toList();
    }

    @Override
    public Optional<TypeSurface> findById(int id) {
        return typeSurfaceRepositoryJpa.findById(id)
                .map(typeSurfaceMapper::entityTypeSurfaceToDomainTypeSurface);
    }
} 