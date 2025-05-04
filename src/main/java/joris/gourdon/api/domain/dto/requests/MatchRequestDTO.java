package joris.gourdon.api.domain.dto.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MatchRequestDTO {
    private Integer joueur1Id;
    private Integer joueur2Id;
    private String score;
    private Integer gagnantId;
    private Integer rencontreId;
    private Integer tournoiId;
} 