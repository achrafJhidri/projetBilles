package exodecorateur_angryballs.maladroit.modele.balls;

import mesmaths.geometrie.base.Vecteur;

import java.util.Vector;

public class BillePilotee extends BilleWrapper {
    private Vecteur force=Vecteur.VECTEURNUL;

    public BillePilotee(Bille wrappedBille) {
        super(wrappedBille);

    }

    public void setForce(Vecteur f){
        force = f ;
    }
    @Override
    public void gestionAccélération(Vector<Bille> billes) {
        super.gestionAccélération(billes);
        force.multiplie(1/masse());
        setAcceleration(force);


    }
}
