package exodecorateur_angryballs.maladroit.vues;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Vector;


import exodecorateur_angryballs.maladroit.controllers.FinalSC;
import exodecorateur_angryballs.maladroit.controllers.StateController;
import exodecorateur_angryballs.maladroit.controllers.InitialSC;
import exodecorateur_angryballs.maladroit.modele.Bille;
import outilsvues.EcouteurTerminaison;

import outilsvues.Outils;

/**
 * Vue dessinant les billes et contenant les 3 boutons de contrôle (arrêt du programme, lancer les billes, arréter les billes)
 * <p>
 * ICI : IL N'Y A RIEN A CHANGER
 */
public class CadreAngryBalls extends Frame implements VueBillard, MouseListener, MouseMotionListener {
    public TextField présentation;
    public Billard billard;
    public Button lancerBilles, arrêterBilles;
    public Panel haut, centre, bas;

    public StateController currentController;
    public InitialSC initial;
    public FinalSC attrapee;

    public EcouteurTerminaison ecouteurTerminaison;

    public CadreAngryBalls(String titre, String message, Vector<Bille> billes) throws HeadlessException {
        super(titre);
        Outils.place(this, 0.33, 0.33, 0.5, 0.5);
        this.ecouteurTerminaison = new EcouteurTerminaison(this);


        this.haut = new Panel();
        this.haut.setBackground(Color.LIGHT_GRAY);
        this.add(this.haut, BorderLayout.NORTH);

        this.centre = new Panel();
        this.add(this.centre, BorderLayout.CENTER);

        this.bas = new Panel();
        this.bas.setBackground(Color.LIGHT_GRAY);
        this.add(this.bas, BorderLayout.SOUTH);

        this.présentation = new TextField(message, 100);
        this.présentation.setEditable(false);
        this.haut.add(this.présentation);

        this.billard = new Billard(billes);
        this.add(this.billard);

        this.lancerBilles = new Button("lancer les billes");
        this.bas.add(this.lancerBilles);
        this.arrêterBilles = new Button("arrêter les billes");
        this.bas.add(this.arrêterBilles);


        initial = new InitialSC(null, null, this);
        attrapee = new FinalSC(initial, null, this);
        initial.suivant = attrapee;
        currentController = initial;

        this.billard.addMouseListener(this);
        this.billard.addMouseMotionListener(this);
    }

    public double largeurBillard() {
        return this.billard.getWidth();
    }

    public double hauteurBillard() {
        return this.billard.getHeight();
    }

    @Override
    public void miseAJour() {
        this.billard.repaint();
    }

    /* (non-Javadoc)
     * @see exodecorateur.vues.VueBillard#montrer()
     */
    @Override
    public void montrer() {
        this.setVisible(true);
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

    public Vector<Bille> getBilles() {
       return billard.billes;
    }
}