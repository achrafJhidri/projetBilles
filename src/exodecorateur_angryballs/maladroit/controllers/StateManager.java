package exodecorateur_angryballs.maladroit.controllers;

import exodecorateur_angryballs.maladroit.modele.balls.Bille;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Vector;

public class StateManager implements MouseMotionListener , MouseListener {
    public StateController currentController;
    public InitialSC initial;
    public FinalSC attrapee;
    public Vector<Bille> billes;


    public StateManager(Vector<Bille> billes) {
        this.billes = billes;
        initial = new InitialSC(null,  this);
        attrapee = new FinalSC(initial,  this);
        initial.suivant = attrapee;
        currentController = initial;
    }




    @Override
    public void mouseClicked(MouseEvent mouseEvent) {


    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        currentController.mousePressed(mouseEvent);
    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
        currentController.mouseReleased(mouseEvent);
    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseDragged(MouseEvent mouseEvent) {
        currentController.mouseDragged(mouseEvent);
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {

    }
}
