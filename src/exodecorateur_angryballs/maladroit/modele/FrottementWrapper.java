package exodecorateur_angryballs.maladroit.modele;

import mesmaths.mecanique.MecaniquePoint;

import java.util.Vector;

public class FrottementWrapper extends BilleWrapper {

    public FrottementWrapper(Bille wrappedBille) {
        super(wrappedBille);
    }
    @Override
    public void gestionAcc�l�ration(Vector<Bille> billes) {
        super.gestionAcc�l�ration(billes);
        this.getAcceleration().ajoute(MecaniquePoint.freinageFrottement(this.masse(),this.getVitesse()));
    }

}
