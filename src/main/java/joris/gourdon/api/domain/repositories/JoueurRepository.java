package joris.gourdon.api.domain.repositories;


import joris.gourdon.api.domain.models.Joueur;

import java.util.List;
import java.util.Optional;

public interface JoueurRepository {
	List<Joueur> findAll();
	Optional<Joueur> findById(int id);
	Joueur save(Joueur joueur);
	void deleteById(int id);
}