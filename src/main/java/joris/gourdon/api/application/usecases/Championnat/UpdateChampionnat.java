package joris.gourdon.api.application.usecases.Championnat;

import joris.gourdon.api.domain.models.Championnat;
import joris.gourdon.api.domain.repositories.ChampionnatRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UpdateChampionnat {
    private final ChampionnatRepository championnatRepository;

    public UpdateChampionnat(ChampionnatRepository championnatRepository) {
        this.championnatRepository = championnatRepository;
    }

    public Championnat update(int id, Championnat championnatDetails) {
        return championnatRepository.findById(id)
                .map(existingChampionnat -> {
                    existingChampionnat.setNom(championnatDetails.getNom());
                    existingChampionnat.setAnnee(championnatDetails.getAnnee());
                    existingChampionnat.setCategorie(championnatDetails.getCategorie());
                    existingChampionnat.setDivision(championnatDetails.getDivision());
                    return championnatRepository.save(existingChampionnat);
                })
                .orElseThrow(() -> new EntityNotFoundException("Championnat non trouvé avec l'id : " + id));
    }
} 