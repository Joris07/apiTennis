package joris.gourdon.api.application.usecases.Categorie;

import joris.gourdon.api.domain.models.Categorie;
import joris.gourdon.api.domain.repositories.CategorieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindAllCategorie {
    private final CategorieRepository categorieRepository;

    public FindAllCategorie(CategorieRepository categorieRepository) {
        this.categorieRepository = categorieRepository;
    }

    public List<Categorie> findAll() {
        return categorieRepository.findAll();
    }
} 