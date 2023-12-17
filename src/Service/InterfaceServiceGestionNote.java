package Service;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import Module.Etudiant;
import Module.Module;
import Module.Note;

public interface InterfaceServiceGestionNote {
    void addEtudiant();
    void addNote(String nameEtudiant, String libelleModule);
    void addModule(String libelle);
    void showEtudiants();
    void showNotes();
    void showModules();
    double MoyenParModule(String nameEtduiant,String libelle);
    double MoyenGeneral(String nameEtduiant);
    void transferInTxtEtudiants();
    void transferInTxtNotes() throws FileNotFoundException;
    void transferInTxtModules();
    ArrayList<Etudiant> saveInTxtEtudiants();
    ArrayList<Module> saveInTxtModules();
    ArrayList<Note> saveInTxtNotes();
}
