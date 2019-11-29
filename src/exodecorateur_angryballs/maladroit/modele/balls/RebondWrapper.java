package exodecorateur_angryballs.maladroit.modele.balls;

import exodecorateur_angryballs.maladroit.modele.outilsModele.Collision;
import exodecorateur_angryballs.maladroit.modele.outilsModele.Collisions;
import exodecorateur_angryballs.maladroit.vues.SoundCollisionContour;
import mesmaths.geometrie.base.Vecteur;

public class RebondWrapper extends BilleWrapper {
    public RebondWrapper(Bille wrappedBille) {
        super(wrappedBille);
    }
    @Override
    public void collisionContour(double abscisseCoinHautGauche, double ordonnéeCoinHautGauche, double largeur, double hauteur) {

        super.collisionContour(abscisseCoinHautGauche, ordonnéeCoinHautGauche,largeur, hauteur);
        double[] inout = new double[1];
        Vecteur position = this.getPosition();
        if(Collisions.collisionBilleContourAvecRebond(position,this.getRayon(),this.getVitesse(),abscisseCoinHautGauche, ordonnéeCoinHautGauche,largeur, hauteur,inout)){
            Collision collision = new Collision((float)inout[0],position);
            SoundCollisionContour.getInstance().notify(collision);
        }
    }
}
