package exodecorateur_angryballs.maladroit.vues;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Vector;


import exodecorateur_angryballs.maladroit.controllers.FinalSC;
import exodecorateur_angryballs.maladroit.Interupteur;
import exodecorateur_angryballs.maladroit.controllers.StateController;
import exodecorateur_angryballs.maladroit.controllers.InitialSC;
import exodecorateur_angryballs.maladroit.modele.balls.Bille;
import outilsvues.EcouteurTerminaison;

import outilsvues.Outils;

/**
 * Vue dessinant les billes et contenant les 3 boutons de contr�le (arr�t du programme, lancer les billes, arr�ter les billes)
 * <p>
 * ICI : IL N'Y A RIEN A CHANGER
 */
public class CadreAngryBalls extends Frame implements VueBillard {
    public TextField pr�sentation;
    public Billard billard;
    public MyButton lancerBilles, arr�terBilles;
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

        this.pr�sentation = new TextField(message, 100);
        this.pr�sentation.setEditable(false);
        this.haut.add(this.pr�sentation);

        this.billard = new Billard(billes);
        this.add(this.billard);

        this.lancerBilles = new MyButton("lancer les billes", Interupteur.LANCER);
        this.bas.add(this.lancerBilles.button);
        this.arr�terBilles = new MyButton("arr�ter les billes",Interupteur.ARRETER);
        this.bas.add(this.arr�terBilles.button);



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




    public Vector<Bille> getBilles() {
       return billard.billes;
    }
}