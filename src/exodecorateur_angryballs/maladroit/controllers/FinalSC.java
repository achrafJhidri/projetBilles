package exodecorateur_angryballs.maladroit.controllers;

import java.awt.event.MouseEvent;

import exodecorateur_angryballs.maladroit.modele.balls.Bille;
import exodecorateur_angryballs.maladroit.vues.CadreAngryBalls;
import mesmaths.geometrie.base.Vecteur;

public class FinalSC extends StateController {

    public FinalSC(StateController suivant,
                   CadreAngryBalls cadreAngryBalls) {
        super(suivant, cadreAngryBalls);
    }

    public void mouseReleased(MouseEvent event) {
        if (this.suivant.bille != null) {
            Bille nextBille = this.suivant.bille.getWrappedBille();
            this.cadreAngryBalls.getBilles().remove(this.suivant.bille);
            this.cadreAngryBalls.getBilles().add(nextBille);
            this.suivant.bille = null;
            this.cadreAngryBalls.currentController = this.suivant;
            return;
        }

    }

    @Override
    public void mouseDragged(MouseEvent event) {
        Vecteur distance = new Vecteur(event.getX() - this.suivant.bille.getPosition().x, event.getY() - this.suivant.bille.getPosition().y);
        distance.multiplie(1 / this.suivant.bille.masse());
        this.suivant.bille.setForce(distance);
    }


}
