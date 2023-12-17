package Menu;

import Service.ServiceGestionNote;
import Service.ServiceTransferInTxt;

import java.io.FileNotFoundException;
import java.sql.SQLOutput;
import java.util.Scanner;

public class MenuSwitch {

    public static final String PURPLE = "\033[0;35m";
    public static final String PURPLE_BOLD_BRIGHT = "\033[1;95m";
    public static final String GREEN = "\033[0;32m";
    public static final String RED_BOLD_BRIGHT = "\033[1;91m";
    public static final String RED = "\033[0;31m";
    public static final String GREEN_BOLD_BRIGHT = "\033[1;92m";
    public static final String YELLOW_BOLD_BRIGHT = "\033[1;93m";


    public static void menuSwitch() throws FileNotFoundException
    {
        ServiceGestionNote gestionNoteController = new ServiceGestionNote();
        Scanner scanner = new Scanner(System.in);
        System.out.print("\n");
        String art = PURPLE_BOLD_BRIGHT +
                "  .d88888b    dP                  dP                     dP                                                                       \n" +
                "  88.    \"'   88                  88                     88                                                                       \n" +
                "  `Y88888b. d8888P dP    dP .d888b88 .d8888b. 88d888b. d8888P    88d8b.d8b. .d8888b. 88d888b. .d8888b. .d8888b. .d8888b. 88d888b. \n" +
                "        `8b   88   88    88 88'  `88 88ooood8 88'  `88   88      88'`88'`88 88'  `88 88'  `88 88'  `88 88'  `88 88ooood8 88'  `88 \n" +
                "  d8'   .8P   88   88.  .88 88.  .88 88.  ... 88    88   88      88  88  88 88.  .88 88    88 88.  .88 88.  .88 88.  ... 88       \n" +
                "   Y88888P    dP   `88888P' `88888P8 `88888P' dP    dP   dP      dP  dP  dP `88888P8 dP    dP `88888P8 `8888P88 `88888P' dP       \n" +
                "  oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo~~~~.88~oooooooooooooooooo\n" +
                "                                                                                                        d8888P                    ";
        System.out.println(art);
        System.out.print("\n");
        System.out.println(RED_BOLD_BRIGHT + "         ******************************       ");
        System.out.println(RED_BOLD_BRIGHT + "         | WELCOME in STUDENT MANAGER |       ");
        System.out.println(RED_BOLD_BRIGHT + "         ******************************       ");
        while (true)
        {
            System.out.print("\n");
            System.out.print(PURPLE_BOLD_BRIGHT + "ENTER  1 ");
            System.out.println(PURPLE + "add student");
            System.out.print(PURPLE_BOLD_BRIGHT + "ENTER  2 ");
            System.out.println(PURPLE + "show students");
            System.out.print(PURPLE_BOLD_BRIGHT + "ENTER  3 ");
            System.out.println(PURPLE + "show notes");
            System.out.print(PURPLE_BOLD_BRIGHT + "ENTER  4 ");
            System.out.println(PURPLE + "show modules");
            System.out.print(PURPLE_BOLD_BRIGHT + "ENTER  5 ");
            System.out.println(PURPLE + "calculate average for a module");
            System.out.print(PURPLE_BOLD_BRIGHT + "ENTER  6 ");
            System.out.println(PURPLE + "calculate general average for student");
            System.out.print(PURPLE_BOLD_BRIGHT + "ENTER  7 ");
            System.out.println(PURPLE + "exit program");
            System.out.print("\n");
            System.out.print(PURPLE_BOLD_BRIGHT + "ENTER  ");
            System.out.println("your choice:");
            int choix = scanner.nextInt();

            switch (choix)
            {
                case 1 :
                    gestionNoteController.addEtudiant();
                    break;
                case 2 :
                    gestionNoteController.showEtudiants();
                    break;
                case 3:
                    gestionNoteController.showNotes();
                    break;
                case 4:
                    gestionNoteController.showModules();
                    break;
                case 5:
                    System.out.print(PURPLE_BOLD_BRIGHT + "ENTER  ");
                    System.out.println(PURPLE + "student name:");
                    String name = scanner.next();
                    System.out.print(PURPLE_BOLD_BRIGHT + "ENTER  ");
                    System.out.println(PURPLE + "the module label:");
                    String libelle = scanner.next();
                    System.out.println(gestionNoteController.MoyenParModule(name,libelle));
                    break;
                case 6:
                    System.out.print(PURPLE_BOLD_BRIGHT + "ENTER  ");
                    System.out.println(PURPLE + "student name:");
                    String nameEtudiant = scanner.next();
                    System.out.println(gestionNoteController.MoyenGeneral(nameEtudiant));
                    break;
                case 7:
                    System.out.print("\n");
                    System.out.print(RED_BOLD_BRIGHT + "END -> ");
                    System.out.println(RED + "Good Bye, Session end !");
                    ServiceTransferInTxt.transferInTxt();
                    System.exit(0);
                    break;
                default:
                    System.out.print("\n");
                    System.out.print(RED_BOLD_BRIGHT + "FAIL -> ");
                    System.out.println(RED + "Incorrect choice ! " + choix);
            }
        }
    }
}
