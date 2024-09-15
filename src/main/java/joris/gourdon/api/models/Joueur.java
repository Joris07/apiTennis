package joris.gourdon.api.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "joueurs")
public class Joueur {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(nullable = false, length = 50)
	private String nom;

	@Column(nullable = false, length = 50)
	private String prenom;

	private LocalDate dateNaissance;

	@Column(length = 50)
	private String nationalite;

	@Column(length = 1)
	private Character genre;

	@ManyToOne
	@JoinColumn(name = "clubId")
	private Club club;
}