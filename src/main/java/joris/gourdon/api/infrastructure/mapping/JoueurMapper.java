package joris.gourdon.api.infrastructure.mapping;

import joris.gourdon.api.domain.models.Joueur;
import joris.gourdon.api.infrastructure.persistence.entities.JoueurEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface JoueurMapper {
	JoueurMapper INSTANCE = Mappers.getMapper(JoueurMapper.class);

	JoueurEntity domainJoueurToEntityJoueur(Joueur domainJoueur);
	Joueur entityJoueurToDomainJoueur(JoueurEntity entityJoueur);
}
