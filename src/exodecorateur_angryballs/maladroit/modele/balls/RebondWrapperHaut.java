package exodecorateur_angryballs.maladroit.modele.balls;


import exodecorateur_angryballs.maladroit.modele.outilsModele.Collisions2;

public class RebondWrapperHaut extends RebondWrapper{

	public RebondWrapperHaut(Bille wrappedBille) {
		super(wrappedBille);
		// TODO Auto-generated constructor stub
	}

	 @Override
	    public  void collisionContour(double abscisseCoinHautGauche, double ordonneeCoinHautGauche, double largeur, double hauteur) {
		 Collisions2.getInstance().collisionBilleContourAvecRebondHaut(this.getPosition(),this.getRayon(),this.getVitesse(),abscisseCoinHautGauche, ordonneeCoinHautGauche,largeur, hauteur);

	        wrappedBille.collisionContour(abscisseCoinHautGauche, ordonneeCoinHautGauche,largeur, hauteur);
	    }
}
