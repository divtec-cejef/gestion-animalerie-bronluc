public class Chien extends Animal {

    public Chien(String nom, int âge, EtatSante etatSante) {
        super(nom, âge, etatSante);
    }

    public EtatSante getEtatSante() {
        EtatSante etatSante = EtatSante.SOIN_INTENSIF;
        return etatSante;
    }

    @Override
    public void bruit () {
        System.out.println("Wouaf!");
    }

    @Override
    public void soinQuotidien() {
        System.out.println("Brosser");
    }
}
