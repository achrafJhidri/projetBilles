package exodecorateur_angryballs.maladroit.modele;

import mesmaths.cinematique.Collisions;

public class PasseMuraille extends BilleWrapper {
    public PasseMuraille(Bille wrappedBille) {
        super(wrappedBille);
    }

    @Override
    public void collisionContour(double abscisseCoinHautGauche, double ordonnéeCoinHautGauche, double largeur, double hauteur) {
        Collisions.collisionBilleContourPasseMuraille(this.getPosition(),abscisseCoinHautGauche,ordonnéeCoinHautGauche,largeur,hauteur);
        wrappedBille.collisionContour(abscisseCoinHautGauche, ordonnéeCoinHautGauche,largeur, hauteur);
    }
}
