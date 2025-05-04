package joris.gourdon.api.domain.dto.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChampionnatResponseDTO {
    private int id;
    private String nom;
    private int annee;
    private CategorieResponseDTO categorie;
    private DivisionResponseDTO division;
} 