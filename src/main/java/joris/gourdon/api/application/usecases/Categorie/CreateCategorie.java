package joris.gourdon.api.application.usecases.Categorie;

import joris.gourdon.api.domain.models.Categorie;
import joris.gourdon.api.domain.repositories.CategorieRepository;
import org.springframework.stereotype.Service;

@Service
public class CreateCategorie {
    private final CategorieRepository categorieRepository;

    public CreateCategorie(CategorieRepository categorieRepository) {
        this.categorieRepository = categorieRepository;
    }

    public Categorie create(Categorie categorie) {
        return categorieRepository.save(categorie);
    }
} 