package joris.gourdon.api.infrastructure.persistence.entities;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "rencontres")
public class RencontreEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pouleId")
    private PouleEntity pouleEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "equipe1Id")
    private EquipeEntity equipe1Entity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "equipe2Id")
    private EquipeEntity equipe2Entity;

    @Column(nullable = false)
    private LocalDate date;

    @Column(length = 10)
    private String score;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gagnantId")
    private EquipeEntity gagnantEntity;
}