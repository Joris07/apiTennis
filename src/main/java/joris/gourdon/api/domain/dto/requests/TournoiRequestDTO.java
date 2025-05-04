package joris.gourdon.api.domain.dto.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TournoiRequestDTO {
    private String nom;
    private int clubId;
    private String dateDebut;
    private String dateFin;
    private int typeSurfaceId;
    private int typeTournoiId;
    private Double montantInscription;
    private Double montantPrix;
} 