public class Soigneur extends Employe {

    public Soigneur(String nom, String prenom, int salaire, String rôle) {
        super(nom, prenom, salaire, rôle);
    }

    public String getRôle() {
        String rôle = "Soigneur";
        return rôle;
    }

    // Dans Soigneur.java
    @Override
    public void effectuerTache(Animal animal) {
        animal.soinQuotidien();  // ← Appelle la méthode de l'animal
    }
}
