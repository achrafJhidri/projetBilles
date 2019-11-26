package exodecorateur_angryballs.maladroit.controllers;

import java.awt.event.MouseEvent;

import exodecorateur_angryballs.maladroit.modele.Bille;
import exodecorateur_angryballs.maladroit.modele.BillePilotee;
import exodecorateur_angryballs.maladroit.vues.CadreAngryBalls;
import mesmaths.geometrie.base.Vecteur;

public abstract class StateController {
	
	public StateController suivant;
	public StateController precedent;
	public CadreAngryBalls cadreAngryBalls; // liste billes
	BillePilotee bille  = null;

    
    
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
