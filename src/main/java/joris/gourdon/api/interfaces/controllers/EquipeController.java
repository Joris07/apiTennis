package joris.gourdon.api.interfaces.controllers;

import jakarta.validation.Valid;
import joris.gourdon.api.application.services.EquipeService;
import joris.gourdon.api.domain.dto.requests.EquipeRequestDTO;
import joris.gourdon.api.domain.dto.responses.EquipeResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/equipes")
public class EquipeController {
    private final EquipeService equipeService;

    public EquipeController(EquipeService equipeService) {
        this.equipeService = equipeService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<EquipeResponseDTO> findAll() {
        return equipeService.findAll();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EquipeResponseDTO> findById(@PathVariable int id) {
        EquipeResponseDTO equipeResponseDTO = equipeService.findById(id);
        return ResponseEntity.ok(equipeResponseDTO);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EquipeResponseDTO> create(@Valid @RequestBody EquipeRequestDTO equipeRequestDTO) {
        EquipeResponseDTO savedEquipeResponseDTO = equipeService.createEquipe(equipeRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEquipeResponseDTO);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EquipeResponseDTO> updatePut(@PathVariable int id, @Valid @RequestBody EquipeRequestDTO equipeRequestDTO) {
        EquipeResponseDTO equipeResponseDTO = equipeService.updateEquipe(id, equipeRequestDTO);
        return ResponseEntity.ok().body(equipeResponseDTO);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        equipeService.deleteEquipe(id);
        return ResponseEntity.noContent().build();
    }
}
