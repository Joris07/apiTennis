package joris.gourdon.api.modeles;

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
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "joueur1Id")
    private Joueur joueur1;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "joueur2Id")
    private Joueur joueur2;

    @Column(length = 20)
    private String score;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gagnantId")
    private Joueur gagnant;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rencontreId")
    private Rencontre rencontre;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tournoiId")
    private Tournoi tournoi;

    @PrePersist
    @PreUpdate
    private void validate() {
        if ((rencontre != null && tournoi != null) || (rencontre == null && tournoi == null)) {
            throw new IllegalStateException("Match doit être lié à une rencontre ou un tournoi, mais pas les deux.");
        }
    }
}


