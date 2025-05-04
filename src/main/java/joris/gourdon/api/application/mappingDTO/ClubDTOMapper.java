package joris.gourdon.api.application.mappingDTO;

import joris.gourdon.api.domain.dto.requests.ClubRequestDTO;
import joris.gourdon.api.domain.dto.responses.ClubResponseDTO;
import joris.gourdon.api.domain.models.Club;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ClubDTOMapper {
	ClubDTOMapper INSTANCE = Mappers.getMapper(ClubDTOMapper.class);

	@Mapping(source = "id", target = "id")
	@Mapping(source = "nom", target = "nom")
	@Mapping(source = "adresse", target = "adresse")
	@Mapping(source = "ville", target = "ville")
	@Mapping(source = "codePostal", target = "codePostal")
	@Mapping(source = "pays", target = "pays")
	ClubResponseDTO toResponseDTO(Club club);

	@Mapping(target = "id", source = "id")
	@Mapping(source = "clubRequestDTO.nom", target = "nom")
	@Mapping(source = "clubRequestDTO.adresse", target = "adresse")
	@Mapping(source = "clubRequestDTO.ville", target = "ville")
	@Mapping(source = "clubRequestDTO.codePostal", target = "codePostal")
	@Mapping(source = "clubRequestDTO.pays", target = "pays")
	Club toRequestDomain(ClubRequestDTO clubRequestDTO, int id);

	@Mapping(source = "id", target = "id")
	@Mapping(source = "nom", target = "nom")
	@Mapping(source = "adresse", target = "adresse")
	@Mapping(source = "ville", target = "ville")
	@Mapping(source = "codePostal", target = "codePostal")
	@Mapping(source = "pays", target = "pays")
	Club toDomain(ClubResponseDTO clubResponseDTO);
}
