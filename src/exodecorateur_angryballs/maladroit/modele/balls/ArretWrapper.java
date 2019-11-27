package exodecorateur_angryballs.maladroit.modele.balls;

import mesmaths.cinematique.Collisions;

public class ArretWrapper extends BilleWrapper {
    public ArretWrapper(Bille wrappedBille) {
        super(wrappedBille);
    }

    @Override
    public void collisionContour(double abscisseCoinHautGauche, double ordonn�eCoinHautGauche, double largeur, double hauteur) {
        Collisions.collisionBilleContourAvecArretHorizontal(this.getPosition(),this.getRayon(),this.getVitesse(),abscisseCoinHautGauche,largeur);
        Collisions.collisionBilleContourAvecArretVertical(this.getPosition(),this.getRayon(),this.getVitesse(), ordonn�eCoinHautGauche, hauteur);
        wrappedBille.collisionContour(abscisseCoinHautGauche, ordonn�eCoinHautGauche,largeur, hauteur);
    }
}
