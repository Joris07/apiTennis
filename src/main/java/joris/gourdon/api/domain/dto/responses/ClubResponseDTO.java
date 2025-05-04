package joris.gourdon.api.domain.dto.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClubResponseDTO {
    private int id;
    private String nom;
    private String adresse;
    private String ville;
    private String codePostal;
    private String pays;
} 