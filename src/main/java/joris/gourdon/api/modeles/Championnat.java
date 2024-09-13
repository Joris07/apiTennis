package joris.gourdon.api.modeles;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "championnats")
public class Championnat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 100)
    private String nom;

    @Column(nullable = false)
    private int annee;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categorieId")
    private Categorie categorie;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "divisionId")
    private Division division;
}