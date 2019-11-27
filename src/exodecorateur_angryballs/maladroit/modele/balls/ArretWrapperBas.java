package exodecorateur_angryballs.maladroit.modele.balls;

import exodecorateur_angryballs.maladroit.modele.outilsModele.Collisions2;

public class ArretWrapperBas extends BilleWrapper{

	public ArretWrapperBas(Bille wrappedBille) {
		super(wrappedBille);
		// TODO Auto-generated constructor stub
	}
	@Override
    public void collisionContour(double abscisseCoinHautGauche, double ordonneeCoinHautGauche, double largeur, double hauteur) {
        Collisions2.collisionBilleContourAvecArretBas(this.getPosition(),this.getRayon(),this.getVitesse(), ordonneeCoinHautGauche, hauteur);
        super.collisionContour(abscisseCoinHautGauche, ordonneeCoinHautGauche,largeur, hauteur);
    }

}
