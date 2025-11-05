public class Lapin extends Animal {

    public Lapin(String nom, int âge, EtatSante etatSante) {
        super(nom, âge, etatSante);
    }

    public EtatSante getEtatSante() {
        EtatSante etatSante = EtatSante.SOIN_LEGER;
        return etatSante;
    }

    @Override
    public void bruit() {
        ConsoleIO.bruitLapin();
    }

    @Override
    public void soinQuotidien() {
        ConsoleIO.soinQuotidienLapin();
    }
