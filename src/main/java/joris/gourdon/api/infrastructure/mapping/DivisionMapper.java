package joris.gourdon.api.infrastructure.mapping;

import joris.gourdon.api.domain.models.Division;
import joris.gourdon.api.infrastructure.persistence.entities.DivisionEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DivisionMapper {
    DivisionMapper INSTANCE = Mappers.getMapper(DivisionMapper.class);

    DivisionEntity domainDivisionToEntityDivision(Division domainDivision);
    Division entityDivisionToDomainDivision(DivisionEntity entityDivision);
} 