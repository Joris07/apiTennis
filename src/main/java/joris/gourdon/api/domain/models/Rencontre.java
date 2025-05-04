package joris.gourdon.api.domain.models;

import java.time.LocalDate;

public class Rencontre {
    private int id;
    private Poule poule;
    private Equipe equipe1;
    private Equipe equipe2;
    private LocalDate date;
    private String score;
    private Equipe gagnant;

    public Rencontre() {}

    public Rencontre(int id, Poule poule, Equipe equipe1, Equipe equipe2, LocalDate date, String score, Equipe gagnant) {
        this.id = id;
        this.poule = poule;
        this.equipe1 = equipe1;
        this.equipe2 = equipe2;
        this.date = date;
        this.score = score;
        this.gagnant = gagnant;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Poule getPoule() {
        return poule;
    }

    public void setPoule(Poule poule) {
        this.poule = poule;
    }

    public Equipe getEquipe1() {
        return equipe1;
    }

    public void setEquipe1(Equipe equipe1) {
        this.equipe1 = equipe1;
    }

    public Equipe getEquipe2() {
        return equipe2;
    }

    public void setEquipe2(Equipe equipe2) {
        this.equipe2 = equipe2;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public Equipe getGagnant() {
        return gagnant;
    }

    public void setGagnant(Equipe gagnant) {
        this.gagnant = gagnant;
    }
} 