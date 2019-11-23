package exodecorateur_angryballs.maladroit.controllers;

import java.awt.event.MouseEvent;
import java.util.Vector;

import exodecorateur_angryballs.maladroit.modele.Bille;
import exodecorateur_angryballs.maladroit.vues.CadreAngryBalls;
import mesmaths.geometrie.base.Vecteur;

public class ControleurBilleAtrapee extends ControleurEtatVueBillard {

    public ControleurBilleAtrapee(ControleurEtatVueBillard suivant, ControleurEtatVueBillard precedent,
                                  CadreAngryBalls cadreAngryBalls) {
        super(suivant, precedent, cadreAngryBalls);
        // TODO Auto-generated constructor stub
    }


    public void mousePressed(MouseEvent arg0) {
    }

    public void mouseReleased(MouseEvent event) {


    }

    @Override
    public void mouseDragged(MouseEvent event) {


        Vecteur distance = new Vecteur(event.getX() - this.suivant.point.x, event.getY() - this.suivant.point.y);
        Bille bille =this.cadreAngryBalls.getBilles().get(this.suivant.key);
        distance.multiplie(1/bille.masse());


      // getAcceleration().ajoute(distance);//

       bille.setAcceleration(distance);

        this.suivant.point.x= bille.getPosition().x;
        this.suivant.point.y=  bille.getPosition().y;


        this.cadreAngryBalls.currentController = this.suivant;


    }


}
