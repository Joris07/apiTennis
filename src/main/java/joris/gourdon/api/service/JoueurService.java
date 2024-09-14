package joris.gourdon.api.service;

import joris.gourdon.api.dto.JoueurDTO;
import joris.gourdon.api.repository.ClubRepository;
import joris.gourdon.api.repository.JoueurRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class JoueurService {

	private JoueurRepository joueurRepository;
	private ClubRepository clubRepository;

	public List<JoueurDTO> search() {
		return this.joueurRepository
				.findAll()
				.stream()
				.map(joueur -> new JoueurDTO(
						joueur.getId(),
						joueur.getNom(),
						joueur.getPrenom(),
						joueur.getDateNaissance(),
						joueur.getNationalite(),
						joueur.getGenre(),
						joueur.getClub()
					)
				)
				.collect(Collectors.toList());
	}
}
