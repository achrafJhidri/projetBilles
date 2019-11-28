package exodecorateur_angryballs.maladroit.controllers;

import java.awt.event.MouseEvent;
import java.util.Vector;

import exodecorateur_angryballs.maladroit.modele.balls.Bille;
import exodecorateur_angryballs.maladroit.modele.balls.BillePilotee;
import mesmaths.geometrie.base.Vecteur;

public class InitialSC extends StateController {

    public InitialSC(StateController suivant, StateManager cadreAngryBalls) {
        super(suivant,  cadreAngryBalls);

    }

    @Override
    public void mousePressed(MouseEvent event) {
        if (event.getButton() == MouseEvent.BUTTON1) {
            Vector<Bille> balles = this.stateManager.billes;
            for (int i = 0; i < balles.size(); ++i) {
                Bille bille = balles.get(i);
                Vecteur p = bille.getPosition();
                double r = bille.getRayon();
                if (appartient(p,r,new Vecteur(event.getX(),event.getY()))) {
                    this.bille = new BillePilotee(bille);
                    this.stateManager.billes.remove(bille);
                    this.stateManager.billes.add(this.bille);
                    this.stateManager.currentController = this.suivant;
                    return;
                }
            }
        }
    }

    public static boolean appartient(Vecteur c, double rayon, Vecteur p) {
        Vecteur d=c.difference(p);

        if (Math.abs(d.x)<=rayon && Math.abs(d.y)<=rayon)
            return true;
        return false;
    }



}
