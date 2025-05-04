package joris.gourdon.api.domain.dto.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PouleResponseDTO {
    private int id;
    private String nom;
    private TournoiResponseDTO tournoi;
} 