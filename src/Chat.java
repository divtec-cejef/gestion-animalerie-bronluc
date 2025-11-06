public class Chat extends Animal {

    public Chat(String nom, int âge, EtatSante etatSante) {
        super(nom, âge, etatSante);
    }

    public EtatSante getEtatSante() {
        EtatSante etatSante = EtatSante.SAIN;
        return etatSante;
    }

    @Override
    public void bruit() {
        ConsoleIO.bruitChat();
    }

    @Override
    public void soinQuotidien() {
     ConsoleIO.soinQuotidienChat();
    }
}
