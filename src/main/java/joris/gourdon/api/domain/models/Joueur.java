package joris.gourdon.api.domain.models;


import java.time.LocalDate;

public class Joueur {
	private int id;
	private String nom;
	private String prenom;
	private LocalDate dateNaissance;
	private String nationalite;
	private String genre;
	private Club club;

	public Joueur(int id, String nom, String prenom, LocalDate dateNaissance, String nationalite, String genre, Club club) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.nationalite = nationalite;
		this.genre = genre;
		this.club = club;
	}

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

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public LocalDate getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getNationalite() {
		return nationalite;
	}

	public void setNationalite(String nationalite) {
		this.nationalite = nationalite;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public Club getClub() {
		return club;
	}

	public void setClub(Club club) {
		this.club = club;
	}

	@Override
	public String toString() {
		return "Joueur{" +
				"id=" + id +
				", nom='" + nom + '\'' +
				", prenom='" + prenom + '\'' +
				", dateNaissance=" + dateNaissance +
				", nationalite='" + nationalite + '\'' +
				", genre=" + genre +
				", club=" + club +
				'}';
	}
}
