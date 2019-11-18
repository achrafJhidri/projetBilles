package exodecorateur_angryballs.maladroit.modele;

import java.util.Vector;

public class NewtonWrapper extends BilleWrapper {
    public NewtonWrapper(Bille wrappedBille) {
        super(wrappedBille);
    }



    @Override
    public void gestionAcc�l�ration(Vector<Bille> billes){
        super.gestionAcc�l�ration(billes);
        this.getAcceleration().ajoute(OutilsBille.gestionAcc�l�rationNewton(this, billes));
    };
}
