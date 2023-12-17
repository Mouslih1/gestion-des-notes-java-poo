package Service;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import Module.Etudiant;
import Module.Module;
import Module.Note;

public class ServiceGestionNote implements InterfaceServiceGestionNote {
    ArrayList<Etudiant> etudiants;
    ArrayList<Module> modules;

    ArrayList<Note> notes;
    Scanner scanner;

    public static final String PURPLE = "\033[0;35m";
    public static final String PURPLE_BOLD_BRIGHT = "\033[1;95m";
    public static final String GREEN = "\033[0;32m";
    public static final String RED_BOLD_BRIGHT = "\033[1;91m";
    public static final String RED = "\033[0;31m";
    public static final String GREEN_BOLD_BRIGHT = "\033[1;92m";
    public static final String YELLOW_BOLD_BRIGHT = "\033[1;93m";


    public ServiceGestionNote() {
        etudiants = new ArrayList<>();
        modules = new ArrayList<>();
        notes = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    @Override
    public void addEtudiant()
    {
        System.out.print(PURPLE_BOLD_BRIGHT + "ENTER  ");
        System.out.println(PURPLE + "student name:");
        String name = scanner.next();

        boolean exists = etudiants.stream().anyMatch(e -> e.getName().equals(name));

        if(exists)
        {
            System.out.print("\n");
            System.out.println(YELLOW_BOLD_BRIGHT + "Student already exist !");
            System.out.println(PURPLE + "You want add note for this student y/n");
            String b = scanner.next();
            while (b.equals("y"))
            {
                System.out.print(PURPLE_BOLD_BRIGHT + "ENTER  ");
                System.out.println(PURPLE + "module libelle:");
                String libelleModule = scanner.next();
                addModule(libelleModule);
                addNote(name, libelleModule);
            }
        }else{
            Etudiant etudiant = new Etudiant(name);
            etudiants.add(etudiant);
            System.out.print("\n");
            System.out.print(GREEN + "SUCCESS -> ");
            System.out.println(GREEN_BOLD_BRIGHT + "Student has been added successfully");
            System.out.println(PURPLE + "You want add note for this student y/n");
            String b = scanner.next();
            while (b.equals("y"))
            {
                System.out.print("\n");
                System.out.print(PURPLE_BOLD_BRIGHT + "ENTER  ");
                System.out.println(PURPLE + "module libelle:");
                String libelleModule = scanner.next();
                addModule(libelleModule);
                addNote(name, libelleModule);
                System.out.println(PURPLE + "You want add note for another module for this student y/n");
                b = scanner.next();
            }
        }
    }

    @Override
    public void addNote(String nameEtudiant,String libelleModule)
    {
        System.out.print(PURPLE_BOLD_BRIGHT + "ENTER  ");
        System.out.println(PURPLE + "nombre note you want enter for this module:");
        int nombreNote  = scanner.nextInt();
        for (int i = 1; i <= nombreNote; i++)
        {
            System.out.print(PURPLE_BOLD_BRIGHT + "ENTER  ");
            System.out.println(PURPLE + "student notes:");
            double valeur = scanner.nextDouble();
            if(valeur >= 0 && valeur <= 20)
            {
                Note note = new Note(nameEtudiant,valeur,libelleModule);
                notes.add(note);
            }
        }
    }

    @Override
    public void addModule(String libelle)
    {
        boolean exists = modules.stream()
                .anyMatch(m -> m.getLibelle().equals(libelle));
        if (exists)
        {
            System.out.println(YELLOW_BOLD_BRIGHT + "Module already exist !");
        } else {
            Module module = new Module(libelle);
            modules.add(module);
            System.out.print("\n");
            System.out.print(GREEN + "SUCCESS -> ");
            System.out.println(GREEN_BOLD_BRIGHT + "Module has been added successfully");
        }
    }

    @Override
    public void showEtudiants()
    {
        if (!etudiants.isEmpty())
        {
            etudiants.forEach(e -> System.out.println(e.toString()));
        } else {
            System.out.print("\n");
            System.out.println(YELLOW_BOLD_BRIGHT + "La liste des étudiants est vide !");
        }
    }

    @Override
    public void showNotes() {
        if (!notes.isEmpty()) {
            notes.forEach(n -> System.out.println(n.toString()));
        } else {
            System.out.print("\n");
            System.out.println(YELLOW_BOLD_BRIGHT + "la liste des notes est vide !");
        }
    }

    @Override
    public void showModules() {
        if (!modules.isEmpty()) {
            modules.forEach(m -> System.out.println(m.toString()));
        } else {
            System.out.print("\n");
            System.out.println(YELLOW_BOLD_BRIGHT + "la liste des modules est vide !");
        }
    }

    @Override
    public double MoyenParModule(String name, String libelle)
    {
        return notes.stream().filter(n -> n.getLibelle().equals(libelle) && n.getnameEtudiant().equals(name))
                .mapToDouble(Note::getValeur)
                .average()
                .orElse(0.0);
    }

    @Override
    public double MoyenGeneral(String name)
    {
        return notes.stream().filter(n -> n.getnameEtudiant().equals(name)).mapToDouble(n -> MoyenParModule(name,n.getLibelle())).average().orElse(0.0);
    }

    @Override
    public void transferInTxtEtudiants()
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

            bufferedWriter.flush();
            bufferedWriter.close();
        }catch (IOException ignored){
        }
    }

    @Override
    public void transferInTxtNotes()
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

            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (IOException ignored) {
        }
    }

    @Override
    public void transferInTxtModules()
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

            bufferedWriter.flush();
            bufferedWriter.close();
        }catch (IOException ignored){

        }
    }

    @Override
    public ArrayList<Etudiant> saveInTxtEtudiants(){
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
    public ArrayList<Module> saveInTxtModules() {
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
    public ArrayList<Note> saveInTxtNotes()
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