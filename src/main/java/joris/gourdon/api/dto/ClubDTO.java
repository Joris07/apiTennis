package joris.gourdon.api.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

public record ClubDTO(
		int id,

		@NotNull(message = "Le nom est obligatoire.")
		@Size(max = 100, message = "Le nom ne doit pas dépasser 100 caractères.")
		String nom,

		@Size(max = 255, message = "L'adresse ne doit pas dépasser 255 caractères.")
		String adresse,

		@Size(max = 100, message = "La ville ne doit pas dépasser 100 caractères.")
		String ville,

		@Size(max = 20, message = "Le code postal ne doit pas dépasser 20 caractères.")
		@Pattern(regexp = "^[0-9a-zA-Z]*$", message = "Le code postal contient des caractères non valides.")
		String codePostal,

		@Size(max = 50, message = "Le pays ne doit pas dépasser 50 caractères.")
		String pays
) {}