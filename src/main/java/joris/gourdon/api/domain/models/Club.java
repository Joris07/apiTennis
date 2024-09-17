package joris.gourdon.api.domain.models;

public class Club {
	private int id;
	private String nom;
	private String adresse;
	private String ville;
	private String codePostal;
	private String pays;

	public Club(int id, String nom, String adresse, String ville, String codePostal, String pays) {
		this.id = id;
		this.nom = nom;
		this.adresse = adresse;
		this.ville = ville;
		this.codePostal = codePostal;
		this.pays = pays;
	}

	public int getId() {
		return id;
	}

	public String getNom() {
		return nom;
	}

	public String getAdresse() {
		return adresse;
	}

	public String getVille() {
		return ville;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public String getPays() {
		return pays;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}
}