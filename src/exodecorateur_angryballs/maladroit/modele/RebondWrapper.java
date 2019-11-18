package exodecorateur_angryballs.maladroit.modele;

import mesmaths.cinematique.Collisions;

public class RebondWrapper extends BilleWrapper {
    public RebondWrapper(Bille wrappedBille) {
        super(wrappedBille);
    }
    @Override
    public void collisionContour(double abscisseCoinHautGauche, double ordonnéeCoinHautGauche, double largeur, double hauteur) {
       Collisions.collisionBilleContourAvecRebond(this.getPosition(),this.getRayon(),this.getVitesse(),abscisseCoinHautGauche, ordonnéeCoinHautGauche,largeur, hauteur);
        wrappedBille.collisionContour(abscisseCoinHautGauche, ordonnéeCoinHautGauche,largeur, hauteur);
    }
}
