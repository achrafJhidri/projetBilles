package exodecorateur_angryballs.maladroit.modele;

import  exodecorateur_angryballs.meilleurversion.modele.Collisions;


public class PasseMurailleGauche extends PasseMuraille{

	public PasseMurailleGauche(Bille wrappedBille) {
		super(wrappedBille);
		// TODO Auto-generated constructor stub
	}
	   @Override
	    public void collisionContour(double abscisseCoinHautGauche, double ordonneeCoinHautGauche, double largeur, double hauteur) {
	        
	        Collisions.collisionBilleContourPasseMurailleGauche(this.getPosition(), abscisseCoinHautGauche, largeur);
	        wrappedBille.collisionContour(abscisseCoinHautGauche, ordonneeCoinHautGauche,largeur, hauteur);

	   }
	   }
