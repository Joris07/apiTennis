package joris.gourdon.api.application.mappingDTO;

import joris.gourdon.api.domain.dto.requests.TournoiRequestDTO;
import joris.gourdon.api.domain.dto.responses.TournoiResponseDTO;
import joris.gourdon.api.domain.models.Tournoi;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TournoiDTOMapper {
    TournoiDTOMapper INSTANCE = Mappers.getMapper(TournoiDTOMapper.class);

    TournoiResponseDTO toResponseDTO(Tournoi tournoi);
    Tournoi toRequestDomain(TournoiRequestDTO tournoiRequestDTO, int id);
} 