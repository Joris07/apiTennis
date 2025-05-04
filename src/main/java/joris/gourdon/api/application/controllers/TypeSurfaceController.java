package joris.gourdon.api.application.controllers;

import joris.gourdon.api.application.services.TypeSurfaceService;
import joris.gourdon.api.domain.dto.responses.TypeSurfaceResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/types-surface")
public class TypeSurfaceController {
    private final TypeSurfaceService typeSurfaceService;

    public TypeSurfaceController(TypeSurfaceService typeSurfaceService) {
        this.typeSurfaceService = typeSurfaceService;
    }

    @GetMapping
    public ResponseEntity<List<TypeSurfaceResponseDTO>> findAll() {
        return ResponseEntity.ok(typeSurfaceService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TypeSurfaceResponseDTO> findById(@PathVariable int id) {
        return ResponseEntity.ok(typeSurfaceService.findById(id));
    }
} 