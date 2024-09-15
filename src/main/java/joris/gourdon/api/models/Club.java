package joris.gourdon.api.models;


import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "clubs")
public class Club {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 100)
    private String nom;

    private String adresse;

    @Column(length = 100)
    private String ville;

    @Column(length = 20)
    private String codePostal;

    @Column(length = 50)
    private String pays;
}
