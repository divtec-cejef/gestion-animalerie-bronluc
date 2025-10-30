public abstract class Employe {
    private String nom;
    private String prenom;
    private int salaire;
    private String rôle;

    public Employe(String nom, String prenom, int salaire, String rôle) {
        this.nom = nom;
        this.prenom = prenom;
        this.salaire = salaire;
        this.rôle = rôle;
    }

    public abstract void effectuerTache(Animal animal);
}
