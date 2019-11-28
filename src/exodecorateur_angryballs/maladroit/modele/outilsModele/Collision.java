package exodecorateur_angryballs.maladroit.modele.outilsModele;

import mesmaths.geometrie.base.Vecteur;

public class Collision {
    public float intensity;
    public Vecteur position ;
    public COLLISIONTYPE collisiontype ;

    public Collision(float intensity, Vecteur position, COLLISIONTYPE type) {
        this.intensity = intensity;
        this.position = position;
        this.collisiontype= type;
    }

}
