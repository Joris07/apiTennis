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
@Table(name = "classementsJoueurs")
public class ClassementJoueurEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "joueurId", nullable = false)
    private JoueurEntity joueurEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "classementId", nullable = false)
    private ClassementEntity classementEntity;

    @Column(nullable = false)
    private LocalDate date;
}