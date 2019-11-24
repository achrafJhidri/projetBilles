package exodecorateur_angryballs.maladroit.controllers;

import java.awt.event.MouseEvent;

import exodecorateur_angryballs.maladroit.modele.Bille;
import exodecorateur_angryballs.maladroit.modele.BillePilotee;
import exodecorateur_angryballs.maladroit.vues.CadreAngryBalls;
import mesmaths.geometrie.base.Vecteur;

public class FinalSC extends StateController {

    public FinalSC(StateController suivant, StateController precedent,
                   CadreAngryBalls cadreAngryBalls) {
        super(suivant, precedent, cadreAngryBalls);
    }


    public void mousePressed(MouseEvent arg0) {
    }

    public void mouseReleased(MouseEvent event) {


    }

    @Override
    public void mouseDragged(MouseEvent event) {


        Vecteur distance = new Vecteur(event.getX() - this.suivant.bille.getPosition().x, event.getY() - this.suivant.bille.getPosition().y);


                distance.multiplie(1/this.suivant.bille.masse());
                BillePilotee b = new BillePilotee(this.suivant.bille,distance);


                this.cadreAngryBalls.getBilles().remove(this.suivant.bille);
                this.suivant.bille=b;
                this.cadreAngryBalls.getBilles().add(b);

                this.cadreAngryBalls.currentController = this.suivant;
                return;



    }


}
