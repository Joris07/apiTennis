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
    @JoinColumn(name = "pouleId", nullable = false)
    private PouleEntity pouleEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "equipe1Id", nullable = false)
    private EquipeEntity equipeEntity1;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "equipe2Id", nullable = false)
    private EquipeEntity equipeEntity2;

    @Column
    private LocalDate date;

    @Column(length = 20)
    private String score;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gagnantId")
    private EquipeEntity gagnant;
}