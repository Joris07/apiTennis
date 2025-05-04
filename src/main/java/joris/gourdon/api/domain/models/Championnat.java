package joris.gourdon.api.domain.models;

public class Championnat {
    private int id;
    private String nom;
    private int annee;
    private Categorie categorie;
    private Division division;

    public Championnat() {}

    public Championnat(int id, String nom, int annee, Categorie categorie, Division division) {
        this.id = id;
        this.nom = nom;
        this.annee = annee;
        this.categorie = categorie;
        this.division = division;
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

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
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
} 