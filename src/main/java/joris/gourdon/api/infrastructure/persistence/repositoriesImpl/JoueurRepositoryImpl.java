package joris.gourdon.api.infrastructure.persistence.repositoriesImpl;

import joris.gourdon.api.domain.models.Joueur;
import joris.gourdon.api.domain.repositories.JoueurRepository;
import joris.gourdon.api.infrastructure.mapping.JoueurMapper;
import joris.gourdon.api.infrastructure.persistence.entities.JoueurEntity;
import joris.gourdon.api.infrastructure.persistence.repositoriesJpa.JoueurRepositoryJpa;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class JoueurRepositoryImpl implements JoueurRepository {
	private final JoueurRepositoryJpa joueurRepositoryJpa;
	private final JoueurMapper joueurMapper = JoueurMapper.INSTANCE;

	public JoueurRepositoryImpl(JoueurRepositoryJpa joueurRepositoryJpa) {
		this.joueurRepositoryJpa = joueurRepositoryJpa;
	}

	@Override
	public List<Joueur> findAll() {
		return joueurRepositoryJpa.findAll().stream()
				.map(joueurMapper::entityJoueurToDomainJoueur)
				.collect(Collectors.toList());
	}

	@Override
	public Optional<Joueur> findById(int id) {
		return joueurRepositoryJpa.findById(id)
				.map(joueurMapper::entityJoueurToDomainJoueur);
	}

	@Override
	public Joueur save(Joueur joueur) {
		JoueurEntity joueurEntity = joueurMapper.domainJoueurToEntityJoueur(joueur);
		JoueurEntity savedEntity = joueurRepositoryJpa.save(joueurEntity);
		return joueurMapper.entityJoueurToDomainJoueur(savedEntity);
	}

	@Override
	public void deleteById(int id) {
		joueurRepositoryJpa.deleteById(id);
	}
}