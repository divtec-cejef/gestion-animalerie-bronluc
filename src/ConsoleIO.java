import java.util.Scanner;

public class ConsoleIO {
    private static Scanner scanner = new Scanner(System.in);

    // ============= MÉTHODES D'AFFICHAGE =============

    public static void afficherMessage(String message) {
        System.out.println(message);
    }

    public static void afficherErreur(String erreur) {
        System.err.println("ERREUR: " + erreur);
    }

    // ============= MÉTHODES DE SAISIE =============

    public static int lireEntier(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            scanner.next();
            System.err.println("Veuillez entrer un nombre valide.");
            System.out.print(prompt);
        }
        int valeur = scanner.nextInt();
        scanner.nextLine();
        return valeur;
    }

    public static String lireChaine(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    // ============= MESSAGES DE BIENVENUE =============

    public static void afficherBienvenue() {
        System.out.println("Bienvenue dans le système de gestion d'animalerie !\n");
    }

    public static void afficherAuRevoir() {
        System.out.println("\nAu revoir et à bientôt !");
    }

    // ============= MENU =============

    public static void afficherMenu() {
        System.out.println("  1. Ajouter un animal");
        System.out.println("  2. Supprimer un animal");
        System.out.println("  3. Lister les animaux");
        System.out.println("  4. Ajouter un employé");
        System.out.println("  5. Supprimer un employé");
        System.out.println("  6. Lister les employés");
        System.out.println("  7. Effectuer une tâche");
        System.out.println("  0. Quitter");
    }

    public static void afficherChoixInvalide() {
        afficherErreur("Choix invalide. Veuillez choisir entre 0 et 7.");
    }

    // ============= ANIMAUX - BRUITS =============

    public static void bruitChien() {
        System.out.println("Waouf !");
    }

    public static void bruitChat() {
        System.out.println("Miaou !");
    }

    public static void bruitLapin() {
        System.out.println("Couic couic !");
    }

    // ============= ANIMAUX - SOINS QUOTIDIENS =============

    public static void soinQuotidienChien() {
        System.out.println("Brosser");
    }

    public static void soinQuotidienChat() {
        System.out.println("Caresser");
    }

    public static void soinQuotidienLapin() {
        System.out.println("Nourrir");
    }

    public static void afficherNouvelEtatSante(EtatSante nouvelEtat) {
        System.out.println("Nouvel état de santé : " + nouvelEtat);
    }

    public static void afficherSanteDejaSain() {
        System.out.println("L'animal est déjà en parfaite santé ! ✨");
    }

    // ============= AJOUT ANIMAL =============

    public static void afficherTitreAjoutAnimal() {
        System.out.println("\n--- Ajouter un animal ---");
    }

    public static void afficherMenuTypesAnimaux() {
        System.out.println(" 1. Chien");
        System.out.println(" 2. Chat");
        System.out.println(" 3. Lapin");
    }

    public static void afficherAnimalAjoute(String nom) {
        System.out.println( nom + " a été ajouté avec succès !");
    }

    public static void afficherTypeAnimalInvalide() {
        afficherErreur("Type d'animal invalide.");
    }

    public static void afficherMenuEtatSante(){
        System.out.println(" 1. Sain");
        System.out.println(" 2. Soin léger");
        System.out.println(" 3. Soin intensif");
    }

    // ============= SUPPRESSION ANIMAL =============

    public static void afficherAucunAnimalASupprimer() {
        afficherErreur("Aucun animal à supprimer.");
    }

    public static void afficherAnimalSupprime() {
        System.out.println("Animal retiré de l'animalerie.");
    }

    public static void afficherIndexAnimalInvalide(int max) {
        afficherErreur("Index invalide. Veuillez choisir entre 0 et " + max);
    }

    // ============= LISTE ANIMAUX =============

    public static void afficherAucunAnimal() {
        System.out.println("\nAucun animal dans l'animalerie.");
    }

    public static void afficherTitreListeAnimaux() {
        System.out.println("\n=== Liste des animaux ===");
    }

    public static void afficherAnimal(int index, String type, int age) {
        System.out.println("[" + index + "] " + type + " - " + age + " ans");
    }

    // ============= AJOUT EMPLOYÉ =============

    public static void afficherTitreAjoutEmploye() {
        System.out.println("\n--- Ajouter un employé ---");
    }

    public static void afficherMenuTypesEmployes() {
        System.out.println("1. Soigneur");
        System.out.println("2. Vétérinaire");
    }

    public static void afficherEmployeAjoute(String prenom, String nom) {
        System.out.println(prenom + " " + nom + " a été embauché(e) !");
    }

    public static void afficherTypeEmployeInvalide() {
        afficherErreur("Type d'employé invalide.");
    }

    // ============= SUPPRESSION EMPLOYÉ =============

    public static void afficherAucunEmployeASupprimer() {
        afficherErreur("Aucun employé à supprimer.");
    }

    public static void afficherEmployeSupprime() {
        System.out.println("Employé retiré.");
    }

    public static void afficherIndexEmployeInvalide(int max) {
        afficherErreur("Index invalide. Veuillez choisir entre 0 et " + max);
    }

    // ============= LISTE EMPLOYÉS =============

    public static void afficherAucunEmploye() {
        System.out.println("\nAucun employé.");
    }

    public static void afficherTitreListeEmployes() {
        System.out.println("\n=== Liste des employés ===");
    }

    public static void afficherEmploye(int index, String type) {
        System.out.println("[" + index + "] " + type);
    }

    // ============= EFFECTUER TÂCHE =============

    public static void afficherTitreEffectuerTache() {
        System.out.println("\n--- Effectuer une tâche ---");
    }

    public static void afficherAucunEmployeDisponible() {
        afficherErreur("Aucun employé disponible.");
    }

    public static void afficherAucunAnimalDisponible() {
        afficherErreur("Aucun animal disponible.");
    }

    public static void afficherIndexEmployeInvalide() {
        afficherErreur("Index employé invalide.");
    }

    public static void afficherIndexAnimalInvalide() {
        afficherErreur("Index animal invalide.");
    }

    public static void afficherTacheEffectuee() {
        System.out.println("Tâche effectuée avec succès !");
    }
}