package exodecorateur_angryballs.maladroit.modele;

import mesmaths.cinematique.Collisions;

public class PasseMuraille extends BilleWrapper {
    public PasseMuraille(Bille wrappedBille) {
        super(wrappedBille);
    }

    @Override
    public void collisionContour(double abscisseCoinHautGauche, double ordonn�eCoinHautGauche, double largeur, double hauteur) {
        Collisions.collisionBilleContourPasseMuraille(this.getPosition(),abscisseCoinHautGauche,ordonn�eCoinHautGauche,largeur,hauteur);
        wrappedBille.collisionContour(abscisseCoinHautGauche, ordonn�eCoinHautGauche,largeur, hauteur);
    }
}
