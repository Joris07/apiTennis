package joris.gourdon.api.domain.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Division {
	private int id;
	private String nom;

	// Getters et Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	// Autres méthodes (si nécessaires)

	@Override
	public String toString() {
		return "Division{" +
				"id=" + id +
				", nom='" + nom + '\'' +
				'}';
	}
}