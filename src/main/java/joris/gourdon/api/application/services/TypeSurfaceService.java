package joris.gourdon.api.application.services;

import joris.gourdon.api.domain.dto.responses.TypeSurfaceResponseDTO;
import joris.gourdon.api.domain.models.TypeSurface;
import joris.gourdon.api.domain.repositories.TypeSurfaceRepository;
import joris.gourdon.api.infrastructure.mapping.TypeSurfaceMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeSurfaceService {
    private final TypeSurfaceRepository typeSurfaceRepository;
    private final TypeSurfaceMapper typeSurfaceMapper = TypeSurfaceMapper.INSTANCE;

    public TypeSurfaceService(TypeSurfaceRepository typeSurfaceRepository) {
        this.typeSurfaceRepository = typeSurfaceRepository;
    }

    public List<TypeSurfaceResponseDTO> findAll() {
        List<TypeSurface> typeSurfaces = typeSurfaceRepository.findAll();
        return typeSurfaces.stream()
                .map(this::toResponseDTO)
                .toList();
    }

    public TypeSurfaceResponseDTO findById(int id) {
        TypeSurface typeSurface = typeSurfaceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Type de surface non trouvé avec l'id : " + id));
        return toResponseDTO(typeSurface);
    }

    private TypeSurfaceResponseDTO toResponseDTO(TypeSurface typeSurface) {
        return new TypeSurfaceResponseDTO(
                typeSurface.getId(),
                typeSurface.getNom()
        );
    }
} 