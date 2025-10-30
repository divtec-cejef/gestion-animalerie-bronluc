public abstract class Animal {
    private String nom;
    private int âge;
    private EtatSante etatSante;

    public Animal(String nom, int âge,  EtatSante etatSante) {
        this.nom = nom;
        this.âge = âge;
        this.etatSante = etatSante;
    }

    public abstract void bruit();

    public abstract void soinQuotidien();
}
