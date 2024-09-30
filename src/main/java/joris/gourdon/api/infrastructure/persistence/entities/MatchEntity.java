package joris.gourdon.api.infrastructure.persistence.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(
        name = "matchs",
        uniqueConstraints = @UniqueConstraint(columnNames = {"rencontreId", "tournoiId"})
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MatchEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "joueur1Id")
    private JoueurEntity joueurEntity1;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "joueur2Id")
    private JoueurEntity joueurEntity2;

    @Column(length = 20)
    private String score;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gagnantId")
    private JoueurEntity gagnant;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rencontreId")
    private RencontreEntity rencontreEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tournoiId")
    private TournoiEntity tournoiEntity;

    @PrePersist
    @PreUpdate
    private void validate() {
        if ((rencontreEntity != null && tournoiEntity != null) || (rencontreEntity == null && tournoiEntity == null)) {
            throw new IllegalStateException("Le match doit être lié à une rencontre ou un tournoi, mais pas les deux.");
        }
    }
}


