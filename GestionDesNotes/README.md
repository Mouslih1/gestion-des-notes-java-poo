# Simplon : Développement d'une application de gestion des notes 

Dans ce projet je créer 3 classe (Etudiant, Module, Note)

Classe Etudiant contient un champ : name (unique pour chaque étudiant)
Classe Module contient un champ : libelle (unique pour chaque module)
Classe Note contient des champ : libelleModule, Valeur, nameEtudiant 

Concernant la Classe qui fait les services d'application on a Classe gestionDesNoteController
contient 3 arrayList de chaque table pour stocker les informations de chaque champ et contient plusieurs méthodes 

/**
 * La classe `gestionNoteController` implémente l'interface `InterfaceGestionNote`
 * et sert de contrôleur pour gérer les données des étudiants, les informations sur les modules
 * et les notes. Elle propose des méthodes pour ajouter des étudiants, enregistrer des notes,
 * calculer des moyennes et sauvegarder/récupérer des données depuis des fichiers.
 *
 * La classe contient des ArrayLists pour stocker des instances des classes `Etudiant` (Student),
 * `Module` et `Note`. Elle utilise un Scanner pour la saisie utilisateur.
 *
 * Principales fonctionnalités :
 * - Ajout d'étudiants et de modules
 * - Enregistrement des notes pour les étudiants dans différents modules
 * - Calcul des moyennes spécifiques à un module et générales pour les étudiants
 * - Sauvegarde et récupération de données depuis des fichiers texte (etudiantFile.txt, moduleFile.txt, noteFile.txt)
 *
 * Remarque : La classe suppose l'existence des classes `Etudiant`, `Module` et `Note`,
 * ainsi que de l'interface `InterfaceGestionNote`.




