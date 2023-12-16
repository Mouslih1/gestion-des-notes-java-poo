import java.io.FileNotFoundException;
import java.util.ArrayList;

public interface InterfaceGestionNote {
    void addEtudiant();
    void addNote(String nameEtduiant,String libelleModule);
    String addModule(String libelle);
    void showEtudiant();
    void showNote();
    void showModule();
    double MoyenParModule(String nameEtduiant,String libelle);
    double MoyenGeneral(String nameEtduiant);
    void saveEtudiant();
    void saveNote() throws FileNotFoundException;
    void saveModule();
    ArrayList<Etudiant> getEtudiants();
    ArrayList<Module> getModules();
    ArrayList<Note> getNotes();
}
