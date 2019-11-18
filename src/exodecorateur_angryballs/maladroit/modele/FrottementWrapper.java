package exodecorateur_angryballs.maladroit.modele;

import mesmaths.mecanique.MecaniquePoint;

import java.util.Vector;

public class FrottementWrapper extends BilleWrapper {

    public FrottementWrapper(Bille wrappedBille) {
        super(wrappedBille);
    }
    @Override
    public void gestionAccélération(Vector<Bille> billes) {
        super.gestionAccélération(billes);
        this.getAcceleration().ajoute(MecaniquePoint.freinageFrottement(this.masse(),this.getVitesse()));
    }

}
