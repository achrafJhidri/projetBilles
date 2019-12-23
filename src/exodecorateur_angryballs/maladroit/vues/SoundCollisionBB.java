package exodecorateur_angryballs.maladroit.vues;


import exodecorateur_angryballs.maladroit.controllers.Observable;

public class SoundCollisionBB extends Observable {
    private static SoundCollisionBB instance;


    private SoundCollisionBB(){
    }

    public static SoundCollisionBB getInstance() {
        if(instance == null)
            instance = new SoundCollisionBB();
        return instance;
    }

}
