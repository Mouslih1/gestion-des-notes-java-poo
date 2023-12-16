import java.util.ArrayList;

public class Module {

    private String libelle;

    public Module(String libelle)
    {
        this.libelle = libelle;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @Override
    public String toString() {
        return "Module de cet semesttre " + libelle + '.';
    }
}
