package joris.gourdon.api.repository;

import joris.gourdon.api.modeles.Joueur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JoueurRepository extends JpaRepository<Joueur, Integer> { }