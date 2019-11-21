package exodecorateur_angryballs.maladroit.controllers;

import java.awt.event.MouseEvent;
import java.util.Vector;

import exodecorateur_angryballs.maladroit.modele.Bille;
import exodecorateur_angryballs.maladroit.vues.CadreAngryBalls;
import mesmaths.cinematique.Collisions;
import mesmaths.geometrie.base.Vecteur;

public class ControleurBilleAtrapee extends ControleurEtatVueBillard{

	public ControleurBilleAtrapee(ControleurEtatVueBillard suivant, ControleurEtatVueBillard precedent,
			CadreAngryBalls cadreAngryBalls) {
		super(suivant, precedent, cadreAngryBalls);
	}
	
	
	public void mousePressed(MouseEvent arg0) {}
	public void mouseReleased(MouseEvent event) {
		

	}

	@Override
	public void mouseDragged(MouseEvent event) {


			Vecteur d=new Vecteur(event.getX()-this.suivant.point.x,event.getY()-this.suivant.point.y)	;
			time=System.currentTimeMillis();
			long delta = time - this.suivant.time;

			d.multiplie(1/(Bille.EPSILON+delta));


			Vecteur v=d;

			this.cadreAngryBalls.getBilles().get(suivant.key).setVitesse(v);
			this.suivant.point=new Vecteur(event.getX(),event.getY());
			this.cadreAngryBalls.currentController=this.suivant;


	}


}
