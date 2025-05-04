package joris.gourdon.api.interfaces.controllers;

import joris.gourdon.api.application.services.ChampionnatService;
import joris.gourdon.api.domain.dto.requests.ChampionnatRequestDTO;
import joris.gourdon.api.domain.dto.responses.ChampionnatResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/championnats")
public class ChampionnatController {
    private final ChampionnatService championnatService;

    public ChampionnatController(ChampionnatService championnatService) {
        this.championnatService = championnatService;
    }

    @GetMapping
    public ResponseEntity<List<ChampionnatResponseDTO>> getAllChampionnats() {
        return ResponseEntity.ok(championnatService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChampionnatResponseDTO> getChampionnatById(@PathVariable int id) {
        return ResponseEntity.ok(championnatService.findById(id));
    }

    @PostMapping
    public ResponseEntity<ChampionnatResponseDTO> createChampionnat(@RequestBody ChampionnatRequestDTO championnatRequestDTO) {
        return ResponseEntity.ok(championnatService.createChampionnat(championnatRequestDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ChampionnatResponseDTO> updateChampionnat(@PathVariable int id, @RequestBody ChampionnatRequestDTO championnatRequestDTO) {
        return ResponseEntity.ok(championnatService.updateChampionnat(id, championnatRequestDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteChampionnat(@PathVariable int id) {
        championnatService.deleteChampionnat(id);
        return ResponseEntity.noContent().build();
    }
} 