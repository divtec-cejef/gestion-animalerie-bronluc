import java.util.Scanner;

public class ConsoleIO {
    private static Scanner scanner = new Scanner(System.in);

    /**
     * Affiche un message normal à l'utilisateur
     */
    public static void afficherMessage(String message) {
        System.out.println(message);
    }

    /**
     * Affiche un message d'erreur
     */
    public static void afficherErreur(String erreur) {
        System.err.println("ERREUR: " + erreur);
    }

    /**
     * Lit un entier avec validation automatique
     * Redemande tant que l'entrée n'est pas un nombre valide
     */
    public static int lireEntier(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            scanner.next(); // Consommer l'entrée invalide
            System.err.println("Veuillez entrer un nombre valide.");
            System.out.print(prompt);
        }
        int valeur = scanner.nextInt();
        scanner.nextLine(); // Consommer le retour à la ligne
        return valeur;
    }

    /**
     * Lit une chaîne de caractères
     */
    public static String lireChaine(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    /**
     * Affiche le menu principal de l'animalerie
     */
    public static void afficherMenu() {
        System.out.println("  1. Ajouter un animal");
        System.out.println("  2. Supprimer un animal");
        System.out.println("  3. Lister les animaux");
        System.out.println("  4. Ajouter un employé");
        System.out.println("  5. Supprimer un employé");
        System.out.println("  6. Lister les employés");
        System.out.println("  7. Effectuer une tâche");
        System.out.println("  0. Quitter");
        System.out.println("──────────────────────────────────────────");
    }
}