package joris.gourdon.api.services;

import jakarta.persistence.EntityNotFoundException;
import joris.gourdon.api.dto.ClubDTO;
import joris.gourdon.api.exceptions.ConflictException;
import joris.gourdon.api.exceptions.InvalidInputException;
import joris.gourdon.api.exceptions.ResourceNotFoundException;
import joris.gourdon.api.models.Club;
import joris.gourdon.api.repositories.ClubRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class ClubService {

	private ClubRepository clubRepository;

	public List<ClubDTO> findAll() {
		List<Club> clubs = this.clubRepository.findAll();
		if (clubs.isEmpty()) {
			throw new ResourceNotFoundException("Aucun club trouvé.");
		}
		return clubs
				.stream()
				.map(club -> new ClubDTO(
						club.getId(),
						club.getNom(),
						club.getAdresse(),
						club.getVille(),
						club.getCodePostal(),
						club.getPays()
				))
				.collect(Collectors.toList());
	}

	public ClubDTO findById(int id) {
		// Vérifier que l'ID est valide
		if (id <= 0) {
			throw new InvalidInputException("L'ID doit être un entier positif.");
		}

		return this.clubRepository.findById(id)
				.map(club -> new ClubDTO(
						club.getId(),
						club.getNom(),
						club.getAdresse(),
						club.getVille(),
						club.getCodePostal(),
						club.getPays()
				))
				.orElseThrow(() -> new ResourceNotFoundException("Club non trouvé avec l'id."));
	}

	public void createClub(ClubDTO clubDTO) {
		// Validation des données d'entrée
		if (clubDTO.nom() == null || clubDTO.nom().isEmpty()) {
			throw new InvalidInputException("Le nom du club est obligatoire.");
		}

		Club club = Club.builder()
				.nom(clubDTO.nom())
				.adresse(clubDTO.adresse())
				.ville(clubDTO.ville())
				.codePostal(clubDTO.codePostal())
				.pays(clubDTO.pays())
				.build();

		this.clubRepository.save(club);
	}

	public void updateClub(int id, ClubDTO clubDTO) {
		if (id <= 0) {
			throw new InvalidInputException("L'ID doit être un entier positif.");
		}

		Club existingClub = clubRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Club non trouvé."));

		if (clubDTO.nom() != null && clubDTO.nom().isEmpty()) {
			throw new InvalidInputException("Le nom du club ne peut pas être vide.");
		}

		existingClub.setNom(clubDTO.nom());
		existingClub.setAdresse(clubDTO.adresse());
		existingClub.setVille(clubDTO.ville());
		existingClub.setCodePostal(clubDTO.codePostal());
		existingClub.setPays(clubDTO.pays());

		clubRepository.save(existingClub);
	}
}