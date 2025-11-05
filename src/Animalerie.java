// ==========================================
// Fichier: Animalerie.java
// ==========================================
import java.util.ArrayList;

public class Animalerie {
    private ArrayList<Animal> animaux;
    private ArrayList<Employe> employes;

    public Animalerie() {
        this.animaux = new ArrayList<>();
        this.employes = new ArrayList<>();
    }

    public void demarrer() {
        ConsoleIO.afficherMessage("🌟 Bienvenue dans le système de gestion d'animalerie ! 🌟\n");

        boolean continuer = true;
        while (continuer) {
            ConsoleIO.afficherMenu();
            int choix = ConsoleIO.lireEntier("👉 Votre choix: ");

            switch (choix) {
                case 1:
                    ajouterAnimal();
                    break;
                case 2:
                    supprimerAnimal();
                    break;
                case 3:
                    listerAnimaux();
                    break;
                case 4:
                    ajouterEmploye();
                    break;
                case 5:
                    supprimerEmploye();
                    break;
                case 6:
                    listerEmployes();
                    break;
                case 7:
                    effectuerTache();
                    break;
                case 0:
                    continuer = false;
                    ConsoleIO.afficherMessage("\n👋 Au revoir et à bientôt !");
                    break;
                default:
                    ConsoleIO.afficherErreur("Choix invalide. Veuillez choisir entre 0 et 7.");
            }
        }
    }

    public void ajouterAnimal() {
        ConsoleIO.afficherMessage("\n--- 🐕 Ajouter un animal ---");
        ConsoleIO.afficherMessage("1. Chien");
        ConsoleIO.afficherMessage("2. Chat");
        ConsoleIO.afficherMessage("3. Lapin");

        int type = ConsoleIO.lireEntier("Type d'animal (1-3): ");
        String nom = ConsoleIO.lireChaine("Nom de l'animal: ");
        int age = ConsoleIO.lireEntier("Âge (en années): ");

        Animal animal = null;

        switch (type) {
            case 1:
                animal = new Chien(nom, age, EtatSante.SOIN_INTENSIF);
                break;
            case 2:
                animal = new Chat(nom, age, EtatSante.SOIN);
                break;
            case 3:
                animal = new Lapin(nom, age, EtatSante.SOIN_LEGER);
                break;
            default:
                ConsoleIO.afficherErreur("Type d'animal invalide.");
                return;
        }

        animaux.add(animal);
        ConsoleIO.afficherMessage("✅ " + nom + " a été ajouté avec succès !");
    }

    public void supprimerAnimal() {
        if (animaux.isEmpty()) {
            ConsoleIO.afficherErreur("Aucun animal à supprimer.");
            return;
        }

        listerAnimaux();
        int index = ConsoleIO.lireEntier("\nIndex de l'animal à supprimer: ");

        if (index >= 0 && index < animaux.size()) {
            animaux.remove(index);
            ConsoleIO.afficherMessage("✅ Animal retiré de l'animalerie.");
        } else {
            ConsoleIO.afficherErreur("Index invalide. Veuillez choisir entre 0 et " + (animaux.size() - 1));
        }
    }

    public void listerAnimaux() {
        if (animaux.isEmpty()) {
            ConsoleIO.afficherMessage("\n📭 Aucun animal dans l'animalerie.");
            return;
        }

        ConsoleIO.afficherMessage("\n=== 📋 Liste des animaux ===");
        for (int i = 0; i < animaux.size(); i++) {
            Animal a = animaux.get(i);
            System.out.println("[" + i + "] " + a.getClass().getSimpleName() +
                    " - " + a.getAge() + " ans");
        }
    }

    public void ajouterEmploye() {
        ConsoleIO.afficherMessage("\n--- 👨‍⚕️ Ajouter un employé ---");
        ConsoleIO.afficherMessage("1. Soigneur");
        ConsoleIO.afficherMessage("2. Vétérinaire");

        int type = ConsoleIO.lireEntier("Type d'employé (1-2): ");
        String nom = ConsoleIO.lireChaine("Nom: ");
        String prenom = ConsoleIO.lireChaine("Prénom: ");
        int salaire = ConsoleIO.lireEntier("Salaire (€): ");

        Employe employe = null;

        switch (type) {
            case 1:
                employe = new Soigneur(nom, prenom, salaire, "Soigneur");
                break;
            case 2:
                employe = new Veterinaire(nom, prenom, salaire, "Vétérinaire");
                break;
            default:
                ConsoleIO.afficherErreur("Type d'employé invalide.");
                return;
        }

        employes.add(employe);
        ConsoleIO.afficherMessage("✅ " + prenom + " " + nom + " a été embauché(e) !");
    }

    public void supprimerEmploye() {
        if (employes.isEmpty()) {
            ConsoleIO.afficherErreur("Aucun employé à supprimer.");
            return;
        }

        listerEmployes();
        int index = ConsoleIO.lireEntier("\nIndex de l'employé à supprimer: ");

        if (index >= 0 && index < employes.size()) {
            employes.remove(index);
            ConsoleIO.afficherMessage("✅ Employé retiré.");
        } else {
            ConsoleIO.afficherErreur("Index invalide. Veuillez choisir entre 0 et " + (employes.size() - 1));
        }
    }

    public void listerEmployes() {
        if (employes.isEmpty()) {
            ConsoleIO.afficherMessage("\n📭 Aucun employé.");
            return;
        }

        ConsoleIO.afficherMessage("\n=== 📋 Liste des employés ===");
        for (int i = 0; i < employes.size(); i++) {
            Employe e = employes.get(i);
            System.out.println("[" + i + "] " + e.getClass().getSimpleName());
        }
    }

    public void effectuerTache() {
        if (employes.isEmpty()) {
            ConsoleIO.afficherErreur("Aucun employé disponible.");
            return;
        }
        if (animaux.isEmpty()) {
            ConsoleIO.afficherErreur("Aucun animal disponible.");
            return;
        }

        ConsoleIO.afficherMessage("\n--- 💼 Effectuer une tâche ---");
        listerEmployes();
        int indexEmploye = ConsoleIO.lireEntier("\nChoisir un employé: ");

        if (indexEmploye < 0 || indexEmploye >= employes.size()) {
            ConsoleIO.afficherErreur("Index employé invalide.");
            return;
        }

        listerAnimaux();
        int indexAnimal = ConsoleIO.lireEntier("\nChoisir un animal: ");

        if (indexAnimal < 0 || indexAnimal >= animaux.size()) {
            ConsoleIO.afficherErreur("Index animal invalide.");
            return;
        }

        // Récupérer les objets depuis les listes
        Employe employe = employes.get(indexEmploye);
        Animal animal = animaux.get(indexAnimal);

        // Appeler la méthode effectuerTache sur l'objet employe
        employe.effectuerTache(animal);

        ConsoleIO.afficherMessage("✅ Tâche effectuée avec succès !");
    }
}
