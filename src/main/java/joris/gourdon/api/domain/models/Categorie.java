package joris.gourdon.api.domain.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Categorie {
	private int id;
	private String nom;

	@Override
	public String toString() {
		return "Categorie{" +
				"id=" + id +
				", nom='" + nom + '\'' +
				'}';
	}
}

