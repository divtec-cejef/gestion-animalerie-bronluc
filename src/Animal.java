import java.util.ArrayList;
import java.util.List;

public abstract class Animal {
    private String nom;
    private int âge;
    private EtatSante sante;


    public Animal(String nom, int âge,  EtatSante etatSante) {
        this.nom = nom;
        this.âge = âge;
        this.sante = etatSante;
    }

    public int getAge() {
        return âge;
    }

    public String getNom() {
        return nom;
    }

    public EtatSante getSante() {
        return sante;
    }

    public void ameliorerSante() {
        if (sante == EtatSante.SOIN_INTENSIF) {
            sante = EtatSante.SOIN_LEGER;
        } else if (sante == EtatSante.SOIN_LEGER) {
            sante = EtatSante.SAIN;
        }else{
            ConsoleIO.afficherSanteDejaSain();
        }
        ConsoleIO.afficherNouvelEtatSante(sante);
    }

    public abstract void bruit();

    public abstract void soinQuotidien();

}
