package joris.gourdon.api.domain.repositories;

import joris.gourdon.api.domain.models.Categorie;

import java.util.List;
import java.util.Optional;

public interface CategorieRepository {
    List<Categorie> findAll();
    Optional<Categorie> findById(int id);
    Categorie save(Categorie categorie);
    void deleteById(int id);
} 