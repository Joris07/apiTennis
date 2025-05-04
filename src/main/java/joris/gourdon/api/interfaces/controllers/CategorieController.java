package joris.gourdon.api.interfaces.controllers;

import jakarta.validation.Valid;
import joris.gourdon.api.application.services.CategorieService;
import joris.gourdon.api.domain.dto.requests.CategorieRequestDTO;
import joris.gourdon.api.domain.dto.responses.CategorieResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategorieController {
    private final CategorieService categorieService;

    public CategorieController(CategorieService categorieService) {
        this.categorieService = categorieService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CategorieResponseDTO> findAll() {
        return categorieService.findAll();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CategorieResponseDTO> findById(@PathVariable int id) {
        CategorieResponseDTO categorieResponseDTO = categorieService.findById(id);
        return ResponseEntity.ok(categorieResponseDTO);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CategorieResponseDTO> create(@Valid @RequestBody CategorieRequestDTO categorieRequestDTO) {
        CategorieResponseDTO savedCategorieResponseDTO = categorieService.createCategorie(categorieRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCategorieResponseDTO);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CategorieResponseDTO> updatePut(@PathVariable int id, @Valid @RequestBody CategorieRequestDTO categorieRequestDTO) {
        CategorieResponseDTO categorieResponseDTO = categorieService.updateCategorie(id, categorieRequestDTO);
        return ResponseEntity.ok().body(categorieResponseDTO);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        categorieService.deleteCategorie(id);
        return ResponseEntity.noContent().build();
    }
} 