package joris.gourdon.api.domain.dto.responses;

import jakarta.validation.constraints.*;

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
		ClubResponseDTO club,

		@NotNull(message = "L'email est obligatoire.")
		@Email(message = "L'email doit être valide.")
		@Size(max = 100, message = "L'email ne doit pas dépasser 100 caractères.")
		String email,

		@NotNull(message = "Le mot de passe est obligatoire.")
		@Size(min = 8, message = "Le mot de passe doit contenir au moins 8 caractères.")
		String password
) {}