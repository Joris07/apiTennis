package joris.gourdon.api.repositories;

import joris.gourdon.api.models.Joueur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JoueurRepository extends JpaRepository<Joueur, Integer> { }