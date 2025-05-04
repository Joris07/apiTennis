package joris.gourdon.api.application.mappingDTO;

import joris.gourdon.api.application.services.ClubService;
import joris.gourdon.api.domain.dto.requests.EquipeRequestDTO;
import joris.gourdon.api.domain.dto.responses.EquipeResponseDTO;
import joris.gourdon.api.domain.models.Club;
import joris.gourdon.api.domain.models.Equipe;
import org.springframework.stereotype.Service;

@Service
public class EquipeDTOMapper {
	private final ClubService clubService;
	private final ClubDTOMapper clubDTOMapper = ClubDTOMapper.INSTANCE;

	public EquipeDTOMapper(ClubService clubService) {
		this.clubService = clubService;
	}

	public EquipeResponseDTO toResponseDTO(Equipe equipe) {
		return new EquipeResponseDTO(
				equipe.getId(),
				equipe.getNom(),
				clubDTOMapper.toResponseDTO(equipe.getClub())
		);
	}

	public Equipe toRequestDomain(EquipeRequestDTO equipeRequestDTO, int id) {
		Club club = null;
		if (equipeRequestDTO.getClubId() != null) {
			club = clubDTOMapper.toDomain(clubService.findById(equipeRequestDTO.getClubId()));
		}

		return new Equipe(
				id,
				equipeRequestDTO.getNom(),
				club
		);
	}
}