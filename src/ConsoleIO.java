import java.util.Scanner;

public class ConsoleIO {
    /**
     * Affiche le bruit du chien
     */
    public static void bruitChien() {
        System.out.println("Waouf !");
    }

    /**
     * Affiche le bruit du chat
     */
    public static void bruitChat() {
        System.out.println("Miaou !");
    }

    /**
     * Affiche le bruit du lapin
     */
    public static void bruitLapin() {
        System.out.println("Couic couic !");
    }

    public static void soinQuotidienChat() {
        System.out.println("Carresser");
    }

    public static void soinQuotidienLapin() {
        System.out.println("Nourrir");
    }

    public static void soinQuotidienChien() {
        System.out.println("Brosser");
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