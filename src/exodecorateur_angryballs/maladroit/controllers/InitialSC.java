package exodecorateur_angryballs.maladroit.controllers;

import java.awt.event.MouseEvent;
import java.util.Vector;

import exodecorateur_angryballs.maladroit.modele.Bille;
import exodecorateur_angryballs.maladroit.modele.BillePilotee;
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
                Vecteur p = bille.getPosition();
                double r = bille.getRayon();
                if (appartient(p,r,new Vecteur(event.getX(),event.getY()))) {
                    this.bille = new BillePilotee(bille, Vecteur.VECTEURNUL);
                    this.cadreAngryBalls.getBilles().remove(bille);
                    this.cadreAngryBalls.getBilles().add(this.bille);
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

    public static boolean appartient(Vecteur c, double rayon, Vecteur p) {
        Vecteur d=c.difference(p);

        if (Math.abs(d.x)<=rayon && Math.abs(d.y)<=rayon)
            return true;
        return false;
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
