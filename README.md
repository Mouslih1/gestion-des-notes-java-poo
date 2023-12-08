# Simplon : Développement d'une application de gestion des notes 

Dans ce projet je créer 3 classe (Etudiant, Module, Note)

Classe Etudiant contient un champ : name (unique pour chaque étudiant)
Classe Module contient un champ : libelle (unique pour chaque module)
Classe Note contient des champ : libelleModule, Valeur, nameEtudiant 

Concernant la Classe qui fait les services d'application on a Classe gestionDesNoteController
contient 3 arrayList de chaque table pour stocker les informations de chaque champ et contient plusieurs méthodes 

Les méthodes réaliser :
    void addEtudiant():
        fait la ajoute de chaque étudiant si il exist je fait la méthode addNote au millieu de cette methode 
        si n'éxiste pas j'ajoute l'étudiant avec c'est notes 
        
    void addNote(String nameEtduiant,String libelleModule);
        fait la ajoute des notes utilisateur qui decide combien des notes il veut ajouter avec le module 
    String addModule(String libelle);
    void showEtudiant();
    void showNote();
    void showModule();
    double MoyenParModule(String name,String libelle);
    void MoyenGeneral(String name);
    void saveEtudiant();
    void saveNote() throws FileNotFoundException;
    void saveModule();
    ArrayList<Etudiant> getEtudiants();
    ArrayList<Module> getModules();
    ArrayList<Note> getNotes();



