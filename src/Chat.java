public class Chat extends Animal {

    public Chat(String nom, int âge, EtatSante etatSante) {
        super(nom, âge, etatSante);
    }

    public EtatSante getEtatSante() {
        EtatSante etatSante = EtatSante.SOIN;
        return etatSante;
    }

    @Override
    public void bruit () {
        System.out.println("Miaou!");
    }

    @Override
    public void soinQuotidien() {
     System.out.println("caresser");
    }
}
