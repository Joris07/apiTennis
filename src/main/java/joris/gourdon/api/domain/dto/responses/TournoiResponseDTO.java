package joris.gourdon.api.domain.dto.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TournoiResponseDTO {
    private int id;
    private String nom;
    private ClubResponseDTO club;
    private String dateDebut;
    private String dateFin;
    private TypeSurfaceResponseDTO typeSurface;
    private TypeTournoiResponseDTO typeTournoi;
    private Double montantInscription;
    private Double montantPrix;
} 