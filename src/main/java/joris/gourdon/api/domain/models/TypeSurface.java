package joris.gourdon.api.domain.models;

public class TypeSurface {
    private int id;
    private String nom;

    public TypeSurface() {}

    public TypeSurface(int id, String nom) {
        this.id = id;
        this.nom = nom;
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
} 