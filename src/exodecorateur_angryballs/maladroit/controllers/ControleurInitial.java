package exodecorateur_angryballs.maladroit.controllers;

import java.awt.event.MouseEvent;
import java.util.Vector;

import exodecorateur_angryballs.maladroit.modele.Bille;
import exodecorateur_angryballs.maladroit.vues.CadreAngryBalls;
import mesmaths.geometrie.base.Vecteur;

public class ControleurInitial extends ControleurEtatVueBillard{

	public ControleurInitial(ControleurEtatVueBillard suivant, ControleurEtatVueBillard precedent,
			CadreAngryBalls cadreAngryBalls) {
		super(suivant, precedent, cadreAngryBalls);

	}

	@Override
	public void mousePressed(MouseEvent event) {

	if(event.getButton()==MouseEvent.BUTTON1) {
		Vector<Bille> balles = this.cadreAngryBalls.getBilles();
		for (int i = 0; i < balles.size(); ++i) {
			Vecteur p = balles.get(i).getPosition();
			double r = balles.get(i).getRayon();

			if ((p.x - r <= event.getX() && event.getX() <= p.x + r)  &&
					(p.y - r <= event.getY() && event.getY() <= p.y + r))
			{
				time = System.currentTimeMillis();
				key = balles.get(i).getClef();
				point = new Vecteur(event.getX(),event.getY());
				return;
			}
		}
		}
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
