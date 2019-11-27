package exodecorateur_angryballs.maladroit.modele.balls;

import exodecorateur_angryballs.maladroit.modele.outilsModele.Collisions2;

public class RebondWrapper extends BilleWrapper {
    public RebondWrapper(Bille wrappedBille) {
        super(wrappedBille);
    }
    @Override
    public void collisionContour(double abscisseCoinHautGauche, double ordonn�eCoinHautGauche, double largeur, double hauteur) {

        super.collisionContour(abscisseCoinHautGauche, ordonn�eCoinHautGauche,largeur, hauteur);
        Collisions2.getInstance().collisionBilleContourAvecRebond(this.getPosition(),this.getRayon(),this.getVitesse(),abscisseCoinHautGauche, ordonn�eCoinHautGauche,largeur, hauteur);
    }
}
