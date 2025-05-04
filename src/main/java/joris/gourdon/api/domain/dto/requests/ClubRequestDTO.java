package joris.gourdon.api.domain.dto.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClubRequestDTO {
    private String nom;
    private String adresse;
    private String ville;
    private String codePostal;
    private String pays;
} 