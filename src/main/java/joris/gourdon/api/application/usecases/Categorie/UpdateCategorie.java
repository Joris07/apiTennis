package joris.gourdon.api.application.usecases.Categorie;

import jakarta.persistence.EntityNotFoundException;
import joris.gourdon.api.domain.models.Categorie;
import joris.gourdon.api.domain.repositories.CategorieRepository;
import org.springframework.stereotype.Service;

@Service
public class UpdateCategorie {
    private final CategorieRepository categorieRepository;

    public UpdateCategorie(CategorieRepository categorieRepository) {
        this.categorieRepository = categorieRepository;
    }

    public Categorie update(int id, Categorie categorieDetails) {
        Categorie existingCategorie = categorieRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Catégorie non trouvée."));

        existingCategorie.setNom(categorieDetails.getNom());

        return categorieRepository.save(existingCategorie);
    }
} 