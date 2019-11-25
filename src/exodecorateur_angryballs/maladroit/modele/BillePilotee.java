package exodecorateur_angryballs.maladroit.modele;

import mesmaths.geometrie.base.Vecteur;

import javax.swing.text.WrappedPlainView;
import java.util.Vector;

public class BillePilotee extends BilleWrapper {
    private Vecteur force;

    public BillePilotee(Bille wrappedBille, Vecteur force) {
        super(wrappedBille);
        this.force = force;
    }

    public void setForce(Vecteur f){
        force = f ;
    }
    @Override
    public void gestionAccélération(Vector<Bille> billes) {
        super.gestionAccélération(billes);

        //getAcceleration().ajoute(force);
        setAcceleration(force);


    }
}
