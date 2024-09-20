package joris.gourdon.api.infrastructure.persistence.entities;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "joueurs")
public class JoueurEntity {

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
	private String genre;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "clubId")
	@Valid
	@NotNull
	private ClubEntity club;
}