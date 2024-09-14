package joris.gourdon.api.dto;

public record ClubDTO(
        int id,
        String nom,
		String adresse,
		String ville,
		String codePostal,
		String pays
) {}
