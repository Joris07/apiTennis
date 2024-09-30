package joris.gourdon.api.domain.models;

public class Equipe {

	private int id;
	private String nom;
	private Club club;
	private Categorie categorie;
	private Division division;

	public Equipe() {}

	public Equipe(int id, String nom, Club club, Categorie categorie, Division division) {
		this.id = id;
		this.nom = nom;
		this.club = club;
		this.categorie = categorie;
		this.division = division;
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

	public Club getClub() {
		return club;
	}

	public void setClub(Club club) {
		this.club = club;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public Division getDivision() {
		return division;
	}

	public void setDivision(Division division) {
		this.division = division;
	}

	@Override
	public String toString() {
		return "Equipe{" +
				"id=" + id +
				", nom='" + nom + '\'' +
				", club=" + club +
				", categorie=" + categorie +
				", division=" + division +
				'}';
	}
}