package joris.gourdon.api.application.controllers;

import joris.gourdon.api.application.services.RencontreService;
import joris.gourdon.api.domain.dto.requests.RencontreRequestDTO;
import joris.gourdon.api.domain.dto.responses.RencontreResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rencontres")
public class RencontreController {
    private final RencontreService rencontreService;

    public RencontreController(RencontreService rencontreService) {
        this.rencontreService = rencontreService;
    }

    @GetMapping
    public ResponseEntity<List<RencontreResponseDTO>> findAll() {
        return ResponseEntity.ok(rencontreService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RencontreResponseDTO> findById(@PathVariable int id) {
        return ResponseEntity.ok(rencontreService.findById(id));
    }

    @PostMapping
    public ResponseEntity<RencontreResponseDTO> create(@RequestBody RencontreRequestDTO rencontreRequestDTO) {
        return ResponseEntity.ok(rencontreService.createRencontre(rencontreRequestDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RencontreResponseDTO> update(@PathVariable int id, @RequestBody RencontreRequestDTO rencontreRequestDTO) {
        return ResponseEntity.ok(rencontreService.updateRencontre(id, rencontreRequestDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        rencontreService.deleteRencontre(id);
        return ResponseEntity.noContent().build();
    }
} 