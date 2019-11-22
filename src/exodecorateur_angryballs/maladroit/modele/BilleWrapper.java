package exodecorateur_angryballs.maladroit.modele;

import mesmaths.geometrie.base.Vecteur;

import java.awt.*;
import java.util.Vector;

public abstract class BilleWrapper implements Bille {
    protected Bille wrappedBille;

    BilleWrapper(Bille wrappedBille){
        this.wrappedBille = wrappedBille;
    }
    @Override
    public Vecteur getPosition() {
        return wrappedBille.getPosition();
    }

    @Override
    public double getRayon() {
        return wrappedBille.getRayon();
    }

    @Override
    public Vecteur getAcceleration() {
        return wrappedBille.getAcceleration();
    }
    @Override
    public void setAcceleration(Vecteur a){
        wrappedBille.setAcceleration(a);
    }

    @Override
    public int getClef() {
        return wrappedBille.getClef();
    }

    @Override
    public double masse() {
         return wrappedBille.masse();
    }


    @Override
    public Vecteur getVitesse() {
        return wrappedBille.getVitesse();
    }

    public @Override void setVitesse(Vecteur v){ wrappedBille.setVitesse(v);}

    @Override
    public void d�placer(double deltaT) {
            wrappedBille.d�placer(deltaT);
    }

      @Override
    public void gestionAcc�l�ration(Vector<Bille> billes) {
        wrappedBille.gestionAcc�l�ration(billes);
    }

    @Override
    public void collisionContour(double abscisseCoinHautGauche, double ordonn�eCoinHautGauche, double largeur, double hauteur) {
        wrappedBille.collisionContour(abscisseCoinHautGauche, ordonn�eCoinHautGauche,largeur, hauteur);
    }

    @Override
    public boolean gestionCollisionBilleBille(Vector<Bille> billes) {
        return wrappedBille.gestionCollisionBilleBille(billes);
    }


    @Override
    public void dessine(Graphics g) {
            wrappedBille.dessine(g);
    }
}
