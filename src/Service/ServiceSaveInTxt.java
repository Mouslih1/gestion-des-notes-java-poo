package Service;

import Service.ServiceGestionNote;

public class ServiceSaveInTxt {

    static ServiceGestionNote serviceGestionNote = new ServiceGestionNote();
    public static void saveInTxt()
    {
        serviceGestionNote.saveInTxtEtudiants();
        serviceGestionNote.saveInTxtModules();
        serviceGestionNote.saveInTxtNotes();
    }
}
