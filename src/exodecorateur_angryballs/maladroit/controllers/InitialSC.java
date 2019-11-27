package exodecorateur_angryballs.maladroit.controllers;

import java.awt.event.MouseEvent;
import java.util.Vector;

import exodecorateur_angryballs.maladroit.modele.balls.Bille;
import exodecorateur_angryballs.maladroit.modele.balls.BillePilotee;
import exodecorateur_angryballs.maladroit.vues.CadreAngryBalls;
import mesmaths.geometrie.base.Vecteur;

public class InitialSC extends StateController {

    public InitialSC(StateController suivant,  CadreAngryBalls cadreAngryBalls) {
        super(suivant,  cadreAngryBalls);

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
                    this.bille = new BillePilotee(bille);
                    this.cadreAngryBalls.getBilles().remove(bille);
                    this.cadreAngryBalls.getBilles().add(this.bille);
                    this.cadreAngryBalls.currentController = this.suivant;
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
