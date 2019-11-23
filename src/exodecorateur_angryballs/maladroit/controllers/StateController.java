package exodecorateur_angryballs.maladroit.controllers;

import java.awt.event.MouseEvent;

import exodecorateur_angryballs.maladroit.vues.CadreAngryBalls;
import mesmaths.geometrie.base.Vecteur;

public abstract class StateController {
	
	public StateController suivant;
	public StateController precedent;
	public CadreAngryBalls cadreAngryBalls;
    long time=-1;
	int key = -1 ;
	Vecteur point = Vecteur.VECTEURNUL;
    
    
	public StateController(StateController suivant, StateController precedent, CadreAngryBalls cadreAngryBalls) {
		super();
		this.suivant = suivant;
		this.precedent = precedent;
		this.cadreAngryBalls = cadreAngryBalls;
	}
	public abstract void mousePressed(MouseEvent arg0);
	public abstract void mouseReleased(MouseEvent arg0) ;
	public abstract void mouseDragged(MouseEvent arg0);


}
