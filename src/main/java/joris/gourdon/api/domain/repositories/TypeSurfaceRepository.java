package joris.gourdon.api.domain.repositories;

import joris.gourdon.api.domain.models.TypeSurface;
import java.util.List;
import java.util.Optional;

public interface TypeSurfaceRepository {
    List<TypeSurface> findAll();
    Optional<TypeSurface> findById(int id);
} 