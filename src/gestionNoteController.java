import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

public class gestionNoteController implements InterfaceGestionNote {
    ArrayList<Etudiant> etudiants;
    ArrayList<Module> modules;

    ArrayList<Note> notes;
    Scanner scanner;

    public gestionNoteController() {
        etudiants = new ArrayList<Etudiant>();
        modules = new ArrayList<Module>();
        notes = new ArrayList<Note>();
        scanner = new Scanner(System.in);
    }

    @Override
    public void addEtudiant() {
        System.out.println("Enter your NAME:");
        String name = scanner.next();
        boolean exists = false;
        for (Etudiant e : etudiants) {
            if (e.getName().equals(name)) {
                exists = true;
                break;
            }
        }

        if (exists) {
            System.out.println("Enter etudiant LIBELLE:");
            String libelleModule = scanner.next();
            System.out.println("Enter le nombre des modules tu veux saisie:");
            int nombreModule = scanner.nextInt();
            for (int i = 1; i <= nombreModule; i++) {
                addNote(name, libelleModule);
            }
        } else {
            System.out.println("Enter etudiant LIBELLE:");
            String libelleModule = scanner.next();
            Etudiant etudiant = new Etudiant(name);
            etudiants.add(etudiant);
            System.out.println("Enter le nombre des note tu veux saisie:");
            int nombreModule = scanner.nextInt();
            for (int i = 1; i <= nombreModule; i++) {
                addNote(name, libelleModule);
            }
        }
    }

    @Override
    public void addNote(String nameEtudiant, String libelleModule) {
        String libelle = addModule(libelleModule);
        System.out.println("Enter etudiant NOTE:");
        double valeur = scanner.nextDouble();
        if (valeur >= 0 && valeur <= 20) {
            Note note = new Note(nameEtudiant, valeur, libelle);
            notes.add(note);
        } else {
            System.out.println("La note doit étre entre 0 et 20 !");
            System.exit(0);
        }
    }

    @Override
    public String addModule(String libelle) {
        boolean exists = false;
        for (Module m : modules) {
            if (m.getLibelle().equals(libelle)) {
                exists = true;
                break;
            }
        }

        if (exists) {
            for (Module m : modules) {
                if (m.getLibelle().equals(libelle)) {
                    libelle = m.getLibelle();
                }
            }
        } else {
            Module module = new Module(libelle);
            modules.add(module);
        }
        return libelle;
    }

    @Override
    public void showEtudiant() {
        if (!etudiants.isEmpty()) {
            for (Etudiant e : etudiants) {
                System.out.println(e.toString());
            }
        } else {
            System.out.println("La liste des étudiants est vide !");
        }

    }

    @Override
    public void showNote() {
        if (!notes.isEmpty()) {
            for (Note note : notes) {
                System.out.println(note.toString());
            }
        } else {
            System.out.println("la liste des notes est vide !");
        }
    }

    @Override
    public void showModule() {
        if (!modules.isEmpty()) {
            for (Module module : modules) {
                System.out.println(module.toString());
            }
        } else {
            System.out.println("la liste des modules est vide !");
        }
    }

    @Override
    public double MoyenParModule(String name, String libelle) {
        double sum = 0;
        double result = 0;

        int counter = 0;
        for (Note n : notes) {
            if (n.getLibelle().equals(libelle) && n.getnameEtudiant().equals(name)) {
                counter++;
                sum += n.getValeur();
                result = sum;
            }
        }

        return result / counter;
    }

    @Override
    public void MoyenGeneral(String name) {
        int counter = 0;
        double sum = 0.0;
        for (Note n : notes) {
            if (n.getnameEtudiant().equals(name)) {
                counter++;
                sum += MoyenParModule(name, n.getLibelle());
            }
        }
        double result = sum / counter;
        System.out.println(result);
    }

    @Override
    public void saveEtudiant()
    {
        try{
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("etudiantFile.txt"), StandardCharsets.UTF_8));
            StringBuilder stringBuilder;
            for(Etudiant e : etudiants)
            {
                stringBuilder = new StringBuilder();
                stringBuilder.append(e.getName());
                bufferedWriter.write(stringBuilder.toString());
                bufferedWriter.newLine();
            }

            System.out.println("Etudiant data enregistrer avec success dans le fishier txt");
            bufferedWriter.flush();
            bufferedWriter.close();
        }catch (IOException ignored){

        }
    }

    @Override
    public void saveNote()
    {
        try{
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("noteFile.txt"), StandardCharsets.UTF_8));
            StringBuilder stringBuffer;
            for (Note n : notes)
            {
                stringBuffer = new StringBuilder();
                stringBuffer.append(n.getnameEtudiant()).append(",");
                stringBuffer.append(n.getValeur()).append(",");
                stringBuffer.append(n.getLibelle());
                bufferedWriter.write(stringBuffer.toString());
                bufferedWriter.newLine();
            }

            System.out.println("Note data enregister avec success dans le fishier");
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (IOException ignored) {
        }
    }

    @Override
    public void saveModule()
    {
        try{
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("moduleFile.txt"),StandardCharsets.UTF_8));
            StringBuilder stringBuffer;
            for (Module m : modules)
            {
                stringBuffer = new StringBuilder();
                stringBuffer.append(m.getLibelle());
                bufferedWriter.write(stringBuffer.toString());
                bufferedWriter.newLine();
            }

            System.out.println("Modules data enregistrer avec success dans le fichier");
            bufferedWriter.flush();
            bufferedWriter.close();
        }catch (IOException ignored){

        }
    }

    @Override
    public ArrayList<Etudiant> getEtudiants(){
        String line;
        try{
            FileReader fileReader = new FileReader("etudiantFile.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while((line = bufferedReader.readLine())!= null)
            {
                Etudiant etudiant = new Etudiant(line);
                etudiants.add(etudiant);
            }

            bufferedReader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return etudiants;
    }

    @Override
    public ArrayList<Module> getModules() {
        try{
            String line;
            FileReader fileReader = new FileReader("moduleFile.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while((line = bufferedReader.readLine()) != null)
            {
                Module module = new Module(line);
                modules.add(module);
            }

            bufferedReader.close();
        }catch (IOException e) {
            throw new RuntimeException(e);
        }

        return modules;
    }

    @Override
    public ArrayList<Note> getNotes()
    {
        String line;
        try{
            FileReader fileReader = new FileReader("noteFile.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while ((line = bufferedReader.readLine()) != null)
            {
                String[] l = line.split(",");
                Note note = new Note(l[0],Double.parseDouble(l[1]),l[2]);
                notes.add(note);
            }
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
        return notes;
    }
}