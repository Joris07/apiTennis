package joris.gourdon.api.domain.dto.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RencontreResponseDTO {
    private int id;
    private PouleResponseDTO poule;
    private EquipeResponseDTO equipe1;
    private EquipeResponseDTO equipe2;
    private String date;
    private String score;
    private EquipeResponseDTO gagnant;
} 