package joris.gourdon.api.domain.models;

public class Poule {
    private int id;
    private String nom;
    private Tournoi tournoi;

    public Poule() {}

    public Poule(int id, String nom, Tournoi tournoi) {
        this.id = id;
        this.nom = nom;
        this.tournoi = tournoi;
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

    public Tournoi getTournoi() {
        return tournoi;
    }

    public void setTournoi(Tournoi tournoi) {
        this.tournoi = tournoi;
    }
} 