import java.util.*;

public class Concours {
    private String nom;
    private String lieu;
    private int capacité;

    public Concours(String nom, String lieu, int capacité) {
        this.nom = nom;
        this.lieu = lieu;
        this.capacité = capacité;
    }

        public String getNomConcours() {
            return nom;
        }

        public String getLieu() {
            return lieu;
        }

        public int getCapacité() {
            return capacité;
        }
}
