package exodecorateur_angryballs.maladroit.modele;

import  exodecorateur_angryballs.meilleurversion.modele.Collisions;


public class RebondWrapperBas extends RebondWrapper{

	public RebondWrapperBas(Bille wrappedBille) {
		super(wrappedBille);
		// TODO Auto-generated constructor stub
	}
	 @Override
	    public  void collisionContour(double abscisseCoinHautGauche, double ordonneeCoinHautGauche, double largeur, double hauteur) {
	       Collisions.collisionBilleContourAvecRebondBas(this.getPosition(),this.getRayon(),this.getVitesse(),abscisseCoinHautGauche, ordonneeCoinHautGauche,largeur, hauteur);

	        wrappedBille.collisionContour(abscisseCoinHautGauche, ordonneeCoinHautGauche,largeur, hauteur);
	    }

}
