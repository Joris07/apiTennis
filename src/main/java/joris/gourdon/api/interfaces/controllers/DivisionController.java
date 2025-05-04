package joris.gourdon.api.interfaces.controllers;

import joris.gourdon.api.application.services.DivisionService;
import joris.gourdon.api.domain.dto.requests.DivisionRequestDTO;
import joris.gourdon.api.domain.dto.responses.DivisionResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/divisions")
public class DivisionController {
    private final DivisionService divisionService;

    public DivisionController(DivisionService divisionService) {
        this.divisionService = divisionService;
    }

    @GetMapping
    public ResponseEntity<List<DivisionResponseDTO>> getAllDivisions() {
        return ResponseEntity.ok(divisionService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DivisionResponseDTO> getDivisionById(@PathVariable int id) {
        return ResponseEntity.ok(divisionService.findById(id));
    }

    @PostMapping
    public ResponseEntity<DivisionResponseDTO> createDivision(@RequestBody DivisionRequestDTO divisionRequestDTO) {
        return ResponseEntity.ok(divisionService.createDivision(divisionRequestDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DivisionResponseDTO> updateDivision(@PathVariable int id, @RequestBody DivisionRequestDTO divisionRequestDTO) {
        return ResponseEntity.ok(divisionService.updateDivision(id, divisionRequestDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDivision(@PathVariable int id) {
        divisionService.deleteDivision(id);
        return ResponseEntity.noContent().build();
    }
} 