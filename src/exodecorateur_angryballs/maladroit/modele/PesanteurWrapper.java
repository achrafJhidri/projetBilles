package exodecorateur_angryballs.maladroit.modele;

import mesmaths.geometrie.base.Vecteur;

import java.util.Vector;

public class PesanteurWrapper extends BilleWrapper {
    private Vecteur pesanteur;

    public PesanteurWrapper(Bille wrappedBille, Vecteur pesanteur) {
        super(wrappedBille);
        this.pesanteur=pesanteur;
    }




    @Override
    public void gestionAcc�l�ration(Vector<Bille> billes){
        super.gestionAcc�l�ration(billes);
        this.getAcceleration().ajoute(this.pesanteur);
    }
}
