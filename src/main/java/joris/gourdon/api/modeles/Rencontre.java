package joris.gourdon.api.modeles;


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
public class Rencontre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pouleId", nullable = false)
    private Poule poule;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "equipe1Id", nullable = false)
    private Equipe equipe1;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "equipe2Id", nullable = false)
    private Equipe equipe2;

    @Column
    private LocalDate date;

    @Column(length = 20)
    private String score;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gagnantId")
    private Equipe gagnant;
}