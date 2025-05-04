package joris.gourdon.api.domain.models;

public class Match {
    private int id;
    private Joueur joueur1;
    private Joueur joueur2;
    private String score;
    private Joueur gagnant;
    private Rencontre rencontre;
    private Tournoi tournoi;

    public Match() {}

    public Match(int id, Joueur joueur1, Joueur joueur2, String score, Joueur gagnant, Rencontre rencontre, Tournoi tournoi) {
        this.id = id;
        this.joueur1 = joueur1;
        this.joueur2 = joueur2;
        this.score = score;
        this.gagnant = gagnant;
        this.rencontre = rencontre;
        this.tournoi = tournoi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Joueur getJoueur1() {
        return joueur1;
    }

    public void setJoueur1(Joueur joueur1) {
        this.joueur1 = joueur1;
    }

    public Joueur getJoueur2() {
        return joueur2;
    }

    public void setJoueur2(Joueur joueur2) {
        this.joueur2 = joueur2;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public Joueur getGagnant() {
        return gagnant;
    }

    public void setGagnant(Joueur gagnant) {
        this.gagnant = gagnant;
    }

    public Rencontre getRencontre() {
        return rencontre;
    }

    public void setRencontre(Rencontre rencontre) {
        this.rencontre = rencontre;
    }

    public Tournoi getTournoi() {
        return tournoi;
    }

    public void setTournoi(Tournoi tournoi) {
        this.tournoi = tournoi;
    }
} 