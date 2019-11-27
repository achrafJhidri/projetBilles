package exodecorateur_angryballs.maladroit;

import exodecorateur_angryballs.maladroit.controllers.Observable;
import exodecorateur_angryballs.maladroit.controllers.Observateur;


public class MyAnimation implements Observateur {
    private AnimationBilles animateur ;

    public MyAnimation(AnimationBilles animateur) {
        this.animateur = animateur;
    }


    @Override
    public void update(Observable o, Object obj) {
            if ( obj instanceof Interupteur){
                Interupteur interupteur = (Interupteur) obj;
                if ( interupteur == Interupteur.ARRETER)
                    animateur.arrêterAnimation();
                else
                    animateur.lancerAnimation();
            }
    }
}
