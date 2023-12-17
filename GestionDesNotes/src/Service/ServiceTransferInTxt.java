package Service;

import java.io.FileNotFoundException;

public class ServiceTransferInTxt {
    static ServiceGestionNote serviceGestionNote = new ServiceGestionNote();

    public static void transferInTxt() throws FileNotFoundException
    {
        serviceGestionNote.transferInTxtEtudiants();
        serviceGestionNote.transferInTxtModules();
        serviceGestionNote.transferInTxtNotes();
        System.out.println("Data saved in files");
    }
}
