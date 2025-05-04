package joris.gourdon.api.domain.dto.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChampionnatRequestDTO {
    private String nom;
    private int annee;
    private Integer categorieId;
    private Integer divisionId;
} 