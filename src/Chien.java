public class Chien extends Animal {

    public Chien(String nom, int âge, EtatSante etatSante) {
        super(nom, âge, etatSante);
    }

    public EtatSante getEtatSante() {
        EtatSante etatSante = EtatSante.SOIN_INTENSIF;
        return etatSante;
    }

    @Override
    public void bruit() {
        ConsoleIO.bruitChien();
    }

    @Override
    public void soinQuotidien() {
        ConsoleIO.soinQuotidienChien();
    }
}
