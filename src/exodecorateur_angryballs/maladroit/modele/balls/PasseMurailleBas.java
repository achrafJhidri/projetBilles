package exodecorateur_angryballs.maladroit.modele.balls;


import exodecorateur_angryballs.maladroit.modele.outilsModele.Collisions2;

public class PasseMurailleBas extends PasseMuraille{

	public PasseMurailleBas(Bille wrappedBille) {
		super(wrappedBille);
		// TODO Auto-generated constructor stub
	}
	   @Override
	    public void collisionContour(double abscisseCoinHautGauche, double ordonneeCoinHautGauche, double largeur, double hauteur) {
		   Collisions2.collisionBilleContourPasseMurailleBas(this.getPosition(),ordonneeCoinHautGauche,hauteur);

	        wrappedBille.collisionContour(abscisseCoinHautGauche, ordonneeCoinHautGauche,largeur, hauteur);
	    }
}
