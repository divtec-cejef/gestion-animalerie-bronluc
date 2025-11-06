import java.util.ArrayList;

public class Animalerie {
    private ArrayList<Animal> animaux;
    private ArrayList<Employe> employes;

    public Animalerie() {
        this.animaux = new ArrayList<>();
        this.employes = new ArrayList<>();
    }

    public void demarrer() {
        ConsoleIO.afficherBienvenue();

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
        int age = ConsoleIO.lireEntier("Âge (en années): ");

        int choixSante = ConsoleIO.lireEntier("\nÉtat de santé (1-3): ");
        ConsoleIO.afficherMenuEtatSante();

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
            ConsoleIO.afficherAnimal(i, a.getClass().getSimpleName(), a.getAge());
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
            ConsoleIO.afficherEmploye(i, e.getClass().getSimpleName());
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
}