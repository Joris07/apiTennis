package joris.gourdon.api.dto;

import joris.gourdon.api.modeles.Club;

import java.time.LocalDate;

public record JoueurDTO(
        int id,
        String nom,
        String prenom,
        LocalDate dateNaissance,
        String nationalite,
        Character genre,
        Club club
) {}