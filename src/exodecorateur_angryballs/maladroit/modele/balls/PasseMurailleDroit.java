package exodecorateur_angryballs.maladroit.modele.balls;


import exodecorateur_angryballs.maladroit.modele.outilsModele.Collisions2;

public class PasseMurailleDroit extends PasseMuraille{

	public PasseMurailleDroit(Bille wrappedBille) {
		super(wrappedBille);
		// TODO Auto-generated constructor stub
	}
	   @Override
	    public void collisionContour(double abscisseCoinHautGauche, double ordonneeCoinHautGauche, double largeur, double hauteur) {

		   Collisions2.collisionBilleContourPasseMurailleDroit(this.getPosition(), abscisseCoinHautGauche, largeur);
	        wrappedBille.collisionContour(abscisseCoinHautGauche, ordonneeCoinHautGauche,largeur, hauteur);
	    }

}
