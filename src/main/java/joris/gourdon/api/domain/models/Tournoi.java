package joris.gourdon.api.domain.models;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Tournoi {
    private int id;
    private String nom;
    private Club club;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private TypeSurface typeSurface;
    private TypeTournoi typeTournoi;
    private BigDecimal montantInscription;
    private BigDecimal montantPrix;

    public Tournoi() {}

    public Tournoi(int id, String nom, Club club, LocalDate dateDebut, LocalDate dateFin, TypeSurface typeSurface, TypeTournoi typeTournoi, BigDecimal montantInscription, BigDecimal montantPrix) {
        this.id = id;
        this.nom = nom;
        this.club = club;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.typeSurface = typeSurface;
        this.typeTournoi = typeTournoi;
        this.montantInscription = montantInscription;
        this.montantPrix = montantPrix;
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

    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }

    public LocalDate getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    public TypeSurface getTypeSurface() {
        return typeSurface;
    }

    public void setTypeSurface(TypeSurface typeSurface) {
        this.typeSurface = typeSurface;
    }

    public TypeTournoi getTypeTournoi() {
        return typeTournoi;
    }

    public void setTypeTournoi(TypeTournoi typeTournoi) {
        this.typeTournoi = typeTournoi;
    }

    public BigDecimal getMontantInscription() {
        return montantInscription;
    }

    public void setMontantInscription(BigDecimal montantInscription) {
        this.montantInscription = montantInscription;
    }

    public BigDecimal getMontantPrix() {
        return montantPrix;
    }

    public void setMontantPrix(BigDecimal montantPrix) {
        this.montantPrix = montantPrix;
    }
}
