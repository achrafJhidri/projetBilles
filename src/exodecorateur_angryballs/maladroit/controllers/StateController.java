package exodecorateur_angryballs.maladroit.controllers;

import java.awt.event.MouseEvent;

import exodecorateur_angryballs.maladroit.modele.balls.BillePilotee;
import exodecorateur_angryballs.maladroit.vues.CadreAngryBalls;

public abstract class StateController {
	
	public StateController suivant;

	public CadreAngryBalls cadreAngryBalls;
	BillePilotee bille  = null;

    
    
	public StateController(StateController suivant,  CadreAngryBalls cadreAngryBalls) {
		super();
		this.suivant = suivant;
;
		this.cadreAngryBalls = cadreAngryBalls;
	}
	public  void mousePressed(MouseEvent arg0){};
	public  void mouseReleased(MouseEvent arg0){} ;
	public  void mouseDragged(MouseEvent arg0){};


}
