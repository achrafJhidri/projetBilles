package exodecorateur_angryballs.maladroit.controllers;



import java.util.ArrayList;
import java.util.List;

public abstract class Observable {
    List<Observateur> observateurs = new ArrayList<Observateur>();


    public void notify(Observable observable,Object o ){
        for(Observateur observateur : observateurs){
            observateur.update(this,o);
        }
    }


    public boolean addObservateur(Observateur observateur) {
        return observateurs.add(observateur);
    }
}
