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
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class JoueurService {

	private final FindAllJoueur findAllJoueur;
	private final CreateJoueur createJoueur;
	private final UpdateJoueur updateJoueur;
	private final FindJoueurById findJoueurById;
	private final DeleteJoueur deleteJoueur;
	private final JoueurRepository joueurRepository;
	private final JoueurDTOMapper joueurDTOMapper;
	private final PasswordEncoder passwordEncoder;

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
		// Hachage du mot de passe avant la création
		String hashedPassword = passwordEncoder.encode(joueurRequestDTO.getPassword());
		joueurRequestDTO.setPassword(hashedPassword);
		
		Joueur joueur = joueurDTOMapper.toRequestDomain(joueurRequestDTO, 0);
		Joueur savedJoueur = createJoueur.create(joueur);
		return joueurDTOMapper.toResponseDTO(savedJoueur);
	}

	public JoueurResponseDTO updateJoueur(int id, JoueurRequestDTO joueurRequestDTO) {
		if (joueurRequestDTO.getPassword() != null && !joueurRequestDTO.getPassword().isEmpty()) {
			String hashedPassword = passwordEncoder.encode(joueurRequestDTO.getPassword());
			joueurRequestDTO.setPassword(hashedPassword);
		}
		
		Joueur joueur = joueurDTOMapper.toRequestDomain(joueurRequestDTO, id);
		updateJoueur.update(id, joueur);
		return joueurDTOMapper.toResponseDTO(joueur);
	}

	public void deleteJoueur(int id) {
		deleteJoueur.delete(id);
	}

	public Joueur findByEmail(String email) {
		return joueurRepository.findByEmail(email)
				.orElseThrow(() -> new EntityNotFoundException("Joueur non trouvé"));
	}
}