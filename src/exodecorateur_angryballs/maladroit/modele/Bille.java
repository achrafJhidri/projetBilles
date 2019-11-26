package exodecorateur_angryballs.maladroit.modele;

import mesmaths.geometrie.base.Vecteur;


import java.util.Vector;

public interface Bille {
    Vecteur getPosition();
    double getRayon();
    Vecteur getAcceleration();
    void setAcceleration(Vecteur a);
    int getClef();
    double masse();
    Vecteur getVitesse();
    void setVitesse(Vecteur v);
    void déplacer(double deltaT);
    void gestionAccélération(Vector<Bille> billes);
    boolean gestionCollisionBilleBille(Vector<Bille> billes);
    void collisionContour(double abscisseCoinHautGauche,double ordonnéeCoinHautGauche,double largeur,double hauteur);
    void dessine(Dessinateur g);
    Bille getWrappedBille();
    @Override
    String toString();

    Color getCouleur();
}
