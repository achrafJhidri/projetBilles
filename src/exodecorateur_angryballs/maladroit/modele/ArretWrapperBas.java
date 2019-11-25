package exodecorateur_angryballs.maladroit.modele;

import  exodecorateur_angryballs.meilleurversion.modele.Collisions;

public class ArretWrapperBas extends ArretWrapper{

	public ArretWrapperBas(Bille wrappedBille) {
		super(wrappedBille);
		// TODO Auto-generated constructor stub
	}
	@Override
    public void collisionContour(double abscisseCoinHautGauche, double ordonneeCoinHautGauche, double largeur, double hauteur) {
    Collisions.collisionBilleContourAvecArretBas(this.getPosition(),this.getRayon(),this.getVitesse(), ordonneeCoinHautGauche, hauteur);
        wrappedBille.collisionContour(abscisseCoinHautGauche, ordonneeCoinHautGauche,largeur, hauteur);
    }

}
