public class Soigneur extends Employe {

    public Soigneur(String nom, String prenom, int salaire, String rôle) {
        super(nom, prenom, salaire, rôle);
    }

    public String getRôle() {
        String rôle = "Soigneur";
        return rôle;
    }

    @Override
    public void effectuerTache(Animal animal) {
        System.out.println("soin quotidien");
    }
}
