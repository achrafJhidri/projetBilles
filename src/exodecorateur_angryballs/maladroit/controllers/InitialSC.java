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

        if (event.getButton() == MouseEvent.BUTTON1) {
            Vector<Bille> balles = this.cadreAngryBalls.getBilles();
            for (int i = 0; i < balles.size(); ++i) {
                Bille bille = balles.get(i);
                if (isInsideBall(event, bille)) {
                    this.bille = balles.get(i);
                    return;
                }
            }
        }
    }

    private boolean isInsideBall(MouseEvent event, Bille b) {
        double rayon = b.getRayon();
        Vecteur position = b.getPosition();
        return (position.x - rayon <= event.getX() && event.getX() <= position.x + rayon) &&
                (position.y - rayon <= event.getY() && event.getY() <= position.y + rayon);
    }


    @Override
    public void mouseReleased(MouseEvent arg0) {
        if (bille != null) {

                    Bille nextBille = this.bille.getWrappedBille();

                    this.cadreAngryBalls.getBilles().remove(this.bille);
                    this.cadreAngryBalls.getBilles().add(nextBille);
                    this.bille = null;

                    return;


        }


    }

    @Override
    public void mouseDragged(MouseEvent event) {
        if (bille != null) {
            this.cadreAngryBalls.currentController = this.suivant;
        }
    }


}
