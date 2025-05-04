package joris.gourdon.api.application.controllers;

import joris.gourdon.api.application.services.TypeTournoiService;
import joris.gourdon.api.domain.dto.responses.TypeTournoiResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/types-tournoi")
public class TypeTournoiController {
    private final TypeTournoiService typeTournoiService;

    public TypeTournoiController(TypeTournoiService typeTournoiService) {
        this.typeTournoiService = typeTournoiService;
    }

    @GetMapping
    public ResponseEntity<List<TypeTournoiResponseDTO>> findAll() {
        return ResponseEntity.ok(typeTournoiService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TypeTournoiResponseDTO> findById(@PathVariable int id) {
        return ResponseEntity.ok(typeTournoiService.findById(id));
    }
} 