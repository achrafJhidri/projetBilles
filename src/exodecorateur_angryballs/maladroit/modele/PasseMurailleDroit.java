package exodecorateur_angryballs.maladroit.modele;

import  exodecorateur_angryballs.meilleurversion.modele.Collisions;


public class PasseMurailleDroit extends PasseMuraille{

	public PasseMurailleDroit(Bille wrappedBille) {
		super(wrappedBille);
		// TODO Auto-generated constructor stub
	}
	   @Override
	    public void collisionContour(double abscisseCoinHautGauche, double ordonneeCoinHautGauche, double largeur, double hauteur) {
	        
	        Collisions.collisionBilleContourPasseMurailleDroit(this.getPosition(), abscisseCoinHautGauche, largeur);
	        wrappedBille.collisionContour(abscisseCoinHautGauche, ordonneeCoinHautGauche,largeur, hauteur);
	    }

}
