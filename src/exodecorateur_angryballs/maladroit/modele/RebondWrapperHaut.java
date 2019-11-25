package exodecorateur_angryballs.maladroit.modele;


import  exodecorateur_angryballs.meilleurversion.modele.Collisions;


public class RebondWrapperHaut extends RebondWrapper{

	public RebondWrapperHaut(Bille wrappedBille) {
		super(wrappedBille);
		// TODO Auto-generated constructor stub
	}

	 @Override
	    public  void collisionContour(double abscisseCoinHautGauche, double ordonneeCoinHautGauche, double largeur, double hauteur) {
	       Collisions.collisionBilleContourAvecRebondHaut(this.getPosition(),this.getRayon(),this.getVitesse(),abscisseCoinHautGauche, ordonneeCoinHautGauche,largeur, hauteur);

	        wrappedBille.collisionContour(abscisseCoinHautGauche, ordonneeCoinHautGauche,largeur, hauteur);
	    }
}
