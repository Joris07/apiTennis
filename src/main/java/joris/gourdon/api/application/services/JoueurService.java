package joris.gourdon.api.application.services;

import jakarta.persistence.EntityNotFoundException;
import joris.gourdon.api.application.mappingDTO.JoueurDTOMapper;
import joris.gourdon.api.application.usecases.Joueur.*;
import joris.gourdon.api.domain.dto.requests.JoueurRequestDTO;
import joris.gourdon.api.domain.dto.responses.JoueurResponseDTO;
import joris.gourdon.api.domain.models.Joueur;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class JoueurService {

	private final FindAllJoueur findAllJoueur;
	private final CreateJoueur createJoueur;
	private final UpdateJoueur updateJoueur;
	private final FindJoueurById findJoueurById;
	private final DeleteJoueur deleteJoueur;

	private final JoueurDTOMapper joueurDTOMapper;

	public JoueurService(FindAllJoueur findAllJoueur, CreateJoueur createJoueur, UpdateJoueur updateJoueur, FindJoueurById findJoueurById, DeleteJoueur deleteJoueur, JoueurDTOMapper joueurDTOMapper) {
		this.findAllJoueur = findAllJoueur;
		this.createJoueur = createJoueur;
		this.updateJoueur = updateJoueur;
		this.findJoueurById = findJoueurById;
		this.deleteJoueur = deleteJoueur;
		this.joueurDTOMapper = joueurDTOMapper;
	}

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
		Joueur joueur = joueurDTOMapper.toRequestDomain(joueurRequestDTO);
		Joueur savedJoueur = createJoueur.create(joueur);
		JoueurResponseDTO joueurResponseDTO = joueurDTOMapper.toResponseDTO(savedJoueur);
		return joueurResponseDTO;
	}

	public void updateJoueur(int id, JoueurRequestDTO joueurRequestDTO) {
		Joueur joueur = joueurDTOMapper.toRequestDomain(joueurRequestDTO);
		updateJoueur.update(id, joueur);
	}

	public void deleteJoueur(int id) {
		deleteJoueur.delete(id);
	}
}