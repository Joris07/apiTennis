package joris.gourdon.api.domain.models;

public class Division {

	private int id;
	private String nom;

	public Division() {}

	public Division(int id, String nom) {
		this.id = id;
		this.nom = nom;
	}

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