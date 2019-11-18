package exodecorateur_angryballs.maladroit.modele;

import mesmaths.cinematique.Collisions;

public class RebondWrapper extends BilleWrapper {
    public RebondWrapper(Bille wrappedBille) {
        super(wrappedBille);
    }
    @Override
    public void collisionContour(double abscisseCoinHautGauche, double ordonn�eCoinHautGauche, double largeur, double hauteur) {
       Collisions.collisionBilleContourAvecRebond(this.getPosition(),this.getRayon(),this.getVitesse(),abscisseCoinHautGauche, ordonn�eCoinHautGauche,largeur, hauteur);
        wrappedBille.collisionContour(abscisseCoinHautGauche, ordonn�eCoinHautGauche,largeur, hauteur);
    }
}
