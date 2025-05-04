package joris.gourdon.api.application.usecases.Categorie;

import joris.gourdon.api.domain.models.Categorie;
import joris.gourdon.api.domain.repositories.CategorieRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FindCategorieById {
    private final CategorieRepository categorieRepository;

    public FindCategorieById(CategorieRepository categorieRepository) {
        this.categorieRepository = categorieRepository;
    }

    public Optional<Categorie> findById(int id) {
        return categorieRepository.findById(id);
    }
} 