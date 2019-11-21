package exodecorateur_angryballs.maladroit.controllers;

import java.awt.event.MouseEvent;

import exodecorateur_angryballs.maladroit.modele.Bille;
import exodecorateur_angryballs.maladroit.vues.CadreAngryBalls;
import mesmaths.geometrie.base.Vecteur;

public abstract class ControleurEtatVueBillard{
	
	public ControleurEtatVueBillard suivant;
	public ControleurEtatVueBillard precedent;
	public CadreAngryBalls cadreAngryBalls;
    long time=-1;
    Bille bille = null;
    
    
	public ControleurEtatVueBillard(ControleurEtatVueBillard suivant, ControleurEtatVueBillard precedent, CadreAngryBalls cadreAngryBalls) {
		super();
		this.suivant = suivant;
		this.precedent = precedent;
		this.cadreAngryBalls = cadreAngryBalls;
	}
	public abstract void mousePressed(MouseEvent arg0);
	public abstract void mouseReleased(MouseEvent arg0) ;
	public abstract void mouseDragged(MouseEvent arg0);


	public  double getX(){
		return bille.getPosition().x;
	}


	public double  getY(){ return bille.getPosition().y; }

	public  void setVitesse(Vecteur v){
		bille.setVitesse(v);
	}


}
