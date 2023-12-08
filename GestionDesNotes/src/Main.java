import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        gestionNoteController gestionNoteController = new gestionNoteController();
        Scanner scanner = new Scanner(System.in);
        gestionNoteController.getEtudiants();
        //gestionNoteController.getModules();
        gestionNoteController.getNotes();

        while (true)
         {
             System.out.println("0 : Quitter programme");
             System.out.println("1 : Add etudiant");
             System.out.println("2 : show etudiants");
             System.out.println("3 : show notes");
             System.out.println("4 : show modules");
             System.out.println("5 : Calculer moyen pour les modules qui tu veux calculer");
             System.out.println("6 : Calculer moyen general pour l'étudiant");
             System.out.println("Enter your choix:");
             int choix = scanner.nextInt();

             switch (choix)
             {
                 case 0:
                     System.out.println("Good Bye, Vous étez quiter le programme !");
                     gestionNoteController.saveEtudiant();
                     gestionNoteController.saveNote();
                     gestionNoteController.saveModule();
                     System.exit(0);
                     break;
                 case 1 :
                     gestionNoteController.addEtudiant();
                     break;
                 case 2 :
                     gestionNoteController.showEtudiant();
                     break;
                 case 3:
                     gestionNoteController.showNote();
                     break;
                 case 4:
                     gestionNoteController.showModule();
                     break;
                 case 5:
                     System.out.println("Enter le nom d'etudiant :");
                     String name = scanner.next();
                     System.out.println("Enter le libelle du modules tu veux calculer");
                     String libelle = scanner.next();
                     System.out.println(gestionNoteController.MoyenParModule(name,libelle));
                     break;
                 case 6:
                     System.out.println("Enter le nom d'etudiant :");
                     String nameEtudiant = scanner.next();
                     gestionNoteController.MoyenGeneral(nameEtudiant);
                     break;
                 default:
                     System.out.println("Votre choix est incorrect");

             }
         }

    }
}