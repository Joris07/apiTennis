package joris.gourdon.api.application.mappingDTO;

import joris.gourdon.api.application.services.ClubService;
import joris.gourdon.api.domain.dto.requests.JoueurRequestDTO;
import joris.gourdon.api.domain.dto.responses.JoueurResponseDTO;
import joris.gourdon.api.domain.models.Club;
import joris.gourdon.api.domain.models.Joueur;
import org.springframework.stereotype.Service;

@Service
public class JoueurDTOMapper {
	private final ClubService clubService;
	private final ClubDTOMapper clubDTOMapper;

	public JoueurDTOMapper(ClubService clubService, ClubDTOMapper clubDTOMapper) {
		this.clubService = clubService;
		this.clubDTOMapper = clubDTOMapper;
	}

	public JoueurResponseDTO toResponseDTO(Joueur joueur) {
		return new JoueurResponseDTO(
				joueur.getId(),
				joueur.getNom(),
				joueur.getPrenom(),
				joueur.getDateNaissance(),
				joueur.getNationalite(),
				joueur.getGenre(),
				clubDTOMapper.toDTO(joueur.getClub()),
				joueur.getEmail(),
				joueur.getPassword()
		);
	}

	public Joueur toRequestDomain(JoueurRequestDTO joueurRequestDTO, int id) {
		Club club = null;
		if (joueurRequestDTO.getClubId() != null) {
			club = clubDTOMapper.toDomain(clubService.findById(joueurRequestDTO.getClubId()));
		}

		return new Joueur(
				id,
				joueurRequestDTO.getNom(),
				joueurRequestDTO.getPrenom(),
				joueurRequestDTO.getDateNaissance(),
				joueurRequestDTO.getNationalite(),
				joueurRequestDTO.getGenre(),
				club,
				joueurRequestDTO.getEmail(),
				joueurRequestDTO.getPassword()
		);
	}
}
