package exodecorateur_angryballs.maladroit.vues;


import exodecorateur_angryballs.maladroit.controllers.Observable;

public class SoundCollisionContour extends Observable {
    private static SoundCollisionContour instance;


    private SoundCollisionContour(){
    }

    public static SoundCollisionContour getInstance() {
        if(instance == null)
            instance = new SoundCollisionContour();
        return instance;
    }

}
