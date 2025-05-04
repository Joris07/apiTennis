package joris.gourdon.api.application.usecases.Categorie;

import jakarta.persistence.EntityNotFoundException;
import joris.gourdon.api.domain.models.Categorie;
import joris.gourdon.api.domain.repositories.CategorieRepository;
import org.springframework.stereotype.Service;

@Service
public class DeleteCategorie {
    private final CategorieRepository categorieRepository;

    public DeleteCategorie(CategorieRepository categorieRepository) {
        this.categorieRepository = categorieRepository;
    }

    public void delete(int id) {
        Categorie categorie = categorieRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Catégorie non trouvée."));
        categorieRepository.deleteById(id);
    }
} 