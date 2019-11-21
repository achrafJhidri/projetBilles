package exodecorateur_angryballs.maladroit.controllers;

import java.awt.event.MouseEvent;
import java.util.Vector;

import exodecorateur_angryballs.maladroit.modele.Bille;
import exodecorateur_angryballs.maladroit.vues.CadreAngryBalls;
import mesmaths.geometrie.base.Vecteur;

public class ControleurBilleAtrapee extends ControleurEtatVueBillard{

	public ControleurBilleAtrapee(ControleurEtatVueBillard suivant, ControleurEtatVueBillard precedent,
			CadreAngryBalls cadreAngryBalls) {
		super(suivant, precedent, cadreAngryBalls);
		// TODO Auto-generated constructor stub
	}
	
	
	public void mousePressed(MouseEvent arg0) {}
	public void mouseReleased(MouseEvent event) {
		

	}

	@Override
	public void mouseDragged(MouseEvent event) {


			Vecteur d=new Vecteur(event.getX()-this.suivant.getX(),event.getY()-this.suivant.getY())	;
			time=System.currentTimeMillis();
			long delta = time - this.suivant.time;

			d.multiplie(1/(0.0000001+delta));


			Vecteur v=d;

			this.suivant  .setVitesse(v);


			this.cadreAngryBalls.currentController=this.suivant;


	}


}
