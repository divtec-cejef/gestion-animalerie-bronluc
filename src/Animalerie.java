import java.util.ArrayList;
import java.util.Random;

public class Animalerie {
    private ArrayList<Animal> animaux;
    private ArrayList<Employe> employes;
    private ArrayList<Animal> participants;
    private Concours concours;

    public Animalerie() {
        this.animaux = new ArrayList<>();
        this.employes = new ArrayList<>();
        this.participants = new ArrayList<>();
    }

    public void demarrer() {
        ConsoleIO.afficherBienvenue();

        boolean continuer = true;
        while (continuer) {
            ConsoleIO.afficherMenu();
            int choix = ConsoleIO.lireEntier(" Votre choix: ");

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
                case 8:
                    creationConcours();
                    break;
                case 9:
                    ajouterAnimalConcours();
                    break;
                case 10:
                    afficherDetailConcours();
                    break;
                case 11:
                    lancerConcours();
                    break;
                case 0:
                    continuer = false;
                    ConsoleIO.afficherAuRevoir();
                    break;
                default:
                    ConsoleIO.afficherChoixInvalide();
            }
        }
    }

    public void ajouterAnimal() {
        ConsoleIO.afficherTitreAjoutAnimal();
        ConsoleIO.afficherMenuTypesAnimaux();

        int type = ConsoleIO.lireEntier("Type d'animal (1-3): ");
        String nom = ConsoleIO.lireChaine("Nom de l'animal: ");
        int age = ConsoleIO.lireEntier("Âge (en années): \n");

        ConsoleIO.afficherMenuEtatSante();
        int choixSante = ConsoleIO.lireEntier("État de santé (1-3): ");

        // Convertir le choix en EtatSante avec un switch
        EtatSante sante;
        switch (choixSante) {
            case 1:
                sante = EtatSante.SAIN;
                break;
            case 2:
                sante = EtatSante.SOIN_LEGER;
                break;
            case 3:
                sante = EtatSante.SOIN_INTENSIF;
                break;
            default:
                ConsoleIO.afficherErreur("Choix invalide, SAIN par défaut.");
                sante = EtatSante.SAIN;
        }
        System.out.println(sante);

        Animal animal = null;

        switch (type) {
            case 1:
                animal = new Chien(nom, age, sante);
                break;
            case 2:
                animal = new Chat(nom, age, sante);
                break;
            case 3:
                animal = new Lapin(nom, age, sante);
                break;
            default:
                ConsoleIO.afficherTypeAnimalInvalide();
                return;
        }

        animaux.add(animal);
        ConsoleIO.afficherAnimalAjoute(nom);
    }

    public void supprimerAnimal() {
        if (animaux.isEmpty()) {
            ConsoleIO.afficherAucunAnimalASupprimer();
            return;
        }

        listerAnimaux();
        int index = ConsoleIO.lireEntier("\nIndex de l'animal à supprimer: ");

        if (index >= 0 && index < animaux.size()) {
            animaux.remove(index);
            ConsoleIO.afficherAnimalSupprime();
        } else {
            ConsoleIO.afficherIndexAnimalInvalide(animaux.size() - 1);
        }
    }

    public void listerAnimaux() {
        if (animaux.isEmpty()) {
            ConsoleIO.afficherAucunAnimal();
            return;
        }

        ConsoleIO.afficherTitreListeAnimaux();
        for (int i = 0; i < animaux.size(); i++) {
            Animal a = animaux.get(i);
            ConsoleIO.afficherAnimal(i, a.getNom(), a.getAge());
        }
    }

    public void ajouterEmploye() {
        ConsoleIO.afficherTitreAjoutEmploye();
        ConsoleIO.afficherMenuTypesEmployes();

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
                ConsoleIO.afficherTypeEmployeInvalide();
                return;
        }

        employes.add(employe);
        ConsoleIO.afficherEmployeAjoute(prenom, nom);
    }

    public void supprimerEmploye() {
        if (employes.isEmpty()) {
            ConsoleIO.afficherAucunEmployeASupprimer();
            return;
        }

        listerEmployes();
        int index = ConsoleIO.lireEntier("\nIndex de l'employé à supprimer: ");

        if (index >= 0 && index < employes.size()) {
            employes.remove(index);
            ConsoleIO.afficherEmployeSupprime();
        } else {
            ConsoleIO.afficherIndexEmployeInvalide(employes.size() - 1);
        }
    }

    public void listerEmployes() {
        if (employes.isEmpty()) {
            ConsoleIO.afficherAucunEmploye();
            return;
        }

        ConsoleIO.afficherTitreListeEmployes();
        for (int i = 0; i < employes.size(); i++) {
            Employe e = employes.get(i);
            String s;
            if (i == 0){s = "Soigneur";} else
            {s = "Vétérinaire";}
            ConsoleIO.afficherEmploye(i, s, e.getNom());
        }
    }

    public void effectuerTache() {
        if (employes.isEmpty()) {
            ConsoleIO.afficherAucunEmployeDisponible();
            return;
        }
        if (animaux.isEmpty()) {
            ConsoleIO.afficherAucunAnimalDisponible();
            return;
        }

        ConsoleIO.afficherTitreEffectuerTache();
        listerEmployes();
        int indexEmploye = ConsoleIO.lireEntier("\nChoisir un employé: ");

        if (indexEmploye < 0 || indexEmploye >= employes.size()) {
            ConsoleIO.afficherIndexEmployeInvalide();
            return;
        }

        listerAnimaux();
        int indexAnimal = ConsoleIO.lireEntier("\nChoisir un animal: ");

        if (indexAnimal < 0 || indexAnimal >= animaux.size()) {
            ConsoleIO.afficherIndexAnimalInvalide();
            return;
        }

        Employe employe = employes.get(indexEmploye);
        Animal animal = animaux.get(indexAnimal);

        employe.effectuerTache(animal);

        ConsoleIO.afficherTacheEffectuee();
    }

        public void creationConcours() {
            if (concours != null) {
                ConsoleIO.afficherErreur("Un concours existe déjà !");
                return;
            }

            String nom = ConsoleIO.lireChaine("Nom du concours : ");
            String lieu = ConsoleIO.lireChaine("Lieu : ");
            int capacite = ConsoleIO.lireEntier("Capacité maximale : ");

            concours = new Concours(nom, lieu, capacite);
    }

    public void ajouterAnimalConcours() {
        if (concours == null) {
            ConsoleIO.afficherErreur("Aucun concours actif. Créez-en un d'abord !");
            return;
        }

        if (animaux.isEmpty()) {
            ConsoleIO.afficherErreur("Aucun animal disponible.");
            return;
        }

        int cap = concours.getCapacité();

        // Afficher la liste des animaux existants
        listerAnimaux();
        int indexAnimal = ConsoleIO.lireEntier("Choisir un animal à inscrire : ");

        if (participants.size() >= cap) {
            ConsoleIO.afficherErreur("Ce concours a assez de participants.");
            return;
        }

        // Vérifier que l'index est valide
        if (indexAnimal < 0 || indexAnimal >= animaux.size()) {
            ConsoleIO.afficherIndexAnimalInvalide(animaux.size() - 1);
            return;
        }

        // Récupérer l'animal choisi
        Animal a = animaux.get(indexAnimal);

        // Vérifier si l'animal est SAIN
        if (a.getSante() != EtatSante.SAIN) {
            ConsoleIO.afficherErreur("Seuls les animaux en bonne santé peuvent participer !");
            return;
        }

        // Ajouter aux participants
        participants.add(a);
        ConsoleIO.afficherMessage(a.getNom() + " inscrit au concours !");
    }

    public void afficherDetailConcours () {

            ConsoleIO.afficherTitreParticipantsConcours();
            for (int i = 0; i < participants.size(); i++) {
                Animal a = participants.get(i);
                ConsoleIO.afficherAnimal(i, a.getNom(), a.getAge());
            }
            System.out.println("\n");
            ConsoleIO.afficherDetail(concours);
    }

    public void lancerConcours() {
        Concours concours = null;
        concours = new Concours("fjso", "fdsf", 83);

        if (participants.isEmpty()) {
            ConsoleIO.afficherAucunParticipant();
        } else {
            Random random = new Random();

            for (int i = participants.size() - 1; i > 0; i--) {
                // Choisir un index aléatoire entre 0 et i
                int j = random.nextInt(i + 1);

                // Échanger les éléments aux positions i et j
                Animal temp = participants.get(i);
                participants.set(i, participants.get(j));
                participants.set(j, temp);
            }

            // Afficher le classement
            ConsoleIO.afficherMessage("\nClassement du concours :");
            for (int i = 0; i < participants.size(); i++) {
                Animal a = participants.get(i);
                ConsoleIO.afficherMessage((i + 1) + ". " + a.getNom());
            }
        }
    }
}