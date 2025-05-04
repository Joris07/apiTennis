package joris.gourdon.api.domain.dto.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RencontreRequestDTO {
    private int pouleId;
    private int equipe1Id;
    private int equipe2Id;
    private String date;
    private String score;
    private Integer gagnantId;  // Nullable car le gagnant peut ne pas être déterminé
} 