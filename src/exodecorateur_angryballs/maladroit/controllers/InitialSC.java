package exodecorateur_angryballs.maladroit.controllers;

import java.awt.event.MouseEvent;
import java.util.Vector;

import exodecorateur_angryballs.maladroit.modele.Bille;
import exodecorateur_angryballs.maladroit.vues.CadreAngryBalls;
import mesmaths.geometrie.base.Vecteur;

public class InitialSC extends StateController {

	public InitialSC(StateController suivant, StateController precedent,
					 CadreAngryBalls cadreAngryBalls) {
		super(suivant, precedent, cadreAngryBalls);

	}

	@Override
	public void mousePressed(MouseEvent event) {

	if(event.getButton()==MouseEvent.BUTTON1) {
		Vector<Bille> balles = this.cadreAngryBalls.getBilles();
		for (int i = 0; i < balles.size(); ++i) {
			Bille bille = balles.get(i);
			if (isInsideBall(event,bille))
			{
				key = balles.get(i).getClef();
				point = new Vecteur(event.getX(),event.getY());
				return;
			}
		}
		}
	}

	private boolean isInsideBall(MouseEvent event,Bille b) {
		double rayon  =  b.getRayon();
		Vecteur position = b.getPosition();
		return (position.x - rayon <= event.getX() && event.getX() <= position.x +rayon)  &&
				(position.y -rayon <= event.getY() && event.getY() <= position.y + rayon);
	}


	@Override
	public void mouseReleased(MouseEvent arg0) {
		key = -1;
		point = Vecteur.VECTEURNUL;
		
	}

	@Override
	public void mouseDragged(MouseEvent event) {
		if ( key != -1 &&	point != Vecteur.VECTEURNUL ) {
			this.cadreAngryBalls.currentController = this.suivant;
		}
	}


}
