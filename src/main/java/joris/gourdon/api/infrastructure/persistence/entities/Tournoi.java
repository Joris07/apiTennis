package joris.gourdon.api.infrastructure.persistence.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "tournois")
public class Tournoi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 100)
    private String nom;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "clubId")
    private ClubEntity club;

    @Column
    private LocalDate dateDebut;

    @Column
    private LocalDate dateFin;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "typeSurfaceId")
    private TypeSurface typeSurface;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "typeTournoiId")
    private TypeTournoi typeTournoi;

    @Column(precision = 12, scale = 2)
    private BigDecimal montantInscription;

    @Column(precision = 6, scale = 2)
    private BigDecimal montantPrix;
}