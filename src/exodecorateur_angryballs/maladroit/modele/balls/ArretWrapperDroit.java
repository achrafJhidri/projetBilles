package exodecorateur_angryballs.maladroit.modele.balls;

import exodecorateur_angryballs.maladroit.modele.outilsModele.Collisions2;

public class ArretWrapperDroit extends ArretWrapper{

	public ArretWrapperDroit(Bille wrappedBille) {
		super(wrappedBille);
		// TODO Auto-generated constructor stub
	}
	@Override
    public void collisionContour(double abscisseCoinHautGauche, double ordonneeCoinHautGauche, double largeur, double hauteur) {
        Collisions2.collisionBilleContourAvecArretDroit(this.getPosition(),this.getRayon(),this.getVitesse(), ordonneeCoinHautGauche, largeur);
        wrappedBille.collisionContour(abscisseCoinHautGauche, ordonneeCoinHautGauche,largeur, hauteur);
    }
}