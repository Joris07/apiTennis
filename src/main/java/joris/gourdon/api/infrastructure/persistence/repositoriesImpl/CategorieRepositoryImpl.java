package joris.gourdon.api.infrastructure.persistence.repositoriesImpl;

import joris.gourdon.api.domain.models.Categorie;
import joris.gourdon.api.domain.repositories.CategorieRepository;
import joris.gourdon.api.infrastructure.mapping.CategorieMapper;
import joris.gourdon.api.infrastructure.persistence.entities.CategorieEntity;
import joris.gourdon.api.infrastructure.persistence.repositoriesJpa.CategorieRepositoryJpa;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class CategorieRepositoryImpl implements CategorieRepository {
    private final CategorieRepositoryJpa categorieRepositoryJpa;
    private final CategorieMapper categorieMapper = CategorieMapper.INSTANCE;

    public CategorieRepositoryImpl(CategorieRepositoryJpa categorieRepositoryJpa) {
        this.categorieRepositoryJpa = categorieRepositoryJpa;
    }

    @Override
    public List<Categorie> findAll() {
        return categorieRepositoryJpa.findAll().stream()
                .map(categorieMapper::entityCategorieToDomainCategorie)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Categorie> findById(int id) {
        return categorieRepositoryJpa.findById(id)
                .map(categorieMapper::entityCategorieToDomainCategorie);
    }

    @Override
    public Categorie save(Categorie categorie) {
        CategorieEntity categorieEntity = categorieMapper.domainCategorieToEntityCategorie(categorie);
        CategorieEntity savedEntity = categorieRepositoryJpa.save(categorieEntity);
        return categorieMapper.entityCategorieToDomainCategorie(savedEntity);
    }

    @Override
    public void deleteById(int id) {
        categorieRepositoryJpa.deleteById(id);
    }
} 