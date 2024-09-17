package joris.gourdon.api.application.services;

import jakarta.persistence.EntityNotFoundException;
import joris.gourdon.api.application.mapping.ClubDTOMapper;
import joris.gourdon.api.application.usecases.Club.*;
import joris.gourdon.api.domain.dto.ClubDTO;
import joris.gourdon.api.domain.models.Club;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClubService {

	private final FindAllClub findAllClub;
	private final CreateClub createClub;
	private final UpdateClub updateClub;
	private final FindClubById findClubById;
	private final DeleteClub deleteClub;

	private final ClubDTOMapper clubDTOMapper = ClubDTOMapper.INSTANCE;

	public ClubService(FindAllClub findAllClub, CreateClub createClub, UpdateClub updateClub, FindClubById findClubById, DeleteClub deleteClub) {
		this.findAllClub = findAllClub;
		this.createClub = createClub;
		this.updateClub = updateClub;
		this.findClubById = findClubById;
		this.deleteClub = deleteClub;
	}

	public List<ClubDTO> findAll() {
		return findAllClub.findAll().stream()
				.map(clubDTOMapper::toDTO)
				.collect(Collectors.toList());
	}

	public ClubDTO findById(int id) {
		Club club = findClubById.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Club non trouvé"));
		return clubDTOMapper.toDTO(club);
	}

	public ClubDTO createClub(ClubDTO clubDTO) {
		Club club = clubDTOMapper.toDomain(clubDTO);
		Club savedClub = createClub.create(club);
		return clubDTOMapper.toDTO(savedClub);
	}

	public void updateClub(int id, ClubDTO clubDTO) {
		Club club = clubDTOMapper.toDomain(clubDTO);
		updateClub.update(id, club);
	}

	public void deleteClub(int id) {
		deleteClub.delete(id);
	}
}