package exodecorateur_angryballs.maladroit.modele;

import  exodecorateur_angryballs.meilleurversion.modele.Collisions;


public class PasseMurailleBas extends PasseMuraille{

	public PasseMurailleBas(Bille wrappedBille) {
		super(wrappedBille);
		// TODO Auto-generated constructor stub
	}
	   @Override
	    public void collisionContour(double abscisseCoinHautGauche, double ordonneeCoinHautGauche, double largeur, double hauteur) {
	        Collisions.collisionBilleContourPasseMurailleBas(this.getPosition(),ordonneeCoinHautGauche,hauteur);

	        wrappedBille.collisionContour(abscisseCoinHautGauche, ordonneeCoinHautGauche,largeur, hauteur);
	    }
}
