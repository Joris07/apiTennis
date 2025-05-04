package joris.gourdon.api.application.controllers;

import joris.gourdon.api.application.services.TournoiService;
import joris.gourdon.api.domain.dto.requests.TournoiRequestDTO;
import joris.gourdon.api.domain.dto.responses.TournoiResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tournois")
public class TournoiController {
    private final TournoiService tournoiService;

    public TournoiController(TournoiService tournoiService) {
        this.tournoiService = tournoiService;
    }

    @GetMapping
    public ResponseEntity<List<TournoiResponseDTO>> findAll() {
        return ResponseEntity.ok(tournoiService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TournoiResponseDTO> findById(@PathVariable int id) {
        return ResponseEntity.ok(tournoiService.findById(id));
    }

    @PostMapping
    public ResponseEntity<TournoiResponseDTO> create(@RequestBody TournoiRequestDTO tournoiRequestDTO) {
        return ResponseEntity.ok(tournoiService.createTournoi(tournoiRequestDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TournoiResponseDTO> update(@PathVariable int id, @RequestBody TournoiRequestDTO tournoiRequestDTO) {
        return ResponseEntity.ok(tournoiService.updateTournoi(id, tournoiRequestDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        tournoiService.deleteTournoi(id);
        return ResponseEntity.noContent().build();
    }
} 