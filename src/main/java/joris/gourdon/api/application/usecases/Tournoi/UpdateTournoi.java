package joris.gourdon.api.application.usecases.Tournoi;

import joris.gourdon.api.domain.models.Tournoi;
import joris.gourdon.api.domain.repositories.TournoiRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UpdateTournoi {
    private final TournoiRepository tournoiRepository;

    public UpdateTournoi(TournoiRepository tournoiRepository) {
        this.tournoiRepository = tournoiRepository;
    }

    public Tournoi update(int id, Tournoi tournoiDetails) {
        return tournoiRepository.findById(id)
                .map(existingTournoi -> {
                    existingTournoi.setNom(tournoiDetails.getNom());
                    existingTournoi.setClub(tournoiDetails.getClub());
                    existingTournoi.setDateDebut(tournoiDetails.getDateDebut());
                    existingTournoi.setDateFin(tournoiDetails.getDateFin());
                    existingTournoi.setTypeSurface(tournoiDetails.getTypeSurface());
                    existingTournoi.setTypeTournoi(tournoiDetails.getTypeTournoi());
                    existingTournoi.setMontantInscription(tournoiDetails.getMontantInscription());
                    existingTournoi.setMontantPrix(tournoiDetails.getMontantPrix());
                    return tournoiRepository.save(existingTournoi);
                })
                .orElseThrow(() -> new EntityNotFoundException("Tournoi non trouvé avec l'id : " + id));
    }
} 