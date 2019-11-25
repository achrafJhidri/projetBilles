package exodecorateur_angryballs.maladroit.modele;

import  exodecorateur_angryballs.meilleurversion.modele.Collisions;

public class ArretWrapperDroit extends ArretWrapper{

	public ArretWrapperDroit(Bille wrappedBille) {
		super(wrappedBille);
		// TODO Auto-generated constructor stub
	}
	@Override
    public void collisionContour(double abscisseCoinHautGauche, double ordonneeCoinHautGauche, double largeur, double hauteur) {
    Collisions.collisionBilleContourAvecArretDroit(this.getPosition(),this.getRayon(),this.getVitesse(), ordonneeCoinHautGauche, largeur);
        wrappedBille.collisionContour(abscisseCoinHautGauche, ordonneeCoinHautGauche,largeur, hauteur);
    }
}
