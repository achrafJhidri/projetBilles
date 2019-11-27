package exodecorateur_angryballs.maladroit.modele.balls;

import exodecorateur_angryballs.maladroit.modele.outilsModele.Collisions2;

public class RebondWrapper extends BilleWrapper {
    public RebondWrapper(Bille wrappedBille) {
        super(wrappedBille);
    }
    @Override
    public void collisionContour(double abscisseCoinHautGauche, double ordonnéeCoinHautGauche, double largeur, double hauteur) {

        super.collisionContour(abscisseCoinHautGauche, ordonnéeCoinHautGauche,largeur, hauteur);
        Collisions2.getInstance().collisionBilleContourAvecRebond(this.getPosition(),this.getRayon(),this.getVitesse(),abscisseCoinHautGauche, ordonnéeCoinHautGauche,largeur, hauteur);
    }
}
