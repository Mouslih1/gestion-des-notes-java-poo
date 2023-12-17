package Module;

public class Note {
    private String nameEtudiant;
    private double valeur;
    private String libelle;

    public Note(String nameEtudiant, double valeur, String libelle)
    {
        this.nameEtudiant = nameEtudiant;
        this.valeur = valeur;
        this.libelle = libelle;
    }

    public String getnameEtudiant() {
        return nameEtudiant;
    }

    public void setIdEtudiant(String nameEtudiant) {
        this.nameEtudiant = nameEtudiant;
    }

    public double getValeur() {
        return valeur;
    }

    public void setValeur(double valeur) {
        this.valeur = valeur;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @Override
    public String toString() {
        return "Note{" +
                "nameEtudiant='" + nameEtudiant + '\'' +
                ", valeur=" + valeur +
                ", libelle='" + libelle + '\'' +
                '}';
    }
}
