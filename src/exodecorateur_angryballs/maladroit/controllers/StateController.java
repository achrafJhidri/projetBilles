package exodecorateur_angryballs.maladroit.controllers;

import java.awt.event.MouseEvent;

import exodecorateur_angryballs.maladroit.modele.balls.BillePilotee;
import exodecorateur_angryballs.maladroit.vues.CadreAngryBalls;

public abstract class StateController {
	
	public StateController suivant;

	public StateManager stateManager;
	BillePilotee bille  = null;

    
    
	public StateController(StateController suivant,  StateManager stateManager) {
		super();
		this.suivant = suivant;
;
		this.stateManager = stateManager;
	}
	public  void mousePressed(MouseEvent arg0){};
	public  void mouseReleased(MouseEvent arg0){} ;
	public  void mouseDragged(MouseEvent arg0){};


}
