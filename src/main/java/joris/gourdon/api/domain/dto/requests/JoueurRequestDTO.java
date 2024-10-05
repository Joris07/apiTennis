package joris.gourdon.api.domain.dto.requests;

import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class JoueurRequestDTO {

	private int id;

	@NotNull(message = "Le nom est obligatoire.")
	@Size(max = 50, message = "Le nom ne doit pas dépasser 50 caractères.")
	private String nom;

	@NotNull(message = "Le prénom est obligatoire.")
	@Size(max = 50, message = "Le prénom ne doit pas dépasser 50 caractères.")
	private String prenom;

	@PastOrPresent(message = "La date de naissance doit être dans le passé ou aujourd'hui.")
	private LocalDate dateNaissance;

	@Size(max = 50, message = "La nationalité ne doit pas dépasser 50 caractères.")
	private String nationalite;

	@NotNull(message = "Le genre est obligatoire.")
	@Pattern(regexp = "[HF]", message = "Le genre doit être 'H' ou 'F'")
	private String genre;

	@NotNull(message = "Le club est obligatoire.")
	private Integer clubId;

	@NotNull(message = "L'email est obligatoire.")
	@Email(message = "L'email doit être valide.")
	@Size(max = 100, message = "L'email ne doit pas dépasser 100 caractères.")
	private String email;

	@NotNull(message = "Le mot de passe est obligatoire.")
	@Size(min = 8, message = "Le mot de passe doit contenir au moins 8 caractères.")
	private String password;

	@Override
	public String toString() {
		return "JoueurRequestDTO{" +
				"id=" + id +
				", nom='" + nom + '\'' +
				", prenom='" + prenom + '\'' +
				", dateNaissance=" + dateNaissance +
				", nationalite='" + nationalite + '\'' +
				", genre='" + genre + '\'' +
				", clubId=" + clubId +
				'}';
	}
}