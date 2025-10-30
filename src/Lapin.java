public class Lapin extends Animal {

    public Lapin(String nom, int âge, EtatSante etatSante) {
        super(nom, âge, etatSante);
    }

    public EtatSante getEtatSante() {
        EtatSante etatSante = EtatSante.SOIN_LEGER;
        return etatSante;
    }

    @Override
    public void bruit () {
        System.out.println("Honk Honk!");
    }

    @Override
    public void soinQuotidien() {
        System.out.println("nourrir");
    }
}
