package exodecorateur_angryballs.maladroit.modele.outilsModele;

import mesmaths.geometrie.base.Vecteur;

public class Collision {
    public float chocdintensiste ;
    public Vecteur position ;
    public COLLISIONTYPE collisiontype ;

    public Collision(float chocdintensiste, Vecteur position,COLLISIONTYPE type) {
        this.chocdintensiste = chocdintensiste;
        this.position = position;
        this.collisiontype= type;
    }

}
