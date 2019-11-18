package exodecorateur_angryballs.maladroit.modele;

import java.util.Vector;

public class NewtonWrapper extends BilleWrapper {
    public NewtonWrapper(Bille wrappedBille) {
        super(wrappedBille);
    }



    @Override
    public void gestionAccélération(Vector<Bille> billes){
        super.gestionAccélération(billes);
        this.getAcceleration().ajoute(OutilsBille.gestionAccélérationNewton(this, billes));
    };
}
