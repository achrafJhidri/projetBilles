package exodecorateur_angryballs.maladroit.modele.balls;


import exodecorateur_angryballs.maladroit.modele.outilsModele.Collisions2;

public class PasseMurailleHaut extends PasseMuraille{

	public PasseMurailleHaut(Bille wrappedBille) {
		super(wrappedBille);
		// TODO Auto-generated constructor stub
	}
	   @Override
	    public void collisionContour(double abscisseCoinHautGauche, double ordonneeCoinHautGauche, double largeur, double hauteur) {
	        Collisions2.collisionBilleContourPasseMurailleHaut(this.getPosition(),ordonneeCoinHautGauche,hauteur);
	 
	        wrappedBille.collisionContour(abscisseCoinHautGauche, ordonneeCoinHautGauche,largeur, hauteur);
	    }
}
