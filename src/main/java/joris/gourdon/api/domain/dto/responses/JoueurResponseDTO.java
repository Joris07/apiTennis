package joris.gourdon.api.domain.dto.responses;

import jakarta.validation.constraints.*;
import joris.gourdon.api.domain.dto.ClubDTO;

import java.time.LocalDate;

public record JoueurResponseDTO(
		int id,

		@NotNull(message = "Le nom est obligatoire.")
		@Size(max = 50, message = "Le nom ne doit pas dépasser 50 caractères.")
		String nom,

		@NotNull(message = "Le prénom est obligatoire.")
		@Size(max = 50, message = "Le prénom ne doit pas dépasser 50 caractères.")
		String prenom,

		@PastOrPresent(message = "La date de naissance doit être dans le passé ou aujourd'hui.")
		LocalDate dateNaissance,

		@Size(max = 50, message = "La nationalité ne doit pas dépasser 50 caractères.")
		String nationalite,

		@NotNull(message = "Le genre est obligatoire.")
		@Pattern(regexp = "[HF]", message = "Le genre doit être 'H' ou 'F'")
		String genre,

		@NotNull(message = "Le club est obligatoire.")
		ClubDTO club
) {}