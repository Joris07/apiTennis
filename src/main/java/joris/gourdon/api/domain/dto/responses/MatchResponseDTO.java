package joris.gourdon.api.domain.dto.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MatchResponseDTO {
    private int id;
    private JoueurResponseDTO joueur1;
    private JoueurResponseDTO joueur2;
    private String score;
    private JoueurResponseDTO gagnant;
    private RencontreResponseDTO rencontre;
    private TournoiResponseDTO tournoi;
} 