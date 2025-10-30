public class Veterinaire extends Employe {

    public Veterinaire(String nom, String prenom, int salaire, String rôle) {
        super(nom, prenom, salaire, rôle);
    }

    public String getRôle() {
        String rôle = "Veterinaire";
        return rôle;
    }

    @Override
    public void effectuerTache(Animal animal) {
        System.out.println("améliorer santé");
    }
}
