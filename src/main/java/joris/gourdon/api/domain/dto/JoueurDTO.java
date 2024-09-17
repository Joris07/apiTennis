package joris.gourdon.api.domain.dto;

import jakarta.validation.constraints.*;
import joris.gourdon.api.infrastructure.persistence.entities.ClubEntity;

import java.time.LocalDate;

public record JoueurDTO(
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
		@Pattern(regexp = "^[HF]$", message = "Le genre doit être soit 'H' pour Homme, soit 'F' pour Femme.")
		Character genre,

		@NotNull(message = "Le club est obligatoire.")
		ClubEntity club
) {}