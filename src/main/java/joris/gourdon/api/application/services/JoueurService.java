package joris.gourdon.api.application.services;

import jakarta.persistence.EntityNotFoundException;
import joris.gourdon.api.application.mappingDTO.JoueurDTOMapper;
import joris.gourdon.api.application.usecases.Joueur.*;
import joris.gourdon.api.domain.dto.requests.JoueurRequestDTO;
import joris.gourdon.api.domain.dto.responses.JoueurResponseDTO;
import joris.gourdon.api.domain.models.Joueur;
import joris.gourdon.api.domain.repositories.JoueurRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class JoueurService implements UserDetailsService {

	private FindAllJoueur findAllJoueur;
	private CreateJoueur createJoueur;
	private UpdateJoueur updateJoueur;
	private FindJoueurById findJoueurById;
	private DeleteJoueur deleteJoueur;

	private JoueurRepository joueurRepository;
	private JoueurDTOMapper joueurDTOMapper;

	public List<JoueurResponseDTO> findAll() {
		return findAllJoueur.findAll().stream()
				.map(joueurDTOMapper::toResponseDTO)
				.collect(Collectors.toList());
	}

	public JoueurResponseDTO findById(int id) {
		Joueur joueur = findJoueurById.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Joueur non trouvé"));
		return joueurDTOMapper.toResponseDTO(joueur);
	}

	public JoueurResponseDTO createJoueur(JoueurRequestDTO joueurRequestDTO) {
		Joueur joueur = joueurDTOMapper.toRequestDomain(joueurRequestDTO, 0);
		Joueur savedJoueur = createJoueur.create(joueur);
		return joueurDTOMapper.toResponseDTO(savedJoueur);
	}

	public JoueurResponseDTO updateJoueur(int id, JoueurRequestDTO joueurRequestDTO) {
		Joueur joueur = joueurDTOMapper.toRequestDomain(joueurRequestDTO, id);
		updateJoueur.update(id, joueur);
		return joueurDTOMapper.toResponseDTO(joueur);
	}

	public void deleteJoueur(int id) {
		deleteJoueur.delete(id);
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		return this.joueurRepository
				.findByEmail(email)
				.orElseThrow(() -> new UsernameNotFoundException("Aucun utilisateur trouvé"));
	}
}